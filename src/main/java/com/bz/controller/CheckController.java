package com.bz.controller;

import com.bz.dto.NewspaperDto;
import com.bz.entity.NewspaperEntity;
import com.bz.result.Result;
import com.bz.security.utils.PageTableRequest;
import com.bz.service.BzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("projectName", projectName);
		return "system/bz/index";
	}


	@ResponseBody
	@PostMapping("/findList")
	public Result<NewspaperEntity> findList(PageTableRequest pageTableRequest, NewspaperDto newspaperDto){
		pageTableRequest.countOffset();
		return bzService.findList(pageTableRequest.getOffset(), pageTableRequest.getLimit(), newspaperDto);
	}

	@ResponseBody
	@PostMapping("/updateStatus")
	public Result updateStatus(@RequestBody NewspaperDto newspaperDto){
		return Result.judge(bzService.updateStatus(newspaperDto), newspaperDto.getStatus().equals("1")?"受理":newspaperDto.equals("2")?"完成":"取消");
	}

}
