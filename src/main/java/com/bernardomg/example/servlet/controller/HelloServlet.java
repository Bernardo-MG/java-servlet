
package com.bernardomg.example.servlet.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 5892091829006189796L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
