Calculator Demo For Microservices

https://access.redhat.com/documentation/en-us/red_hat_jboss_middleware_for_openshift/3/html-single/red_hat_java_s2i_for_openshift/index

1. cd to source folder
2. mvn clean package
3. cmkdur -p ./ocp/deployments
4. oc new-build --binary=true --name=calculator --image-stream=openjdk18-openshift
5. oc start-build calculator --from-dir=.\ocp --follow
