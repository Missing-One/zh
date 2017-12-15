package cn.singularity.appsys.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.singularity.appsys.pojo.Category;

public interface CategoryMapper {
	
	
	@Select({"<script>",
		"select",
		"id, categoryCode, categoryName, parentId, createdBy, creationTime, modifyBy, modifyDate",
		"from app_category where",
		"<if test='id==null'>parentId is null</if>",
		"<if test='id!=null'>parentId = #{id}</if>",
		"</script>"
	})
	List<Category> getCategoryListByParentId(@Param("id")Long id);
	
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}