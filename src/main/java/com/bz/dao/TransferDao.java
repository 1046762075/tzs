package com.bz.dao;

import com.bz.dto.TransferDto;
import com.bz.entity.MyTransferEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author lsl
 * @email 1046762075@qq.com
 * @date 2021-08-31 09:09:25
 */
@Mapper
public interface TransferDao {

	List<MyTransferEntity> findAll(@Param("verification") String verification);

	int save(MyTransferEntity transfer);

	List<MyTransferEntity> getFuzzyTransferByPage(TransferDto transferDto);

	int updateStatus(TransferDto transferDto);

	MyTransferEntity getGhById(Integer id);
}
