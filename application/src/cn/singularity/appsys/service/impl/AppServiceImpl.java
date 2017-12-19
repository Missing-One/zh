package cn.singularity.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.singularity.appsys.common.PageUtility;
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
	public List<Info> appInfoList(Info info, PageUtility pageUtil) {
		return infoMapper.getList(info,pageUtil);
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
	
	/**
	 * 添加一条app信息
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
	@Override
	public boolean addApp(Info app) {
		
		return infoMapper.insert(app) > 0;
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Info getAppInfoById(Long id) {
		// TODO Auto-generated method stub
		return infoMapper.selectByPrimaryKey(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
	@Override
	public int delAppInfoById(Long id) {
		
		return infoMapper.deleteByPrimaryKey(id);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
	@Override
	public int modifyAppInfoById(Info app) {
		// TODO Auto-generated method stub
		return infoMapper.updateByPrimaryKeySelective(app);
	}

}
