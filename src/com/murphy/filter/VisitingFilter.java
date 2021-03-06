package com.murphy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author murphy
 */
public class VisitingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----INIT-----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        Object u1 = request.getSession().getAttribute("u1");
        if (!requestURI.endsWith("login.jsp")) {
            if (u1 == null) {
                response.sendRedirect("login.jsp");
                return;
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }

    @Override
    public void destroy() {
        System.out.println("-----DESTROY-----");
    }
}
