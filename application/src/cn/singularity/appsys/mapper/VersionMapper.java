package cn.singularity.appsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import cn.singularity.appsys.pojo.Version;

public interface VersionMapper {
	
	@Select({
		"<script>",
		"select",
		"v.id, v.appId, v.versionNo, v.versionInfo, v.publishStatus, v.downloadLink, v.versionSize, v.createdBy,", 
	    "v.creationDate, v.modifyBy, v.modifyDate, v.apkLocPath, v.apkFileName,",
	    "i.id, i.softwareName, i.APKName, i.supportROM, i.interfaceLanguage, i.softwareSize, i.updateDate,",
	    "i.devId, i.appInfo, i.status, i.onSaleDate, i.offSaleDate, i.flatformId, i.categoryLevel3, i.downloads,",
	    "i.createdBy, i.creationDate, i.modifyBy, i.modifyDate, i.categoryLevel1, i.categoryLevel2, i.logoPicPath,", 
	    "i.logoLocPath, i.versionId,",
	    "(SELECT valueName FROM data_dictionary d WHERE d.typeCode = 'APP_STATUS' and d.valueId = v.publishStatus ) publishstatusname",
		"from app_version v",
		"left join app_info i on i.id=v.appId",
		"</script>"
	})
	@ResultMap("BaseResultMap")
	List<Version> selectVersionList();
	
    int deleteByPrimaryKey(Long id);

    int insert(Version record);

    int insertSelective(Version record);

    Version selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKey(Version record);
}