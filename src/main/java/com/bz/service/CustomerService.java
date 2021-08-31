package com.bz.service;

import com.bz.dao.CustomerDao;
import com.bz.dto.CustomerDto;
import com.bz.entity.CustomerEntity;
import com.bz.result.Result;
import com.bz.result.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List<CustomerEntity> findOpenAnAccount(String verification) {
		return customerDao.findOpenAnAccount(verification);
	}

	public int submit(CustomerEntity customer) {
		customer.setStatus("0");
		Random random = new Random();
		customer.setApplicationCoding(new SimpleDateFormat("yyyyMMdd").format(customer.getCreateTime()) + random.nextInt(1000));
		return customerDao.submit(customer);
	}

	public Result<CustomerEntity> findList(Integer offset, Integer limit, CustomerDto customerDto) {
		Page page = PageHelper.offsetPage(offset, limit);
		List<CustomerEntity> fuzzyCustomerByPage = customerDao.getFuzzyCustomerByPage(customerDto);
		return Result.ok().count(page.getTotal()).data(fuzzyCustomerByPage).code(ResultUtil.RESULT_SUCCESS);
	}

	public int updateStatus(CustomerDto customerDto) {
		return customerDao.updateStatus(customerDto);
	}

	public CustomerEntity getBzById(Integer id) {
		return customerDao.getBzById(id);
	}

	public Integer getCustomerByVerification(String verification) {
		return customerDao.getCustomerByVerification(verification);
	}
}