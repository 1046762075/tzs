package com.bz.security.handler;

import com.alibaba.fastjson.JSON;
import com.bz.entity.MyUser;
import com.bz.result.ResultResponse;
import com.bz.result.ResultUtil;
import com.bz.security.dto.JwtUserDto;
import com.bz.security.utils.Constant;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录成功
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

//    @Autowired
//    private JwtUtils jwtUtils;
//
//    @Value("${jwt.tokenHeader}")
//    private String tokenHeader;
//
//    @Value("${jwt.tokenHead}")
//    private String tokenHead;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
		MyUser myUser = ((JwtUserDto) authentication.getPrincipal()).getMyUser();
		// 生成token
//		String jwtToken = jwtUtils.generateToken(myUser.getUserName());
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute(Constant.USER, myUser);

//		result.jwt(jwtToken);
		//修改编码格式
		httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json");
        //输出结果
        httpServletResponse.getWriter().write(JSON.toJSONString(new ResultResponse(ResultUtil.RESULT_SUCCESS, "登录成功")));
    }
}
