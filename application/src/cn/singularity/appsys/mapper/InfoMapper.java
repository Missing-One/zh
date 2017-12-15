package cn.singularity.appsys.mapper;

import java.util.List;

import cn.singularity.appsys.common.PageUtil;
import cn.singularity.appsys.pojo.Info;

public interface InfoMapper {
	
	/**
	 * 获取app信息的总数
	 */
	int count();
	/**
	 * 分页查询
	 * @return
	 */
	List<Info> getList(PageUtil pageUtil);
	
	int deleteByPrimaryKey(Long id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}