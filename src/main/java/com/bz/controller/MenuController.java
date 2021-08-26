package com.bz.controller;

import com.bz.dto.MenuDto;
import com.bz.entity.MyMenu;
import com.bz.result.Result;
import com.bz.result.ResultUtil;
import com.bz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Title: MenuController</p>
 * Description：
 * date：2021/8/24 16:48
 */
@RequestMapping("/pc/menu")
@Controller
public class MenuController extends BaseController{

	@Autowired
	MenuService menuService;

	@GetMapping("index")
	@PreAuthorize("hasAnyAuthority('menu:list')")
	public String index(Model model){
		model.addAttribute("projectName", projectName);
		return "system/menu/menu";
	}


	@GetMapping
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('menu:list')")
	public Object getMenuAll(String queryName, Integer queryType){
		return Result.ok().data(menuService.getMenuAll(queryName,queryType)).code(ResultUtil.RESULT_SUCCESS);
	}

	@GetMapping("/build")
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('menu:add','menu:edit')")
	public Object buildMenuAll(){
		List<MenuDto> menuAll = menuService.buildMenuAll();
		return Result.ok().data(menuAll);
	}

	@GetMapping("/ebuild/{roleId}")
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('role:add','role:edit')")
	public Object buildMenuAllByRoleId(@PathVariable Integer roleId){
		List<MenuDto> menuAll =menuService.buildMenuAllByRoleId(roleId);
		return Result.ok().data(menuAll);
	}

	@GetMapping(value = "/edit")
	@PreAuthorize("hasAnyAuthority('menu:edit')")
	public String editPermission(Model model, MyMenu myMenu) {
		model.addAttribute("projectName", projectName);
		model.addAttribute("myMenu",menuService.getMenuById(myMenu.getMenuId()));
		return "system/menu/menu-edit";
	}

	@PutMapping
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('menu:edit')")
	public Object updateMenu(@RequestBody MyMenu menu) {
		return menuService.updateMenu(menu);
	}


	@GetMapping(value = "/add")
	@PreAuthorize("hasAnyAuthority('menu:add')")
	public String addMenu(Model model) {
		model.addAttribute("projectName", projectName);
		model.addAttribute("myMenu",new MyMenu());
		return "system/menu/menu-add";
	}

	@PostMapping
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('menu:add')")
	public Object savePermission(@RequestBody MyMenu myMenu) {
		return menuService.save(myMenu);
	}


	/**
	 * @param menuId
	 * @return
	 */
	@DeleteMapping
	@ResponseBody
	@PreAuthorize("hasAnyAuthority('menu:del')")
	public Object deleteMenu(Integer menuId) {
		return menuService.delete(menuId);
	}
}
