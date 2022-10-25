
package com.bernardomg.example.servlet.controller;

import java.io.IOException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SwaggerDefinition(
        info = @Info(description = "This server generates Swagger documentation.", version = "1.0.0",
                title = "Servlet with documentation",
                license = @License(name = "MIT License", url = "http://www.opensource.org/licenses/mit-license.php")),
        consumes = { "application/http" }, produces = { "application/http" },
        schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
        tags = { @Tag(name = "example", description = "Example components") })
@Api(value = "/documented")
@WebServlet(name = "DocumentedServlet", urlPatterns = "/documented")
public class DocumentedServlet extends HttpServlet {

    private static final long serialVersionUID = 5892091829006189796L;

    @ApiOperation(httpMethod = "GET", value = "Returns a greeting", response = String.class, nickname = "hello")
    @ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "Name to greet", required = true, dataType = "string",
            paramType = "query") })
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        final String name;
        final String hello;

        name = request.getParameter("name");
        hello = String.format("Hello %s", name);

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter()
            .write(hello);
        response.getWriter()
            .flush();
    }

}
