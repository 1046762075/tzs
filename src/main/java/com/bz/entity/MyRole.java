package com.bz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MyRole {
    private static final long serialVersionUID = -6525908145032868837L;

    private Integer roleId;

    private String roleName;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限） */
    private String dataScope;

    private String description;


    /**
     * 判断是否为admin用户
     * @return
     */
    public boolean isAdmin()
    {
        return isAdmin(this.getRoleId());
    }

    public static boolean isAdmin(Integer roleId)
    {
        return roleId != null && 1L == roleId;
    }

    public MyRole(Integer roleId)
    {
        this.setRoleId(roleId);
    }
}
