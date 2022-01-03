package com.bz.dao.zz;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bz.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * @author 云裂痕
 * @email 1046762075@qq.com
 * @date 2021-10-10 16:14:46
 */
@Mapper
public interface GoodsDao extends BaseMapper<Goods> {

	List<Goods> getGoodsByPage(Goods goods);
}
