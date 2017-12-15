package cn.singularity.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.singularity.appsys.common.PageUtil;
import cn.singularity.appsys.mapper.CategoryMapper;
import cn.singularity.appsys.mapper.DictionaryMapper;
import cn.singularity.appsys.mapper.InfoMapper;
import cn.singularity.appsys.pojo.Category;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;
import cn.singularity.appsys.service.AppService;

/**
 * app服务接口的一个实现
 * @author zh
 */
@Service
@Transactional
public class AppServiceImpl implements AppService{

	@Autowired
	InfoMapper infoMapper;
	@Autowired
	DictionaryMapper dictionaryMapper;
	@Autowired
	CategoryMapper categoryMapper;
	
	/**
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Info> appInfoList(PageUtil pageUtil) {
		return infoMapper.getList(pageUtil);
	}
	
	/**
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public int getCount() {
		return infoMapper.count();
	}
	
	/**
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Dictionary> getAllStatus() {
		
		return dictionaryMapper.getAllStatuse();
	}
	
	/**
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Dictionary> getAllFlatform() {
		return dictionaryMapper.getAllFlatform();
	}
	
	/**
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Category> getCategoryListByParentId(Long id) {
		return categoryMapper.getCategoryListByParentId(id);
	}

}
