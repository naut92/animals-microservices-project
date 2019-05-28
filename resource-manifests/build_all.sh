#!/bin/bash

if ../animals-app/gradlew build buildDocker then
    docker-compose up
    docker-compose -f docker-compose-build.yml up --build

    kubectl create -f backend.yml
    kubectl create -f frontend.yml

    kubectl apply -f ambassador-service.yml
    kubectl apply -f https://getambassador.io/yaml/ambassador/ambassador-no-rbac.yaml


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