package com.mould;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 配置web.xml成功
 */
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     /*   PrintWriter writer = resp.getWriter();
        writer.println("Hello world +++++++++++++++ \t \t \t");
        System.out.println("进入了 doGet方法");*/
        ServletContext servletContext = this.getServletContext();
        servletContext.getRequestDispatcher("/DispatcherDemo").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
