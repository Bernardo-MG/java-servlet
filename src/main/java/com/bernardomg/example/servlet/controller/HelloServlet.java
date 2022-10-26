
package com.bernardomg.example.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@SwaggerDefinition(
        info = @Info(description = "This servlet sends a greeting", version = "1.0.0", title = "Hello servlet",
                license = @License(name = "MIT License", url = "http://www.opensource.org/licenses/mit-license.php")),
        consumes = { "application/http" }, produces = { "application/http" },
        schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
        tags = { @Tag(name = "example", description = "Example components") })
@Api(value = "/documented")
public class HelloServlet extends HttpServlet {

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
