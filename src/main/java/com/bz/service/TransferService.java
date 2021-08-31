package com.bz.service;

import com.bz.dao.CustomerDao;
import com.bz.dao.TransferDao;
import com.bz.dto.TransferDto;
import com.bz.entity.CustomerEntity;
import com.bz.entity.MyTransferEntity;
import com.bz.result.Result;
import com.bz.result.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

@Service("transferService")
public class TransferService {

	@Autowired
	TransferDao transferDao;

	@Autowired
	CustomerDao customerDao;


	public List<MyTransferEntity> findAll(String verification) {
		return transferDao.findAll(verification);
	}

	public int submit(MyTransferEntity transfer) {
		transfer.setStatus("0");
		Random random = new Random();
		transfer.setApplicationCoding(new SimpleDateFormat("yyyyMMdd").format(transfer.getCreateTime()) + random.nextInt(1000));
		return transferDao.save(transfer);
	}

	public Result<MyTransferEntity> findList(Integer offset, Integer limit, TransferDto transferDto) {
		Page page = PageHelper.offsetPage(offset, limit);
		List<MyTransferEntity> fuzzyTransferByPage = transferDao.getFuzzyTransferByPage(transferDto);
		return Result.ok().count(page.getTotal()).data(fuzzyTransferByPage).code(ResultUtil.RESULT_SUCCESS);
	}

	/**
	 * 过户审核
	 */
	@Transactional
	public int updateStatus(TransferDto transferDto) {
		// 当审核通过、退回的时候要给customer更换用户姓名、电话
		if(transferDto.getStatus().equals("2")){
			MyTransferEntity transfer = transferDao.getGhById(transferDto.getId());
			if(transfer.getCustomerId() != null){
				CustomerEntity customer = customerDao.getBzById(transfer.getCustomerId());
				customer.setMobileTelephone(transfer.getNewPhone());
				customer.setName(transfer.getNewUser());
				cutover(transferDto, transfer, customer, transfer.getNewUser());
			}
		}else if(transferDto.getStatus().equals("3")){
			MyTransferEntity transfer = transferDao.getGhById(transferDto.getId());
			if(transfer.getCustomerId() != null){
				CustomerEntity customer = customerDao.getBzById(transfer.getCustomerId());
				customer.setMobileTelephone(transfer.getOriginalPhone());
				customer.setName(transfer.getOriginalUser());
				cutover(transferDto, transfer, customer, transfer.getOriginalUser());
			}
		}
		return transferDao.updateStatus(transferDto);
	}

	private void cutover(TransferDto transferDto, MyTransferEntity transfer, CustomerEntity customer, String originalUser) {
		String v = customer.getVerification();
		customer.setVerification(transfer.getVerification());
		String[] imGs = transfer.getMaterials().split("\\?\\?");
		String customerImgs = "";
		customerImgs = addCustomerImgs(customer.getMaterialOne(), customerImgs);
		customerImgs = addCustomerImgs(customer.getMaterialTwo(), customerImgs);
		customerImgs = addCustomerImgs(customer.getMaterialThree(), customerImgs);
		customerImgs = addCustomerImgs(customer.getMaterialFour(), customerImgs);
		customerImgs = addCustomerImgs(customer.getMaterialFive(), customerImgs);
		customerImgs = addCustomerImgs(customer.getMaterialSex(), customerImgs);
		customer.setMaterialOne("");
		customer.setMaterialTwo("");
		customer.setMaterialThree("");
		customer.setMaterialFour("");
		customer.setMaterialFive("");
		customer.setMaterialSex("");
		if (imGs.length > 0) {
			customer.setMaterialOne(imGs[0]);
			if (imGs.length > 1) {
				customer.setMaterialTwo(imGs[1]);
				if (imGs.length > 2) {
					customer.setMaterialThree(imGs[2]);
					if (imGs.length > 3) {
						customer.setMaterialFour(imGs[3]);
						if (imGs.length > 4) {
							customer.setMaterialFive(imGs[4]);
							if (imGs.length > 5) {
								customer.setMaterialSex(imGs[5]);
							}
						}
					}
				}
			}
		}
		customer.setHandler(originalUser);
		customerDao.updateCustomerById(customer);
		transferDto.setImgs(customerImgs);
		transferDto.setVerification(v);
	}

	private String addCustomerImgs(String img, String customerImgs) {
		if(img != null && !img.equals("")){
			customerImgs += img + "??";
		}
		return customerImgs;
	}

	public MyTransferEntity getGhById(Integer id) {
		return transferDao.getGhById(id);
	}
}