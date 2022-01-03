package com.bz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 15:36:16
 */
@Data
@TableName("order_info")
public class OrderInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/*  */
	@TableId(type = IdType.AUTO)
	private Long id;
	/*  */
	private String address;
	/*  */
	private String addressName;
	/*  */
	private Date createTime;
	/*  */
	private Long creator;
	/*  */
	private Long customerId;
	/*  */
	private String customerName;
	/*  */
	private String customerPhone;
	/*  */
	private String customerTypeName;
	/*  */
	private String orderNo;
	/*  */
	private Integer orderStatus;
	/*  */
	private Integer orderType;
	/*  */
	private BigDecimal realPrice;
	/*  */
	private BigDecimal receivablePrice;
	/*  */
	private Integer salesDistance;
	/*  */
	private BigDecimal totalPrice;
	/*  */
	private Date expectEndTime;
	/*  */
	private Date expectStartTime;
	/*  */
	private String payMode;
	/*  */
	private Date completeTime;
	/*  */
	private Long deliveryStaffId;
	/*  */
	private Integer deliveryStatus;
	/*  */
	private BigDecimal latitude;
	/*  */
	private BigDecimal longitude;
	/*  */
	private Long scStockMainId;
	/*  */
	private Date takeTime;
	/*  */
	private Long collectCreator;
	/*  */
	private Date collectTime;
	/*  */
	private Long settleCreator;
	/*  */
	private Integer settleStatus;
	/*  */
	private Date settleTime;
	/*  */
	private Long zhaCreator;
	/*  */
	private Date zhaTime;
	/*  */
	private Long orderAccountId;
	/*  */
	private Integer wmType;
	/*  */
	private Long monthSettleCreator;
	/*  */
	private String monthSettleDesc;
	/*  */
	private String monthSettleNo;
	/*  */
	private BigDecimal monthSettlePrice;
	/*  */
	private Integer monthSettleStatus;
	/*  */
	private Date monthSettleTime;
	/*  */
	private Long monthSettleZhaCreator;
	/*  */
	private Date monthSettleZhaTime;
	/*  */
	private String zhaNo;
	/*  */
	private BigDecimal expectPrice;
	/*  */
	private Long honeycombId;
	/*  */
	private Long honeycombGridId;
	/*  */
	private Integer isKnow;
	/*  */
	private String orderDesc;
	/*  */
	private String refundDesc;
	/*  */
	private Integer refundStatus;
	/*  */
	private String importFlag;
	/*  */
	private String yhDcName;
	/*  */
	private BigDecimal yhDcPrice;
	/*  */
	private String monthSettleTakeType;

}
