package com.bz.service;

import com.bz.dao.MenuDao;
import com.bz.dao.RoleDao;
import com.bz.dao.RoleMenuDao;
import com.bz.dto.MenuDto;
import com.bz.dto.MenuIndexDto;
import com.bz.entity.MyMenu;
import com.bz.entity.MyRole;
import com.bz.entity.MyUser;
import com.bz.result.ResultResponse;
import com.bz.result.ResultUtil;
import com.bz.security.utils.Constant;
import com.bz.security.utils.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codermy
 * @createTime 2020/7/10
 */
@Service
@Slf4j
public class MenuService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private HttpSession session;

    public List<MyMenu> getMenuAll(String queryName, Integer queryType) {

        return menuDao.getFuzzyMenu(queryName,queryType);
    }

    public MyMenu getMenuById(Integer id) {
        return menuDao.getMenuById(id);
    }

    public List<MenuDto> buildMenuAll() {
        return menuDao.buildAll();
    }

    public Object updateMenu(MyMenu menu) {
		menu.setIcon("layui-icon " + menu.getIcon());
        return (menuDao.update(menu) > 0) ? new ResultResponse(ResultUtil.RESULT_SUCCESS, "修改成功") : new ResultResponse(ResultUtil.RESULT_ERROR, "修改失败");

    }

    public Object save(MyMenu menu) {
		menu.setIcon("layui-icon " + menu.getIcon());
		int falg = menuDao.save(menu);
		List<MyRole> roles = roleDao.getAll();

		ArrayList<Integer> list = new ArrayList<>();
		list.add(menu.getMenuId());
		//		92为商品管理
		if (menu.getParentId() == 92){
			MyUser user = (MyUser) session.getAttribute(Constant.USER);
			if(user.getUserId() == 1){
				roleMenuDao.save(1, list);
			}
		}else {
			for (MyRole role : roles) {
				roleMenuDao.save(role.getRoleId(), list);
			}
		}
		return (falg > 0) ? new ResultResponse(ResultUtil.RESULT_SUCCESS, "添加成功") : new ResultResponse(ResultUtil.RESULT_ERROR, "添加失败");
    }



    /**
     * 如果这里删除了菜单树的父节点，把它的子节点一并删除
     * @param id
     * @return
     */
    public Object delete(Integer id) {
        Integer count = roleMenuDao.countRoleMenuByRoleId(id);
        if (count == 0){
            menuDao.deleteById(id);
            List<Integer> list = menuDao.selectByParentId(id);
            if(list.size()>0){
                for (Integer parentId: list){
                    menuDao.deleteByParentId(parentId);
                }
                menuDao.deleteByParentId(id);
            }
            return new ResultResponse(ResultUtil.RESULT_SUCCESS, "删除成功");
        }
        else {
            return new ResultResponse(ResultUtil.RESULT_ERROR, "已经有角色分配该菜单，无法删除");
        }

    }

    public List<MenuDto> buildMenuAllByRoleId(Integer roleId) {
        List<MenuDto> listByRoleId = menuDao.listByRoleId(roleId);
        List<MenuDto> permissionDtos = menuDao.buildAll();
        List<MenuDto> tree = TreeUtil.menutree(listByRoleId, permissionDtos);
        return tree;
    }

    public List<MenuIndexDto> getMenu(Integer userId) {
        List<MenuIndexDto> list = menuDao.listByUserId(userId);
        List<MenuIndexDto> result = TreeUtil.parseMenuTree(list);
        return result;
    }
}
