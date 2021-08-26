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

import java.util.List;

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
		return newspaperDao.submit(newspaper);
	}

	public List<NewspaperEntity> findInstallationRecord(NewspaperEntity verification) {
		return newspaperDao.findInstallationRecord(verification.getVerification());
	}

	/**
	 * 客服人员查询查询所有客户的报装列表
	 */
	public Result<NewspaperEntity> findList(Integer offect, Integer limit,NewspaperDto newspaperDto) {
		Page page = PageHelper.offsetPage(offect, limit);
		List<NewspaperEntity> fuzzyNewspaperByPage = newspaperDao.getFuzzyNewspaperByPage(newspaperDto);
		return Result.ok().count(page.getTotal()).data(fuzzyNewspaperByPage).code(ResultUtil.RESULT_SUCCESS);
	}

	public int updateStatus(NewspaperDto newspaperDto) {
		return newspaperDao.updateStatus(newspaperDto);
	}
}
