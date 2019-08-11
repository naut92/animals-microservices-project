initialize the cluster:
$ kubectl run -i -t stolonctl --image=sorintlab/stolon:master-pg10  --restart=Never --rm -- /usr/local/bin/stolonctl --cluster-name=kube-stolon --store-backend=kubernetes --kube-resource-kind=configmap init 

Имя кластера kube-stolon

$ kubectl apply -f stolon-sentinel.yml
$ kubectl apply -f secret.yml
$ kubectl apply -f stolon-keeper.yml
$ kubectl apply -f stolon-proxy.yml
$ kubectl apply -f stolon-proxy-service.yml
$ kubectl apply -f postgres-app-config.yml

$ kubectl get svc
$ kubectl -n default get services | fgrep proxy
$ kubectl -n default get pods -o wide

#########подключить приложение  к бд:
######$ kubectl create configmap postgres-config --from-file=animals-app/src/main/resources/application-k8s.yml

postgres_host значение ClasterIP взять из сервиса postgres(stolon-proxy)


подключиться к стручку бд:
$ kubectl -n default exec -it stolon-keeper-0 -- psql --host 10.1.7.141 --port 5432 postgres -U stolon -W
для user stolon:
pass: password1

##### попробовать psql --host 10.106.151.182 --port 30891 postgres -U stolon -W

посмотреть окружение сервиса:
$ kubectl exec stolon-proxy-55c59cb566-xzqpl -- printenv | grep SERVICE

посмотреть адрес сервиса:
$ kubectl run curl --image=radial/busyboxplus:curl -i --tty
[ root@curl-66bdcf564-54dcm:/ ]$ nslookup stolon-proxy-service

Name:      stolon-proxy-service
Address 1: 10.106.151.182 stolon-proxy-service.default.svc.cluster.local


(пароля нет):
To get superuser password run
    PGPASSWORD=$(kubectl get secret --namespace default stolon -o jsonpath="{.data.pg_su_password}" | base64 --decode; echo)

The password for the stolon user will be the value specified in your secret.yaml above (or password1 if you did not change it).

Листинг существующих бд:
\l

выход:
\q


PGAdmin4: 

General -  

name: Stolon,

Connection -

Hostname/address: localhost

Port: 30891(<value NodePort> from K8s)

Maintenance database: stolon 
 