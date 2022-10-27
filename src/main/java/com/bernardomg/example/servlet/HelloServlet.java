/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2022 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.servlet;

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

/**
 * Servlet which returns a greeting.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
@SwaggerDefinition(
        info = @Info(description = "This servlet sends a greeting", version = "1.0.0", title = "Hello servlet",
                license = @License(name = "MIT License", url = "http://www.opensource.org/licenses/mit-license.php")),
        consumes = { "application/http" }, produces = { "application/http" },
        schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
        tags = { @Tag(name = "example", description = "Example components") })
@Api("/hello")
public final class HelloServlet extends HttpServlet {

    /**
     * Serialization id.
     */
    private static final long serialVersionUID = 5892091829006189796L;

    /**
     * Default constructor.
     */
    public HelloServlet() {
        super();
    }

    @ApiOperation(httpMethod = "GET", value = "Returns a greeting", response = String.class, nickname = "hello")
    @ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "Name to greet", required = true, dataType = "string",
            paramType = "query") })
    @Override
    protected final void doGet(final HttpServletRequest request, final HttpServletResponse response)
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
