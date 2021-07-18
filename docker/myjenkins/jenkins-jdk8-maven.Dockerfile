FROM jenkins/jenkins:lts-alpine

USER root

ADD ./apache-maven-3.8.1-bin.tar.gz /opt/maven

ENV MAVEN_HOME=/opt/maven/apache-maven-3.8.1
ENV PATH=$MAVEN_HOME/bin:$PATH

COPY ./settings.xml /opt/maven/apache-maven-3.8.1/conf/settings.xml
COPY ./jenkins_home /var/jenkins_home