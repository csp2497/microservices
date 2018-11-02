# Calculator Demo For Microservices

## Reference URL
* [Markdown Cheat Sheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
* [Tutorial for deploy S2I with JAR file](https://access.redhat.com/documentation/en-us/red_hat_jboss_middleware_for_openshift/3/html-single/red_hat_java_s2i_for_openshift/index)

## Preparation
Before running the steps to deploy S2I image, first we have to import the image stream to Minishift as it does not come with S2I in its catalog.

Refer to the [link](https://developers.redhat.com/blog/2017/02/23/getting-started-with-openshift-java-s2i/), we import RedHat Openjdk18.

After importing the image stream, you can use `oc get imagestream` or `oc get is -n openshift` to view the list of image stream available

### When using Openshift, you must assign the view role to the default service account in the current project:
```
oc policy add-role-to-user view --serviceaccount=default
```

## Steps TO Deploy Using S2i
In Sequence:
* `cd to source folder`
* `mvn clean package`
* `mkdir -p ./ocp/deployments`
* `cp .\target\calculator-0.0.1.jar .\ocp\deployments\` 
* `oc new-build --binary=true --name=calculator --image-stream=openjdk18-openshift` (_Image Stream name should use the one imported from above steps_)
* `oc start-build calculator --from-dir=.\ocp --follow`
* `oc new-app calculator`
* `oc get svc -o name` (_to list down the available services_)
* `oc expose svc/calculator`

*Wala DONE~~~~*

## To delete everything
``` 
oc delete all --selector app=calculator
```
