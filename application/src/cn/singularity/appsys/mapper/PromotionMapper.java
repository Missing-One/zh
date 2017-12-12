package cn.singularity.appsys.mapper;

import cn.singularity.appsys.pojo.Promotion;

public interface PromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Promotion record);

    int insertSelective(Promotion record);

    Promotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Promotion record);

    int updateByPrimaryKey(Promotion record);
}