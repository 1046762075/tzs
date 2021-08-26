package com.bz.security.handler;

import com.alibaba.fastjson.JSON;
import com.bz.result.ResultResponse;
import com.bz.result.ResultUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        response.getWriter().println(JSON.toJSONString(new ResultResponse(ResultUtil.RESULT_ERROR, "尚未登录，或者登录过期")));
        response.getWriter().flush();
    }
}
