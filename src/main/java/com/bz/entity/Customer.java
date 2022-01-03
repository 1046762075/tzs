package com.bz.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 16:14:46
 */
@Data
//@TableName("customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	/*  */
	@TableId
	private Long id;
	/*  */
	private String accountNumber;
	/*  */
	private Long businessId;
	/*  */
	private String contacts;
	/*  */
	private Date createTime;
	/*  */
	private Long creator;
	/*  */
	private String customerDesc;
	/*  */
	private String customerName;
	/*  */
	private Integer customerStatus;
	/*  */
	private Long customerTypeId;
	/*  */
	private Long honeycombGridId;
	/*  */
	private Long honeycombId;
	/*  */
	private Integer integral;
	/*  */
	private Long inviterId;
	/*  */
	private Integer isMonopoly;
	/*  */
	private Date lastDeliverTime;
	/*  */
	private Date lastUpholdTime;
	/*  */
	private String openId;
	/*  */
	private String phone;
	/*  */
	private Integer sourceType;
	/*  */
	private String vipLevel;
	/*  */
	private String customerTags;
	/*  */
	private Date updateTime;

}
