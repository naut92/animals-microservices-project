initialize the cluster:
$ kubectl run -i -t stolonctl --image=sorintlab/stolon:master-pg10  --restart=Never --rm -- /usr/local/bin/stolonctl --cluster-name=kube-stolon --store-backend=kubernetes --kube-resource-kind=configmap init 

$ kubectl apply -f stolon-sentinel.yml
$ kubectl apply -f secret.yml
$ kubectl apply -f stolon-keeper.yml
$ kubectl apply -f stolon-proxy.yml

$ kubectl get svc
$ kubectl -n default get services | fgrep proxy
$ kubectl -n default get pods -o wide

$ kubectl -n default exec -it stolon-keeper-0 -- psql --host 10.1.7.41 --port 5432 postgres -U stolon -W
для user stolon:
pass: password1

--psql -h localhost -U postgresadmin1 --password -p 32656 postgres

(пароля нет):
To get superuser password run
    PGPASSWORD=$(kubectl get secret --namespace default stolon -o jsonpath="{.data.pg_su_password}" | base64 --decode; echo)

The password for the stolon user will be the value specified in your secret.yaml above (or password1 if you did not change it).

Листинг существующих бд:
\l

выход:
\q