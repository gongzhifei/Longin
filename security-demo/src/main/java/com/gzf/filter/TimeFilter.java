package com.gzf.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author gongzhifei
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(" TimeFilter Init ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(" TimeFilter doFilter ");
        long start = System.currentTimeMillis();
        chain.doFilter(request,response);
        System.out.println("耗时："+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        System.out.println(" TimeFilter destory ");
    }
}
