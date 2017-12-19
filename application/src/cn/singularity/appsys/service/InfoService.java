package cn.singularity.appsys.service;

import java.util.List;

import cn.singularity.appsys.common.PageUtility;
import cn.singularity.appsys.pojo.Dictionary;
import cn.singularity.appsys.pojo.Info;



public interface InfoService {
	
	
	
	List<Info> getinfoList();
	
	List<Info> getAppselect(Info info,PageUtility pageUtility );
	
	int getAppCount();
}
