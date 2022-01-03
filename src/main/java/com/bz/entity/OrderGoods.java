package com.bz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 15:36:16
 */
@Data
@TableName("order_goods")
public class OrderGoods implements Serializable {
	private static final long serialVersionUID = 1L;

	/*  */
	@TableId(type = IdType.AUTO)
	private Long id;
	/*  */
	private Integer couponDeductNum;
	/*  */
	private String couponImg;
	/*  */
	private Long goodsId;
	/*  */
	private String goodsName;
	/*  */
	private Integer goodsNum;
	/*  */
	private BigDecimal goodsPrice;
	/*  */
	private String goodsSpecsName;
	/*  */
	private Integer goodsWaterDeductNum;
	/*  */
	private Long goodsWaterId;
	/*  */
	private String goodsWaterName;
	/*  */
	private Integer goodsWaterNum;
	/*  */
	private Integer monthDeductNum;
	/*  */
	private String monthImg;
	/*  */
	private Long orderId;
	/*  */
	private String goodsCategoryName;
	/*  */
	private String goodsImg;
	/*  */
	private String goodsUnitName;
	/*  */
	private String orderGoodsDesc;
	/*  */
	private String payMode;
	/*  */
	private Integer monthTakeNum;
	/*  */
	private BigDecimal monthTakePrice;
	/*  */
	private Integer sendNum;

}
