package com.bz.controller;

import com.bz.dto.CustomerDto;
import com.bz.dto.MaterialDto;
import com.bz.dto.NewspaperDto;
import com.bz.dto.TransferDto;
import com.bz.entity.CustomerEntity;
import com.bz.entity.MyTransferEntity;
import com.bz.entity.NewspaperEntity;
import com.bz.result.Result;
import com.bz.security.utils.FileUtils;
import com.bz.security.utils.PageTableRequest;
import com.bz.service.BzService;
import com.bz.service.CustomerService;
import com.bz.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Random;

/**
 * <p>Title: CheckController</p>
 * Description：审核中心
 * date：2021/8/24 16:34
 */
@Controller
@RequestMapping("/pc/verify")
public class CheckController extends FileUtils {

	@Autowired
	BzService bzService;

	@Autowired
	CustomerService customerService;

	@Autowired
	TransferService transferService;

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

	@GetMapping("/newspaper/desc")
	public String newspaperDesc(@RequestParam("id") Integer id, Model model){
		NewspaperEntity newspaper = bzService.getBzById(id);
		model.addAttribute("newspaper", newspaper);
		ArrayList<MaterialDto> materials = new ArrayList<>();
		for (String m : newspaper.getMaterial().split("\\?\\?")) {
			MaterialDto materialDto = new MaterialDto();

			if(m.startsWith("http") || m.startsWith("https")){
				Random random = new Random();
				materialDto.setName("node" + random.nextInt(100));
				materialDto.setAddress(m);
			}else {
				materialDto.setAddress(super.projectName + m);
				materialDto.setName(m.split(super.filePath)[1]);
			}
			materials.add(materialDto);
		}
		model.addAttribute("materials", materials);
		return "/system/bz/show";
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

	@GetMapping("/openAnAccount/desc")
	public String openAnAccountDesc(@RequestParam("id") Integer id, Model model){
		CustomerEntity customer = customerService.getBzById(id);
		ArrayList<MaterialDto> materials = new ArrayList<>();
		// 三张图
		if(customer.getMaterialOne() != null && !customer.getMaterialOne().equals("")){
			addImg(customer.getMaterialOne(), materials);
		}
		if(customer.getMaterialTwo() != null && !customer.getMaterialTwo().equals("")){
			addImg(customer.getMaterialTwo(), materials);
		}
		if(customer.getMaterialThree() != null && !customer.getMaterialThree().equals("")){
			addImg(customer.getMaterialThree(), materials);
		}
		if(customer.getMaterialFour() != null && !customer.getMaterialFour().equals("")){
			addImg(customer.getMaterialFour(), materials);
		}
		if(customer.getMaterialFive() != null && !customer.getMaterialFive().equals("")){
			addImg(customer.getMaterialFive(), materials);
		}
		model.addAttribute("materials", materials);
		model.addAttribute("customer", customer);
		return "/system/kh/show";
	}

	private void addImg(String img, ArrayList<MaterialDto> materials) {
		MaterialDto materialDto = new MaterialDto();
		if(img.startsWith("http") || img.startsWith("https")){
			Random random = new Random();
			materialDto.setName("node" + random.nextInt(100));
			materialDto.setAddress(img);
		}else {
			materialDto.setName(img.split(super.filePath)[1]);
			materialDto.setAddress(super.projectName + img);
		}

		materials.add(materialDto);
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

	@RequestMapping("/transfer/index")
	public String transferIndex(Model model, HttpServletRequest request){
		if(projectUrl == null){
			projectUrl = request.getRequestURL().toString().split(request.getContextPath())[0] + request.getContextPath();
		}
		model.addAttribute("projectName", projectName);
		model.addAttribute("projectUrl", projectUrl);
		return "system/gh/index";
	}

	@ResponseBody
	@PostMapping("/transfer/findList")
	public Result<MyTransferEntity> findTransferList(PageTableRequest pageTableRequest, TransferDto transferDto){
		pageTableRequest.countOffset();
		return transferService.findList(pageTableRequest.getOffset(), pageTableRequest.getLimit(), transferDto);
	}

	@ResponseBody
	@PostMapping("/transfer/updateStatus")
	public Result updateStatus(@RequestBody TransferDto transferDto){
		return Result.judge(transferService.updateStatus(transferDto), transferDto.getStatus().equals("1")?"受理": transferDto.getStatus().equals("2")?"完成":"取消");
	}

	@GetMapping("/transfer/desc")
	public String transferDesc(@RequestParam("id") Integer id, Model model){
		MyTransferEntity transfer = transferService.getGhById(id);
		ArrayList<MaterialDto> materials = new ArrayList<>();
		String[] imGs = transfer.getMaterials().split("\\?\\?");
		for (String img : imGs) {
			addImg(img, materials);
		}
		model.addAttribute("materials", materials);
		model.addAttribute("transfer", transfer);
		return "/system/gh/show";
	}
}
