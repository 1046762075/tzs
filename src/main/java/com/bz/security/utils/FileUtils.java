package com.bz.security.utils;

import com.bz.controller.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * <p>Title: FileUtils</p>
 * Description：
 * date：2021/8/29 9:20
 */
public class FileUtils extends BaseController {

	@Value("${upload.address}")
	String filePath;

	@Value("${upload.domain}")
	String domain;

	public String path;
	{
		path = Thread.currentThread().getContextClassLoader().getResource("static").getPath();
	}

	/**
	 * 保存到static
	 */
	public String updateFile(@RequestParam("file") MultipartFile file) {
		Random random = new Random();
		String fileName = file.getOriginalFilename();
		String date = new SimpleDateFormat("yyMMdd").format(new Date()) + random.nextInt(1000);
		File dest = new File(this.path + filePath + date + fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			return filePath + date + fileName;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	//	private String updateFile(@RequestParam("file") MultipartFile file) {
//		Random random = new Random();
//		String fileName = file.getOriginalFilename();
//		String date = new SimpleDateFormat("yyMMdd").format(new Date()) + random.nextInt(1000);
//		File dest = new File(filePath + date + fileName);
//		if (!dest.getParentFile().exists()) {
//			dest.getParentFile().mkdirs();
//		}
//		try {
//			file.transferTo(dest);
//			return domain + filePath + date + fileName;
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}
}
