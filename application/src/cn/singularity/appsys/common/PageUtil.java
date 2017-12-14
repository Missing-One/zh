package cn.singularity.appsys.common;

public class PageUtil {
	private long pageSize;				//显示的数量
	private long totalCount;			//数据的总数
	private long currentPageNo;			//当前页码
	private long currentPageNoIndex;	//当前页码的下标
	private long totalPageCount;		//页面的中数，多少页
	
	
	public PageUtil() {
		super();
		pageSize = 8;
		currentPageNo = 1;
	}
	
	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getCurrentPageNo() {
		//long i = (currentPageNo - 1) > 0? currentPageNo - 1: 0;
		return currentPageNo;
	}
	public void setCurrentPageNo(long currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	
	public long getCurrentPageNoIndex() {
		currentPageNoIndex = (currentPageNo - 1) > 0? currentPageNo - 1: 0;
		return currentPageNoIndex * pageSize;
	}

	public void setCurrentPageNoIndex(long currentPageNoIndex) {
		this.currentPageNoIndex = currentPageNoIndex;
	}

	public long getTotalPageCount() {
		return totalPageCount = (totalCount % pageSize) > 0
								? (totalCount / pageSize) +1
								: totalCount / pageSize;
	}

	@Override
	public String toString() {
		return "Paging [pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", currentPageNo=" + currentPageNo + ", currentPageNoIndex="
				+ currentPageNoIndex + ", totalPageCount=" + totalPageCount
				+ "]";
	}
	
		
}