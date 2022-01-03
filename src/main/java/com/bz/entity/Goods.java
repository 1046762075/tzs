package com.bz.entity;

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
 * @date 2021-10-10 16:14:46
 */
@Data
@TableName("goods")
public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;

	/*  */
	@TableId
	private Long id;
	/*  */
	private BigDecimal agentDeliveryPrice;
	/*  */
	private BigDecimal agentRaisePrice;
	/*  */
	private Date createTime;
	/*  */
	private Long creator;
	/*  */
	private Long goodsBrandId;
	/*  */
	private Long goodsCategoryId;
	/*  */
	private BigDecimal goodsCostPrice;
	/*  */
	private String goodsDesc;
	/*  */
	private String goodsImg;
	/*  */
	private String goodsName;
	/*  */
	private BigDecimal goodsPrice;
	/*  */
	private Long goodsSpecsId;
	/*  */
	private Integer goodsStatus;
	/*  */
	private String goodsStorageType;
	/*  */
	private Long goodsTypeId;
	/*  */
	private Long goodsUnitId;
	/*  */
	private Integer isDelete;
	/*  */
	private BigDecimal terminalDeliveryPrice;
	/*  */
	private BigDecimal terminalRaisePrice;
	/*  */
	private BigDecimal treatyDeliveryPrice;
	/*  */
	private BigDecimal treatyRaisePrice;
	/*  */
	private Date putTime;
	/*  */
	private Integer indexFlag;
	/*  */
	private Integer goodsSort;

}
