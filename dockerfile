FROM adoptopenjdk/maven-openjdk11 
EXPOSE 8082
ADD target /GesF-1.0.jar
ENTRYPOINT ["java","-jar","/GesF-1.0.war"]