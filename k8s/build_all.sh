#!/bin/bash

if ../animals-app/gradlew build buildDocker then
    #docker-compose up
    #docker-compose -f docker-compose-build.yml up --build

    #servicies:
    kubectl apply -f animals-app.yml
    kubectl apply -f city-service.yml
    kubectl apply -f counties-service.yml
    kubectl apply -f veterinarians-service.yml
    kubectl apply -f gateway.yml

    #frontend
    docker build -t frontend/animals-app-client-custom-nginx .
    kubectl apply -f frontend-nginx.yml

    #ingress up:
    kubectl apply -f ingress.yml
    kubectl apply -f ingress-configmap.yml

    kubectl describe ing ingress-service

    cd..
    cd resource-manifests

    openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout tls.key -out tls.crt -subj "/CN=microservices.my"
    kubectl create secret tls microservices.my-secret --key tls.key --cert tls.crt

#cd shopfront
#mvn clean install
#if docker build -t danielbryantuk/djshopfront . ; then
#  docker push danielbryantuk/djshopfront
#fi
#cd ..

#cd productcatalogue
#mvn clean install
#if docker build -t danielbryantuk/djproductcatalogue . ; then
#  docker push danielbryantuk/djproductcatalogue
#fi
#cd ..

#cd stockmanager
#mvn clean install
#if docker build -t danielbryantuk/djstockmanager . ; then
#  docker push danielbryantuk/djstockmanager
#fi
#cd ..