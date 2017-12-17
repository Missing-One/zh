package cn.singularity.appsys.utils.pojo;

/**
 * 查询条件
 * @author zh
 */
public class QueryCondition {
	
	private Long pageIndex;
	private String querysoftwarename;
	private Integer queryStatus;
	private Integer queryFlatformId;
	private Integer queryCategoryLevel1;
	private Integer queryCategoryLevel2;
	private Integer queryCategoryLevel3;
	
	
	public QueryCondition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getQuerysoftwarename() {
		return querysoftwarename;
	}
	public void setQuerysoftwarename(String querysoftwarename) {
		this.querysoftwarename = querysoftwarename;
	}
	public Integer getQueryStatus() {
		return queryStatus;
	}
	public void setQueryStatus(Integer queryStatus) {
		this.queryStatus = queryStatus;
	}
	public Integer getQueryFlatformId() {
		return queryFlatformId;
	}
	public void setQueryFlatformId(Integer queryFlatformId) {
		this.queryFlatformId = queryFlatformId;
	}
	public Integer getQueryCategoryLevel1() {
		return queryCategoryLevel1;
	}
	public void setQueryCategoryLevel1(Integer queryCategoryLevel1) {
		this.queryCategoryLevel1 = queryCategoryLevel1;
	}
	public Integer getQueryCategoryLevel2() {
		return queryCategoryLevel2;
	}
	public void setQueryCategoryLevel2(Integer queryCategoryLevel2) {
		this.queryCategoryLevel2 = queryCategoryLevel2;
	}
	public Integer getQueryCategoryLevel3() {
		return queryCategoryLevel3;
	}
	public void setQueryCategoryLevel3(Integer queryCategoryLevel3) {
		this.queryCategoryLevel3 = queryCategoryLevel3;
	}
	@Override
	public String toString() {
		return "QueryCondition [pageIndex=" + pageIndex
				+ ", querysoftwarename=" + querysoftwarename + ", queryStatus="
				+ queryStatus + ", queryFlatformId=" + queryFlatformId
				+ ", queryCategoryLevel1=" + queryCategoryLevel1
				+ ", queryCategoryLevel2=" + queryCategoryLevel2
				+ ", queryCategoryLevel3=" + queryCategoryLevel3 + "]";
	}
	
		
}
