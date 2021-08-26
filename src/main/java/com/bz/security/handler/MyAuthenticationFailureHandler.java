package com.bz.security.handler;

import com.alibaba.fastjson.JSON;
import com.bz.result.ResultResponse;
import com.bz.result.ResultUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json");
        if (e instanceof BadCredentialsException){
            httpServletResponse.getWriter().write(JSON.toJSONString(new ResultResponse(ResultUtil.RESULT_ERROR, "用户名或密码错误")));
        }else {
            httpServletResponse.getWriter().write(JSON.toJSONString(new ResultResponse(ResultUtil.RESULT_ERROR, e.getMessage())));
        }
    }
}
