package com.bz.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {

	private int id;

	private String status;
	/**
	 * 客户名称、办理人
	 */
	private String handler;

	/**
	 * 电话/座机、申请码
	 */
	private String mobileTelephone;

	private String startTime;

	private String endTime;

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
}
