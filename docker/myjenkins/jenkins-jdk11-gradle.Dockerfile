FROM jenkins/jenkins:lts-jdk11

USER root

COPY ./gradle-7.1.1 /opt/gradle/gradle-7.1.1
ENV GRADLE_HOME=/opt/gradle/gradle-7.1.1
ENV PATH=$GRADLE_HOME/bin:$PATH

COPY ./jenkins_home /var/jenkins_home