package com.bz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bz.entity.OrderGoods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 15:36:16
 */
@Mapper
public interface OrderGoodsDao extends BaseMapper<OrderGoods> {

	List<OrderGoods> getOrderGoodsByPage(OrderGoods orderGoods);
}
