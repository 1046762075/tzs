package com.bz.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 14:47:33
 */
@Data
@TableName("month_settle")
public class MonthSettle implements Serializable {
	private static final long serialVersionUID = 1L;

	/*  */
	@TableId
	private String createTime;
	/*  */
	private String customerName;
	/*  */
	private String goodsId;
	/*  */
	private String status;
	/*  */
	private Integer num;

}
