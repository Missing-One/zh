package cn.singularity.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.singularity.appsys.common.PageUtil;
import cn.singularity.appsys.mapper.DictionaryMapper;
import cn.singularity.appsys.mapper.InfoMapper;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;
import cn.singularity.appsys.service.AppInfoService;

@Service
@Transactional
public class AppServiceImpl implements AppInfoService{

	@Autowired
	InfoMapper infoMapper;
	
	@Autowired
	DictionaryMapper dictionaryMapper;
	
	@Override
	public List<Info> getList(PageUtil pageUtil) {
		return infoMapper.getList(pageUtil);
	}

	@Override
	public int getCount() {
		return infoMapper.count();
	}

	@Override
	public List<Dictionary> getAllStatus() {
		
		return dictionaryMapper.getAllStatuse();
	}

}
