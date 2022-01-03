package com.bz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bz.entity.MonthSettle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 14:47:33
 */
@Mapper
public interface MonthSettleDao extends BaseMapper<MonthSettle> {

	List<MonthSettle> getMonthSettleByPage(MonthSettle monthSettle);
}
