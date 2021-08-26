package com.bz.service;

import com.bz.dao.UserDao;
import com.bz.entity.MyRoleUser;
import com.bz.entity.MyUser;
import com.bz.result.Result;
import com.bz.result.ResultUtil;
import com.bz.security.utils.Constant;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	RoleUserService roleUserService;

	public MyUser getUserStatusByName(String userName) {
		return userDao.getUserStatusByName(userName);
	}

	public MyUser getUserByName(String userName) {
		return userDao.getUser(userName);
	}

	public Result<MyUser> getAllUsersByPage(Integer offectPosition, Integer limit, MyUser myUser) {
		Page page = PageHelper.offsetPage(offectPosition,limit);
		List<MyUser> fuzzyUserByPage = userDao.getFuzzyUserByPage(myUser);
		return Result.ok().count(page.getTotal()).data(fuzzyUserByPage).code(ResultUtil.RESULT_SUCCESS);
	}

    public Result<MyUser> updateUser(MyUser myUser) {
			try {
				myUser.setUpdateTime(new Date());
				if(myUser.getPassword() == null || myUser.getPassword().equals("")){
					myUser.setPassword(null);
				}else {
					BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
					myUser.setPassword(bCryptPasswordEncoder.encode(myUser.getPassword()));
				}
				userDao.updateUser(myUser);
				return Result.ok().message("更新成功");
			}catch (RuntimeException e){
				return Result.error().message("更新失败");
			}
    }

    public int changeStatus(MyUser user) {
		user.setUpdateTime(new Date());
        return userDao.updateUser(user);
    }

    public Result<MyUser> save(MyUser myUser) {
		myUser.setNickName(myUser.getUserName());
		myUser.setCreateTime(new Date());
		myUser.setUpdateTime(new Date());
		myUser.setIsDel(0);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		myUser.setPassword(bCryptPasswordEncoder.encode(Constant.password));
		try {
			userDao.save(myUser);
			roleUserService.save(new MyRoleUser(myUser.getUserId(), MyRoleUser.user));
			return Result.ok().message("添加成功，初始密码" + Constant.password);
		}catch (RuntimeException e){
			return Result.error().message("添加失败");
		}
    }

    @Transactional
    public int deleteUser(Integer userId) {
        return userDao.deleteUserById(userId);
    }


	public List<MyUser> getUserBystatus() {
		return userDao.getUserBystatus();
	}

	/**
	 * 获取本团队所有组长、业务员
	 * @return
	 */
	@Transactional
	public Result<MyUser> getAllGroupUsersByPage(Integer offset, Integer limit, MyUser myUser) {
		Page page = PageHelper.offsetPage(offset,limit);
		List<MyUser> fuzzyUserByPage = userDao.getGroupUserByPage(myUser);
		return Result.ok().count(page.getTotal()).data(fuzzyUserByPage).code(ResultUtil.RESULT_SUCCESS);
	}

	public boolean editPassword(MyUser user) {
			return userDao.updatePwd(user) > 0;
	}

	public Integer getUserIdByName(String nickName) {
		return userDao.getUserByName(nickName);
	}

	public MyUser getUserById(Integer userId) {

		return userDao.getUserById(userId);
	}
}
