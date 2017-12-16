package cn.singularity.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.singularity.appsys.mapper.VersionMapper;
import cn.singularity.appsys.pojo.Version;
import cn.singularity.appsys.service.VersionService;

/**
 * 版本服务实现
 * @author zh
 */
@Service
@Transactional
public class VersionServiceImpl implements VersionService{

	@Autowired
	VersionMapper versionMapper; 
	
	@Override
	public List<Version> getVersionList() {
		return versionMapper.selectVersionList();
	}
	
}
