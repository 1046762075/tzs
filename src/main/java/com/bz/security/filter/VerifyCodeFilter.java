package com.bz.security.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class VerifyCodeFilter extends OncePerRequestFilter {

    private String defaultFilterProcessUrl = "/login";
    private String method = "POST";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (method.equalsIgnoreCase(request.getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())) {
            // 登录请求校验验证码，非登录请求不用校验
            HttpSession session = request.getSession();
            response.setContentType("application/json;charset=UTF-8");
        }
        chain.doFilter(request, response);
    }
}
