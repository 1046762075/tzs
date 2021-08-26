package com.bz.security;

import com.bz.dao.MenuDao;
import com.bz.dto.MenuIndexDto;
import com.bz.entity.MyRole;
import com.bz.entity.MyRoleUser;
import com.bz.entity.MyUser;
import com.bz.security.dto.JwtUserDto;
import com.bz.service.RoleService;
import com.bz.service.RoleUserService;
import com.bz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleUserService roleUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuDao menuDao;

    @Override
    public JwtUserDto loadUserByUsername(String userName){
        MyUser user = userService.getUserStatusByName(userName);
        if (user == null ){
            throw new BadCredentialsException("用户名或密码错误");
        } else if(user.getStatus().equals(MyUser.DISABLE)){
			throw new LockedException("用户已被禁用");
		} else if(user.getIsDel().equals(MyUser.DELETE)){
			throw new LockedException("用户已被删除");
		}
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<MenuIndexDto> list = menuDao.listByUserId(user.getUserId());
        List<String> collect = new ArrayList<>();
		for (MenuIndexDto menuIndexDto : list) {
			if(menuIndexDto != null){
				collect.add(menuIndexDto.getPermission());
			}
		}
        for (String authority : collect){
            if (!("").equals(authority) & authority !=null){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority);
                grantedAuthorities.add(grantedAuthority);
            }
        }
        //将用户所拥有的权限加入GrantedAuthority集合中
        JwtUserDto loginUser = new JwtUserDto(user,grantedAuthorities);
        loginUser.setRoleInfo(getRoleInfo(user));
        return loginUser;
    }

    public List<MyRole> getRoleInfo(MyUser myUser) {
        MyUser userByName = userService.getUserByName(myUser.getUserName());
        List<MyRoleUser> roleUserByUserId = roleUserService.getMyRoleUserByUserId(userByName.getUserId());
        List <MyRole> roleList = new ArrayList<>();
        for (MyRoleUser roleUser:roleUserByUserId){
            Integer roleId = roleUser.getRoleId();
            MyRole roleById = roleService.getRoleById(roleId);
            roleList.add(roleById);
        }
        return roleList;
    }
}