package com.bz.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author lsl
 * @email 1046762075@qq.com
 * @date 2021-08-23 15:19:44
 */
public class NewspaperEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String finish = "2";

	private Integer id;
	/**
	 * 申请时间
	 */
	private Date applicationTime;
	/**
	 * 工程名称
	 */
	private String projectName;
	/**
	 * 联系人
	 */
	private String contactPerson;
	/**
	 * 联系电话
	 */
	private String contactNumber;
	/**
	 * 联系地址
	 */
	private String detailedAddress;
	/**
	 * 申请单位
	 */
	private String applicant;
	/**
	 * 报装类型 [0个人或生产经营单位客户新装 1新建住宅小区新装 2一户一表改造 3水表迁移工程 4临时水安装工程]
	 */
	private Integer newspaperType;
	/**
	 * 用水类型 [1居民 0非居民]
	 */
	private Integer typeOfWater;
	/**
	 * 用水户数
	 */
	private Integer numberOfWaterUsers;
	/**
	 * 估计水量
	 */
	private BigDecimal estimatedAmountOfWater;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 资料地址
	 */
	private String material;

	private String verification;

	private String applicationCoding;

	/**
	 * 状态 0 已提交 1受理中 2已完结 3已退回
	 */
	private String status;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Integer getNewspaperType() {
		return newspaperType;
	}

	public void setNewspaperType(Integer newspaperType) {
		this.newspaperType = newspaperType;
	}

	public Integer getTypeOfWater() {
		return typeOfWater;
	}

	public void setTypeOfWater(Integer typeOfWater) {
		this.typeOfWater = typeOfWater;
	}

	public Integer getNumberOfWaterUsers() {
		return numberOfWaterUsers;
	}

	public void setNumberOfWaterUsers(Integer numberOfWaterUsers) {
		this.numberOfWaterUsers = numberOfWaterUsers;
	}

	public BigDecimal getEstimatedAmountOfWater() {
		return estimatedAmountOfWater;
	}

	public void setEstimatedAmountOfWater(BigDecimal estimatedAmountOfWater) {
		this.estimatedAmountOfWater = estimatedAmountOfWater;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApplicationCoding() {
		return applicationCoding;
	}

	public void setApplicationCoding(String applicationCoding) {
		this.applicationCoding = applicationCoding;
	}
}
