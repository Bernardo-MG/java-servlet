# Java Servlet Example

Example setting up a Java servlet.

## Features

- Java servlet

## Usage

Build the war and deploy it in a servlet container, such as Tomcat.

If deployed locally then the project will be accessible at the URL:

```
http://localhost:8080/java-servlet-example/hello?name=me
```

The API docs will be available at:

```
http://localhost:8080/java-servlet-example/api-docs/swagger.json
```

### Docker image

To ease deploying the project, Docker files are included:

```
docker-compose -f docker/docker-compose.yml --project-name java-servlet-example up
```
