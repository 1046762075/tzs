package com.bz.service;

import com.bz.dao.CustomerDao;
import com.bz.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List<CustomerEntity> findOpenAnAccount(String verification) {
		return customerDao.findOpenAnAccount(verification);
	}
}