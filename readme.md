# Creating the first pod and service
```shell
kubectl apply -f blue-deployment.yaml,service-node-port-blue.yaml
```
```shell
http get localhost:30081
```
# Creating the second pod and service
```shell
kubectl apply -f green-deployment.yaml,service-node-port-green.yaml
```
```shell
http get localhost:30082
```
# Adding the nginx ingress controller
```shell
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.12.0-beta.0/deploy/static/provider/cloud/deploy.yaml
```
# Creating an ingress
We need the services to run on a clusterIp now because we're going to access them from outside
```shell
kubectl apply -f service-cluster-ip.yaml
```
```shell
kubectl apply -f ingress-single.yaml
```
```shell
http get app.localhost
```
# Creating the canary ingress
```shell
kubectl apply -f ingress-canary.yaml
```
## Demonstrating the canary ingress
```shell
for i in $(seq 1 10); do curl -is app.localhost; echo '\n------\n'; done
```