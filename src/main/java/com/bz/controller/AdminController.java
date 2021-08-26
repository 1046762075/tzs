package com.bz.controller;

import com.bz.dto.MenuIndexDto;
import com.bz.security.dto.JwtUserDto;
import com.bz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class AdminController extends BaseController{

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/index")
    @ResponseBody
    public List<MenuIndexDto> getMenu()  {
        JwtUserDto jwtUserDto = (JwtUserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userId = jwtUserDto.getMyUser().getUserId();
		List<MenuIndexDto> menu = menuService.getMenu(userId);
		return menu;
    }
    
    @GetMapping("/console")
    public String console(){
        return "system/console/console";
    }

    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }

    @GetMapping("/404")
    public String error404(){
        return "error/404";
    }

    @GetMapping("/500")
    public String error500(){
        return "error/500";
    }
}
