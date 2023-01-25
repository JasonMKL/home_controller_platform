FROM alpine:3.14

ARG CRONJOB_WORK_DIR=/var/local/application/home_controller/job

# IKnstall software
RUN apk update \
  && apk upgrade \
  && apk add ca-certificates \
  && update-ca-certificates \
  && apk add --no-cache coreutils openjdk8 tzdata bash

ARG USERNAME=tcadmin
ARG UID=5793
ARG GID=1270

# Set OS ENV
ENV UMASK=022
ENV TZ="Asia/Hong_Kong"
ENV JAVA_OPS -Duser.timezone=Asia/Hong_Kong
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk/
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

# Create a group and user
RUN addgroup -g $GID $USERNAME && adduser -S $USERNAME -u $UID -G $USERNAME

# Create workdir
WORKDIR ${CRONJOB_WORK_DIR}/

# create diectory for emailtemplate, config and log
RUN mkdir -p /var/local/application/home_controller/job/  && \
    mkdir -p ${CRONJOB_WORK_DIR}/logs/  && \
    chown -R $USERNAME:$USERNAME /var/local/application/

# Add application jar
COPY --chown=$USERNAME:$USERNAME pc_remote_control.jar ${CRONJOB_WORK_DIR}/pc_remote_control.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/var/local/application/home_controller/job/pc_remote_control.jar"]

CMD /bin/bash
