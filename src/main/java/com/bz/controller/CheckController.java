package com.bz.controller;

import com.bz.dto.CustomerDto;
import com.bz.dto.NewspaperDto;
import com.bz.entity.CustomerEntity;
import com.bz.entity.NewspaperEntity;
import com.bz.result.Result;
import com.bz.security.utils.PageTableRequest;
import com.bz.service.BzService;
import com.bz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: CheckController</p>
 * Description：审核中心
 * date：2021/8/24 16:34
 */
@Controller
@RequestMapping("/pc/verify")
public class CheckController extends BaseController{

	@Autowired
	BzService bzService;

	@Autowired
	CustomerService customerService;

	private String projectUrl;

	@RequestMapping("/newspaper/index")
	public String newspaperIndex(Model model, HttpServletRequest request){
		model.addAttribute("projectName", projectName);
		if(projectUrl == null){
			projectUrl = request.getRequestURL().toString().split(request.getContextPath())[0] + request.getContextPath();
		}
		model.addAttribute("projectUrl", projectUrl);
		return "system/bz/index";
	}

	@ResponseBody
	@PostMapping("/newspaper/findList")
	public Result<NewspaperEntity> findNewspaperList(PageTableRequest pageTableRequest, NewspaperDto newspaperDto){
		pageTableRequest.countOffset();
		return bzService.findList(pageTableRequest.getOffset(), pageTableRequest.getLimit(), newspaperDto);
	}

	@ResponseBody
	@PostMapping("/newspaper/updateStatus")
	public Result updateStatus(@RequestBody NewspaperDto newspaperDto){
		return Result.judge(bzService.updateStatus(newspaperDto), newspaperDto.getStatus().equals("1")?"受理": newspaperDto.getStatus().equals("2")?"完成":"取消");
	}

	@RequestMapping("/openAnAccount/index")
	public String openAnAccountIndex(Model model, HttpServletRequest request){
		model.addAttribute("projectName", projectName);
		if(projectUrl == null){
			projectUrl = request.getRequestURL().toString().split(request.getContextPath())[0] + request.getContextPath();
		}
		return "system/kh/index";
	}

	@ResponseBody
	@PostMapping("/customer/findList")
	public Result<CustomerEntity> findCustomerList(PageTableRequest pageTableRequest, CustomerDto customerDto){
		pageTableRequest.countOffset();
		return customerService.findList(pageTableRequest.getOffset(), pageTableRequest.getLimit(), customerDto);
	}

	@ResponseBody
	@PostMapping("/customer/updateStatus")
	public Result updateStatus(@RequestBody CustomerDto customerDto){
		return Result.judge(customerService.updateStatus(customerDto), customerDto.getStatus().equals("1")?"受理": customerDto.getStatus().equals("2")?"完成":"取消");
	}
}
