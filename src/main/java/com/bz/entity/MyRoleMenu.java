package com.bz.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class MyRoleMenu implements Serializable {

    private static final long serialVersionUID = 8925514045582235875L;

    private Integer roleId;

    private Integer permissionId;
}
