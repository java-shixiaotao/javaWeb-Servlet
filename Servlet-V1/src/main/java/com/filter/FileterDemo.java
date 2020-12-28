package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class FileterDemo implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化成功");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        System.out.println("进入过滤器之前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("进入过滤器之后");
    }

    @Override
    public void destroy() {
        System.out.println("销毁成功");
    }
}
