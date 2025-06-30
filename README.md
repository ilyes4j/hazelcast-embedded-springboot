## Starting point

[Tutorial](https://docs.hazelcast.com/tutorials/kubernetes-embedded)

## create deployment
```shell
# go to project folder
cd /home/ilyes/IdeaProjects/hazelcast-embedded-springboot
# build the jar
export JAVA_HOME=/home/ilyes/IdeaProjects/jdk-19-loom
./mvnw clean verify
# build the image
docker build -t harbor.ilyesdimassi.com/library/hazelcast-embedded-kubernetes .
# push the image to the repo
docker push harbor.ilyesdimassi.com/library/hazelcast-embedded-kubernetes
# clean the app in kube
kubectl delete namespace hazelcast-embedded-kubernetes
kubectl delete clusterrolebindings.rbac.authorization.k8s.io hazelcast-embedded-cluster-role-binding
kubectl delete clusterrole hazelcast-embedded-cluster-role
kubectl apply -f deploy-all.yaml
```
