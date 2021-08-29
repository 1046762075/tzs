package com.bz.security.utils;

import com.bz.dto.DeptDto;
import com.bz.dto.MenuDto;
import com.bz.dto.MenuIndexDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeUtil {
    //todo 判断list是否为空

    /**
     *
     * @param listByRoleId 通过角色id查询的menuid
     * @param menuDtos 返回的menutree
     * @return
     */
    public static List<MenuDto> menutree(List<MenuDto> listByRoleId, List<MenuDto> menuDtos ){
		List<Integer> collect = new ArrayList<>();
		List<Integer> collect1 = new ArrayList<>();
		for (MenuDto menuDto : listByRoleId) {
			collect.add(menuDto.getId());
		}
		for (MenuDto menuDto : menuDtos) {
			collect1.add(menuDto.getId());
		}
        // 遍历list2
        for (Integer item : collect) {
            // 如果存在这个数
            if (collect1.contains(item)) {
                MenuDto menuDto = new MenuDto();
                int i = collect1.indexOf(item);
                menuDto = menuDtos.get(i);
                menuDto.setCheckArr("1");
                menuDtos.set(i,menuDto);
            }
        }
        return menuDtos;
    }

    public static List<DeptDto> deptTree(List<DeptDto> listById, List<DeptDto> lists ){
		List<Integer> collect = new ArrayList<>();
		List<Integer> collect1 = new ArrayList<>();
		for (DeptDto deptDto : listById) {
			collect.add(deptDto.getId());
		}
		for (DeptDto deptDto : lists) {
			collect1.add(deptDto.getId());
		}
        // 遍历list2
        for (Integer item : collect) {
            // 如果存在这个数
            if (collect1.contains(item)) {
                DeptDto deptDto = new DeptDto();
                int i = collect1.indexOf(item);
                deptDto = lists.get(i);
                deptDto.setCheckArr("1");
                lists.set(i,deptDto);
            }
        }
        return lists;
    }

    public static List<MenuIndexDto> parseMenuTree(List<MenuIndexDto> list){
        List<MenuIndexDto> result = new ArrayList<>();
        // 1、获取第一级节点
        for (MenuIndexDto menu : list) {
            if(null != menu && menu.getParentId() == 0) {
                result.add(menu);
            }
        }
        // 2、递归获取子节点
        for (MenuIndexDto parent : result) {
            parent = recursiveTree(parent, list);
        }
        return result;
    }

    public static MenuIndexDto recursiveTree(MenuIndexDto parent, List<MenuIndexDto> list) {
        List<MenuIndexDto>children = new ArrayList<>();
        for (MenuIndexDto menu : list) {
            if (menu != null && Objects.equals(parent.getId(), menu.getParentId())) {
                children.add(menu);
            }
            parent.setChildren(children);
        }
        return parent;
    }
}
