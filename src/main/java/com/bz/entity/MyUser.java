package com.bz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class MyUser implements Serializable {
    private static final long serialVersionUID = -6525908145032868837L;

	public static final int ENABLE = 1;

	public static final int DISABLE = 0;

	public static final int DELETE = 1;

	/**
	 * id值
	 */
	private Integer userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 最后登录IP
	 */
	private String lastLoginIp;
	/**
	 * 登录次数
	 */
	private Long loginTimes;
	/**
	 * 联系地址
	 */
	private String address;
	/**
	 * 是否删除 0 否 1 是
	 */
	private Integer isDel;

    private Integer roleId;

    /**
     * 判断是否为admin用户
     * @return
     */
    public boolean isAdmin()
    {
        return isAdmin(this.getUserId());
    }

    public static boolean isAdmin(Integer userId)
    {
        return userId != null && 1L == userId;
    }

    public MyUser(Integer userId)
    {
        this.setUserId(userId);
    }
}
