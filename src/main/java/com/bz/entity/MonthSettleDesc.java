package com.bz.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 14:47:33
 */
@Data
@TableName("month_settle_desc")
public class MonthSettleDesc implements Serializable {
	private static final long serialVersionUID = 1L;

	/*  */
	@TableId
	private Integer id;
	/*  */
	private String customerName;
	/*  */
	private String createTime;
	/*  */
	private String goods;
	/*  */
	private Integer num;
	/*  */
	private BigDecimal unitPrice;
	/*  */
	private BigDecimal totalPrice;

}
