package com.bz.service;


import com.bz.dao.RoleUserDao;
import com.bz.entity.MyRoleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/13
 */
@Service
public class RoleUserService {

	@Autowired
	private RoleUserDao roleUserDao;

	/**
	 * 返回用户拥有的角色
	 * @param userId
	 * @return
	 */
	public List<MyRoleUser> getMyRoleUserByUserId(Integer userId) {
		return roleUserDao.getMyRoleUserByUserId(userId);
	}

	public int save(MyRoleUser myRoleUser) {
		return roleUserDao.save(myRoleUser);
	}
}
