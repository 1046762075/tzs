package com.bz.controller;

import com.bz.entity.MyUser;
import com.bz.security.utils.Constant;
import com.bz.security.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

	@Value("${server.servlet.context-path}")
	String projectName;

    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 获取request
     */
    public HttpServletRequest getRequest() {
        return ServletUtils.getRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse() {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

	public MyUser getMyUser() { return (MyUser) getSession().getAttribute(Constant.USER); }
}
