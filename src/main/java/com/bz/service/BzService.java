package com.bz.service;

import com.bz.dao.NewspaperDao;
import com.bz.dto.NewspaperDto;
import com.bz.entity.NewspaperEntity;
import com.bz.result.Result;
import com.bz.result.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

/**
 * <p>Title: bxService</p>
 * Description：
 * date：2021/8/23 15:13
 */
@Service
public class BzService {

	@Autowired
	NewspaperDao newspaperDao;

	public int submit(NewspaperEntity newspaper) {
		newspaper.setStatus("0");
		Random random = new Random();
		newspaper.setApplicationCoding(new SimpleDateFormat("yyyyMMdd").format(newspaper.getApplicationTime()) + random.nextInt(1000));
		return newspaperDao.submit(newspaper);
	}

	public List<NewspaperEntity> findInstallationRecord(String verification) {
		return newspaperDao.findInstallationRecord(verification);
	}

	/**
	 * 客服人员查询查询所有客户的报装列表
	 */
	public Result<NewspaperEntity> findList(Integer offset, Integer limit,NewspaperDto newspaperDto) {
		Page page = PageHelper.offsetPage(offset, limit);
		List<NewspaperEntity> fuzzyNewspaperByPage = newspaperDao.getFuzzyNewspaperByPage(newspaperDto);
		return Result.ok().count(page.getTotal()).data(fuzzyNewspaperByPage).code(ResultUtil.RESULT_SUCCESS);
	}

	public int updateStatus(NewspaperDto newspaperDto) {
		return newspaperDao.updateStatus(newspaperDto);
	}
}
