initialize the cluster:
$ kubectl run -i -t stolonctl --image=sorintlab/stolon:master-pg10  --restart=Never --rm -- /usr/local/bin/stolonctl --cluster-name=kube-stolon --store-backend=kubernetes --kube-resource-kind=configmap init 

$ kubectl apply -f stolon-sentinel.yml
$ kubectl apply -f secret.yml
$ kubectl apply -f stolon-keeper.yml
$ kubectl apply -f stolon-proxy.yml

$ kubectl get svc


psql -h localhost -U postgresadmin1 --password -p 32656 postgres


exec gosu stolon stolon-proxy

$ psql --host 10.1.5.252 --port 5432 postgres -U stolon -W
(пароля нет):
To get superuser password run
    PGPASSWORD=$(kubectl get secret --namespace default stolon -o jsonpath="{.data.pg_su_password}" | base64 --decode; echo)


The password for the stolon user will be the value specified in your secret.yaml above (or password1 if you did not change it).