##!/bin/bash
####/bin/bash

projectPath="PROJECT_PATH"
imageTag="1.0"
imageTagName="home_controller:${imageTag}"

rm -rf ${projectPath}/docker/pc_remote_control.jar

cp ${projectPath}/pc_remote_control/target/pc_remote_control.jar ${projectPath}/docker/pc_remote_control.jar

docker image build --no-cache -t ${imageTagName} .

# command to run image on docker
docker run -itd \
-p 16666:8080 \
--name pc_remote_control \
home_controller:1.0 /bin/bash
