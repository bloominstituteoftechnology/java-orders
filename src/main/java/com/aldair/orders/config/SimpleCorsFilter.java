package com.aldair.orders.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Spring uses Filter/s to manage traffic in and out of the system.
 * Here we manually add our CORS (cross origin resource sharing) filter to the chain by
 * overriding the doFilter() method.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCorsFilter implements Filter
{
    public SimpleCorsFilter()
    {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Convert our request and response to Http ones. If they are not Http ones, an exception would be thrown
        // that would handled by our exception handlers!
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // white list domains that can access this API. * says let everyone access it. To restrict access use something like
        //                 response.setHeader("Access-Control-Allow-Origin",
        //            "https://lambdaschool.com/");
        response.setHeader("Access-Control-Allow-Origin", "*");
        // white list http methods that can be used with this API. * says lets them all work! To restrict access use something like
        //        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Methods", "*");
        // while list access headers that can be used with this API. * says lets them all work! To restrict access use something like
        //        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type, access_token");
        response.setHeader("Access-Control-Allow-Headers", "*");
        // maximum seconds results can be cached
        response.setHeader("Access-Control-Max-Age", "3600");
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) request).getMethod()))
        {
            response.setStatus(HttpServletResponse.SC_OK);
        } else
        {
            filterChain.doFilter(request, response);
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }
    @Override
    public void destroy()
    {
    }
}