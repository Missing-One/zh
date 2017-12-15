package cn.singularity.appsys.common;

/**
 * 分页工具
 * @author zh
 */
public class PageUtil {
	private long pageSize;				//显示的数量
	private long totalCount;			//数据的总数
	private long currentPageNo;			//当前页码
	private long currentPageNoIndex;	//当前页码的下标
	private long totalPageCount;		//页面的中数，多少页
	
	/**
	 * 默认一页显示8行数据
	 * 需要提供页面总数量
	 */
	public PageUtil(int totalCount) {
		super();
		this.totalCount = totalCount;
		this.pageSize = 8;
		this.currentPageNo = 1;
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
	
	public void setCurrentPageNo(String currentPageNo) {
		try {
			this.currentPageNo = Long.parseLong(currentPageNo);
		}catch (NumberFormatException e) {
			System.err.println("设置页码出错：" + e);
		}
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
		return "PageUtil [pageSize=" + pageSize + ", totalCount=" + totalCount + ", currentPageNo=" + currentPageNo
				+ ", currentPageNoIndex=" + currentPageNoIndex + ", totalPageCount=" + totalPageCount + "]";
	}
	
		
}