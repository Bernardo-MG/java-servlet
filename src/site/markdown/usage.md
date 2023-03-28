# Usage

This is a Maven project, first package the war:

```
mvn clean package
```

Then deploy into a servlet container, such as Tomcat. If done locally the project will be accessible at the URL:

```
http://localhost:8080/java-servlet-example/hello?name=me
```

And the API docs at:

```
http://localhost:8080/java-servlet-example/api-docs/swagger.json
```

## Docker image

To make things easier just make use of the Docker files:

```
docker-compose -f docker/docker-compose.yml --project-name java-servlet-example up
```

This will build and deploy locally the project. The URLs are the same as in the previous example.