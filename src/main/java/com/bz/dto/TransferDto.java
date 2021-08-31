package com.bz.dto;

import java.io.Serializable;

public class TransferDto implements Serializable {

	private int id;

	private String status;
	/**
	 * 输入原户主、新户主
	 */
	private String originalUser;

	/**
	 * 输入电话、申请编码
	 */
	private String originalPhone;

	private String startTime;

	private String endTime;

	private String Imgs;

	private String verification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOriginalUser() {
		return originalUser;
	}

	public void setOriginalUser(String originalUser) {
		this.originalUser = originalUser;
	}

	public String getOriginalPhone() {
		return originalPhone;
	}

	public void setOriginalPhone(String originalPhone) {
		this.originalPhone = originalPhone;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getImgs() {
		return Imgs;
	}

	public void setImgs(String imgs) {
		Imgs = imgs;
	}

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}
}
