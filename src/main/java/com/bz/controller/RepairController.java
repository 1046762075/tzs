package com.bz.controller;

import com.bz.entity.CustomerEntity;
import com.bz.entity.NewspaperEntity;
import com.bz.result.ResultResponse;
import com.bz.result.ResultUtil;
import com.bz.security.utils.FileUtils;
import com.bz.service.BzService;
import com.bz.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: RepairController</p>
 * Description：
 * date：2021/8/23 11:23
 */
@Controller
@RequestMapping("/bx")
public class RepairController extends FileUtils {

	@Autowired
	BzService bxService;

	@Autowired
	CustomerService customerService;

	@GetMapping("/login")
	public String login(Model model){
		model.addAttribute("projectName", projectName);
		return "app/login";
	}

	/**
	 * 这一步会将session里面写入一个verification
	 */
	@GetMapping("/index/{verification}")
	public String index(Model model, @PathVariable("verification") String verification){
		getSession().setAttribute("verification", verification);
		model.addAttribute("projectName", projectName);
		if(verification == null || verification.equals("")){
			return "app/login";
		}else {
			return "app/home";
		}
	}

	@GetMapping("/newspaper")
	public String newspaper(Model model){
		String verification = (String) getSession().getAttribute("verification");
		if(verification == null || verification.equals("")){
			return "app/login";
		}
		List<NewspaperEntity> entities = this.bxService.findInstallationRecord(verification);
		// jdk1.7
		List<NewspaperEntity> finish = new ArrayList<>();
		List<NewspaperEntity> undone = new ArrayList<>();
		for (NewspaperEntity entity : entities) {
			if(entity.getStatus().equals(NewspaperEntity.finish)){
				finish.add(entity);
			}else {
				undone.add(entity);
			}
		}
		model.addAttribute("newspapers", undone);
		model.addAttribute("finish", finish);
		model.addAttribute("projectName", projectName);
		model.addAttribute("verification", verification);
		model.addAttribute("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return "app/bz/newspaper";
	}

	@ResponseBody
	@PostMapping("/upload")
	public Object upload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResultResponse(ResultUtil.RESULT_ERROR,"上传失败，请选择文件");
		}
		String name = updateFile(file);
		if (name != null) return new ResultResponse(ResultUtil.RESULT_SUCCESS, "上传成功", name);
		return new ResultResponse(ResultUtil.RESULT_ERROR,"上传失败");
	}

	@ResponseBody
	@PostMapping("/newspaper/submit")
	public Object newspaperSubmit(NewspaperEntity newspaper){
		try {
			newspaper.setApplicationTime(new Date());
			if(this.bxService.submit(newspaper) == 1){
				return new ResultResponse(ResultUtil.RESULT_SUCCESS, "提交成功");
			} else {
				return new ResultResponse(ResultUtil.RESULT_ERROR, "提交失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultResponse(ResultUtil.RESULT_ERROR, e.getMessage());
		}
	}

	/**
	 * 查询我的报装
	 * @return
	 */
	@ResponseBody
	@PostMapping("/findInstallationRecord")
	public Object findInstallationRecord(){
		try {
			return new ResultResponse(ResultUtil.RESULT_SUCCESS, "查询成功", this.bxService.findInstallationRecord((String) getSession().getAttribute("verification")));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultResponse(ResultUtil.RESULT_ERROR, e.getMessage());
		}
	}


	// ===========================开户==============================
	@GetMapping("/openAnAccount")
	public String openAnAccount(Model model){
		String verification = (String) getSession().getAttribute("verification");
		if(verification == null || verification.equals("")){
			return "app/login";
		}
		List<CustomerEntity> entities = this.customerService.findOpenAnAccount(verification);
		// jdk1.7
		List<CustomerEntity> finish = new ArrayList<>();
		List<CustomerEntity> undone = new ArrayList<>();
		for (CustomerEntity entity : entities) {
			if(entity.getStatus().equals(CustomerEntity.finish)){
				finish.add(entity);
			}else {
				undone.add(entity);
			}
		}
		model.addAttribute("customers", undone);
		model.addAttribute("finish", finish);
		model.addAttribute("projectName", projectName);
		model.addAttribute("verification", verification);
		return "app/kh/openAnAccount";
	}

	@ResponseBody
	@PostMapping("/openAnAccount/submit")
	public Object openAnAccountSubmit(CustomerEntity customer){
		try {
			String[] materials = customer.getMaterialOne().split("\\?\\?");
			if(materials.length < 2){
				return new ResultResponse(ResultUtil.RESULT_ERROR, "请至少上传两种资料");
			}
			customer.setMaterialOne(materials[0]);
			customer.setMaterialTwo(materials[1]);
			customer.setVerification((String) getSession().getAttribute("verification"));
			if(materials.length > 2){
				customer.setMaterialThree(materials[2]);
			}
			customer.setCreateTime(new Date());
			if(this.customerService.submit(customer) == 1){
				return new ResultResponse(ResultUtil.RESULT_SUCCESS, "提交成功");
			} else {
				return new ResultResponse(ResultUtil.RESULT_ERROR, "提交失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultResponse(ResultUtil.RESULT_ERROR, e.getMessage());
		}
	}








	// ===========================过户==============================
	@GetMapping("/transfer")
	public String transfer(Model model){
		String verification = (String) getSession().getAttribute("verification");
		if(verification == null || verification.equals("")){
			return "app/login";
		}
		List<NewspaperEntity> entities = this.bxService.findInstallationRecord(verification);
		// jdk1.7
		List<NewspaperEntity> finish = new ArrayList<>();
		List<NewspaperEntity> undone = new ArrayList<>();
		for (NewspaperEntity entity : entities) {
			if(entity.getStatus().equals(NewspaperEntity.finish)){
				finish.add(entity);
			}else {
				undone.add(entity);
			}
		}
		model.addAttribute("newspapers", undone);
		model.addAttribute("finish", finish);
		model.addAttribute("projectName", projectName);
		model.addAttribute("verification", verification);
		return "app/gh/transfer";
	}
}
