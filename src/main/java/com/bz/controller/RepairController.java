package com.bz.controller;

import com.bz.entity.NewspaperEntity;
import com.bz.result.ResultResponse;
import com.bz.result.ResultUtil;
import com.bz.service.BzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: RepairController</p>
 * Description：
 * date：2021/8/23 11:23
 */
@Controller
@RequestMapping("/bx")
public class RepairController extends BaseController{

	@Autowired
	BzService bxService;

	@Value("${upload.address}")
	String filePath;

	@Value("${upload.domain}")
	String domain;

	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("projectName", projectName);
		return "/bz/home";
	}

	@GetMapping("test")
	public String test(){
		return "index1";
	}

	@GetMapping("test2")
	public String test2(){
		return "index2";
	}

	/**
	 * TODO 客户访问这个请求需要带上 openid
	 */
	@GetMapping("/newspaper")
	public String newspaper(Model model){
		model.addAttribute("projectName", projectName);
		model.addAttribute("verification", "18173516309");
		model.addAttribute("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return "/bz/newspaper";
	}

	@ResponseBody
	@PostMapping("/upload")
	public Object upload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResultResponse(ResultUtil.RESULT_ERROR,"上传失败，请选择文件");
		}
		String name = updateFile(file);
		if (name != null) return new ResultResponse(ResultUtil.RESULT_SUCCESS, name);
		return new ResultResponse(ResultUtil.RESULT_ERROR,"上传成功");
	}

	private String updateFile(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		File dest = new File(filePath + fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			return domain + filePath + fileName;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@ResponseBody
	@PostMapping("/submit")
	public Object submit(@RequestParam("file") MultipartFile file, NewspaperEntity newspaper, HttpServletRequest request){
		try {
			if (file.isEmpty()) {
				return new ResultResponse(ResultUtil.RESULT_ERROR,"上传失败，请选择文件");
			}
			newspaper.setMaterial(updateFile(file));
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

	@ResponseBody
	@PostMapping("/findInstallationRecord")
	public Object findInstallationRecord(@RequestBody NewspaperEntity verification){
		try {
			return new ResultResponse(ResultUtil.RESULT_SUCCESS, "查询成功", this.bxService.findInstallationRecord(verification));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultResponse(ResultUtil.RESULT_ERROR, e.getMessage());
		}
	}
}
