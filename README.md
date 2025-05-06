# OBP-API-Dispatch
A proxy to route requests to different OBP API backends

# config
you can modify the configuration in the file [application.conf](src/main/resources/application.conf)

and the log configuration in [logback.xml](src/main/resources/logback.xml)


# Build and Run

````
mvn clean package

java -jar target/OBP-API-Dispatch-1.0-SNAPSHOT-jar-with-dependencies.jar
````