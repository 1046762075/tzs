package com.bz.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyRoleUser implements Serializable {

    private static final long serialVersionUID = 8545514045582235838L;

	public static final int user = 2;

    private Integer userId;

    private Integer roleId;

	public MyRoleUser(Integer userId, int user) {
		this.userId = userId;
		this.roleId = user;
	}
}
