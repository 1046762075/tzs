package com.bz.dao;

import com.bz.dto.CustomerDto;
import com.bz.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author lsl
 * @email 1046762075@qq.com
 * @date 2021-08-27 19:24:17
 */
@Mapper
public interface CustomerDao {

	List<CustomerEntity> findOpenAnAccount(String verification);

	int submit(CustomerEntity customer);

	List<CustomerEntity> getFuzzyCustomerByPage(CustomerDto customerDto);

	int updateStatus(CustomerDto customerDto);

	CustomerEntity getBzById(@Param("id") Integer id);
}
