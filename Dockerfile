FROM tomcat:9.0.54-jdk11-openjdk

LABEL tag="1.0"

RUN apt-get update && apt-get install -y maven

WORKDIR /usr/local/tomcat/webapps

COPY pom.xml ./
COPY src ./src/

RUN mvn clean package

RUN rm -rf ROOT
RUN cp target/*.war ROOT.war

EXPOSE 8080


