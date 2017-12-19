package cn.singularity.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Version> getVersionList() {
		return versionMapper.selectVersionList();
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public List<Version> getAppVersionListById(long appId) {
		
		return versionMapper.selectVersionListByAppId(appId);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
	@Override
	public boolean addVersion(Version version) {
		return versionMapper.insertSelective(version) > 0;
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	@Override
	public Version getVersionById(Long id) {
		
		return versionMapper.selectByPrimaryKey(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
	@Override
	public boolean modifyVersion(Version version) {
		return versionMapper.updateByPrimaryKeySelective(version) > 0;
	}
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
	@Override
	public int delVersionListByAppId(Long id) {
		return versionMapper.deleteVersionListByAppId(id);
	}
}
