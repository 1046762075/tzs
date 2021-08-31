package com.bz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lsl
 * @email 1046762075@qq.com
 * @date 2021-08-31 09:09:25
 */
public class MyTransferEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String finish = "2";

	private Integer id;
	/**
	 * 原户主
	 */
	private String originalUser;
	/**
	 * 新户主
	 */
	private String newUser;
	/**
	 * 原户主手机
	 */
	private String originalPhone;
	/**
	 * 新户主手机
	 */
	private String newPhone;
	/**
	 *  客户表id
	 */
	private Integer customerId;

	/**
	 * 状态 [0 已提交 1 审核中 2 已完成 3 已退回]
	 */
	private String status;

	/**
	 * 材料
	 */
	private String materials;

	/**
	 * 申请码
	 */
	private String applicationCoding;

	/**
	 * 原因 [0 产权变更 1 用水地点迁移 2 其它]
	 */
	private String reason;

	/**
	 * 时间
	 */
	private Date createTime;

	private String verification;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOriginalUser() {
		return originalUser;
	}

	public void setOriginalUser(String originalUser) {
		this.originalUser = originalUser;
	}

	public String getNewUser() {
		return newUser;
	}

	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

	public String getOriginalPhone() {
		return originalPhone;
	}

	public void setOriginalPhone(String originalPhone) {
		this.originalPhone = originalPhone;
	}

	public String getNewPhone() {
		return newPhone;
	}

	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getApplicationCoding() {
		return applicationCoding;
	}

	public void setApplicationCoding(String applicationCoding) {
		this.applicationCoding = applicationCoding;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}
}
