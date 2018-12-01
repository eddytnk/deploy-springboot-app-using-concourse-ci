# Spring boot application deployed using concourse CI

This spring application uses concouse CI to build and deploy your java application on Pivotal Cloud Foundry when a commit push is done on gitHub
The CI is divided into two phases (Jobs).

1. Test and Build Job
2. Deploy App to PCF Job 

![Screenshot](https://raw.githubusercontent.com/eddytnk/deploy-springboot-app-using-concourse-ci/master/ci/screenshot.png)

## Test and Build
During this job, the Java application is being tested and archived in .jar file then send to s3 bucket

```
- name: test-and-build
  public: true
  plan:
    - get: source-code-from-github
      trigger: true
    - get: s3-stored-jar
    - task: run-test-and-build-jar-file
      config:
        platform: linux
        image_resource:
          type: docker-image
          source:
            repository: java
            tag: 8
        inputs:
        - name: source-code-from-github
        outputs:
        - name: jar-file
        caches:
        - path: source-code-from-github/.m2
        run:
          path: ./source-code-from-github/ci/test-and-build.sh
    - put: s3-stored-jar
      params:
        file: jar-file/*.jar

```
This job uses two resources
1. git resource : The resource gets the latest commit pushed to git hub
2. s3 resource : A bucket to store the output jar file after the test and build process

The `git` resource is triggered when a commit-push is made on github. This resource triggers the `test-and-build` job to run.
which is simply: run all the unit test in the application, build a .jar file and send it to S3 for storage

This job runs a Docker image with java environment set up to be able to build .jar file. The code is pull from github in to the image context,
`mvn clean package` is run on the pulled git source code to start the tests and create the jar if all the test passes.

When this .jar file is created, use the `s3` resource and push the .jar to this specified s3 bucket.


## Deploy App to PCF Job 

During this job the application jar is being deployed to PCF from s3 bucket.

```

- name: deploy-app-to-pcf
  public: true
  plan:
  - get: s3-stored-jar
    passed: [test-and-build]
    trigger: true
  - get: source-code-from-github
  - put: pcf-resource
    params:
      manifest: source-code-from-github/ci/manifest.yml
```

This job triggered after a successful jar is created on S3. The job also uses the `git` resource to read the pcf manifest.yml file 
It also uses the `s3` resource to get the deployed jar file. Then finally uses the `cf` resource to deploy this jar to PCF


All these process start by you doing a simple developer action, `git push`