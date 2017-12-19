package cn.singularity.appsys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.singularity.appsys.mapper.InfoMapper;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;
import cn.singularity.appsys.service.InfoService;
@Service
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	private	InfoMapper infomapper;
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Info> getinfoList() {

		return infomapper.getinfoList();
	}

		


}
