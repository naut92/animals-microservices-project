#replace default.conf nginx:
    kubectl create configmap frontend-default-conf --from-file=default.conf=default.conf
    kubectl create -f frontend-default-conf.yml
    kubectl replace -f frontend-default-conf.yml