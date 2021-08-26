package com.bz.service;

import com.bz.dao.RoleDao;
import com.bz.entity.MyRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
    private RoleDao roleDao;

	public MyRole getRoleById(Integer id) {
		return roleDao.getRoleById(id);
	}
}
