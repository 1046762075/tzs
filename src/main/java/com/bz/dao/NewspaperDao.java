package com.bz.dao;


import com.bz.dto.NewspaperDto;
import com.bz.entity.NewspaperEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author lsl
 * @email 1046762075@qq.com
 * @date 2021-08-23 15:19:44
 */
@Mapper
public interface NewspaperDao {

	int submit(NewspaperEntity newspaper);

	List<NewspaperEntity> findInstallationRecord(@Param("verification") String verification);

	List<NewspaperEntity> getFuzzyNewspaperByPage(NewspaperDto newspaperDto);

	int updateStatus(NewspaperDto newspaperDto);

	NewspaperEntity getBzById(@Param("id") Integer id);
}
