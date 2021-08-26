package com.bz.controller;

import com.bz.entity.MyUser;
import com.bz.result.Result;
import com.bz.security.utils.PageTableRequest;
import com.bz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: UserController</p>
 * Description：
 * date：2021/8/25 15:35
 */
@RequestMapping("/pc/user")
@Controller
public class UserController extends BaseController{

	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("projectName", projectName);
		return "system/user/index";
	}

	@GetMapping
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('user:list')")
	public Result<MyUser> userList(PageTableRequest pageTableRequest, MyUser myUser){
		pageTableRequest.countOffset();
		return userService.getAllUsersByPage(pageTableRequest.getOffset(), pageTableRequest.getLimit(), myUser);
	}

	@GetMapping("/add")
	@PreAuthorize("hasAnyAuthority('system:user')")
	public String addUser(Model model){
		model.addAttribute("myUser", getMyUser());
		model.addAttribute("projectName", projectName);
		return "/system/user/user-add";
	}

	@GetMapping("/edit/{userId}")
	@PreAuthorize("hasAnyAuthority('system:user')")
	public String editUser(Model model, @PathVariable Integer userId){
		model.addAttribute("myUser", userService.getUserById(userId));
		model.addAttribute("projectName", projectName);
		return "/system/user/user-edit";
	}

	/**
	 * 添加/编辑
	 * @param myUser
	 * @return
	 */
	@PostMapping
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('system:user')")
	public Result<MyUser> saveUser(@RequestBody MyUser myUser){
		try {
			if(myUser.getUserId() != null){
				return userService.updateUser(myUser);
			}else {
				return userService.save(myUser);
			}
		} catch (RuntimeException e){
			return Result.error().message("账号未登录或权限不足");
		}
	}

	/**
	 * 用户状态修改
	 */
	@PutMapping("/changeStatus")
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('system:user')")
	public Result changeStatus(@RequestBody MyUser myUser) {
		try {
			return Result.judge(userService.changeStatus(myUser),"修改");
		}catch (RuntimeException e){
			return Result.error().message("权限不足");
		}
	}
}
