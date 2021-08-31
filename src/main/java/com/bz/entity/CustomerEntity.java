package com.bz.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author lsl
 * @email 1046762075@qq.com
 * @date 2021-08-27 19:24:17
 */
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String finish = "2";

	private Integer id;
	/**
	 * 客户名称
	 */
	private String name;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 办理人
	 */
	private String handler;
	/**
	 * 移动电话
	 */
	private String mobileTelephone;
	/**
	 * 固定电话
	 */
	private String fixedTelephone;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 税号
	 */
	private String taxNumber;
	/**
	 * 
	 */
	private String verification;
	/**
	 * 申请编码
	 */
	private String applicationCoding;
	/**
	 * 材料一
	 */
	private String materialOne;
	/**
	 * 材料二
	 */
	private String materialTwo;
	/**
	 * 材料三
	 */
	private String materialThree;

	/**
	 * 材料四
	 */
	private String materialFour;
	/**
	 * 材料五
	 */
	private String materialFive;

	/**
	 * 材料六
	 */
	private String materialSex;

	/**
	 * 状态 0 已提交 1 审核中 2 已完成  3 已驳回
	 */
	private String status;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getMobileTelephone() {
		return mobileTelephone;
	}

	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}

	public String getFixedTelephone() {
		return fixedTelephone;
	}

	public void setFixedTelephone(String fixedTelephone) {
		this.fixedTelephone = fixedTelephone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public String getApplicationCoding() {
		return applicationCoding;
	}

	public void setApplicationCoding(String applicationCoding) {
		this.applicationCoding = applicationCoding;
	}

	public String getMaterialOne() {
		return materialOne;
	}

	public void setMaterialOne(String materialOne) {
		this.materialOne = materialOne;
	}

	public String getMaterialTwo() {
		return materialTwo;
	}

	public void setMaterialTwo(String materialTwo) {
		this.materialTwo = materialTwo;
	}

	public String getMaterialThree() {
		return materialThree;
	}

	public void setMaterialThree(String materialThree) {
		this.materialThree = materialThree;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMaterialFour() {
		return materialFour;
	}

	public void setMaterialFour(String materialFour) {
		this.materialFour = materialFour;
	}

	public String getMaterialFive() {
		return materialFive;
	}

	public void setMaterialFive(String materialFive) {
		this.materialFive = materialFive;
	}

	public String getMaterialSex() {
		return materialSex;
	}

	public void setMaterialSex(String materialSex) {
		this.materialSex = materialSex;
	}
}
