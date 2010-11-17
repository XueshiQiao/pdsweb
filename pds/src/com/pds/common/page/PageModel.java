/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.common.page;

/**
 * @author qiaoxueshi
 *
 */
import java.util.List;

public class PageModel<T> implements Paginable<T> {
	
	private final int DEFAULT_PAGE_SIZE = 10;
	private final int DEFAULT_PAGE_NO = 1;
	

	private List<T> list; // 结果
	
	private int pageNo;// 当前页
	private int pageCount; // 页数
	private int pageSize; // 每页大小
	private int totalCount; // 总行数

	public PageModel() {
	}
	
	/**
	 * 构造方法
	 * @param list 要在前台页面中显示的数据，大小为pageSize大小
	 * @param totalCount 该类型记录的总数
	 * @param pageNo 当前是第几页
	 * @param pageSize 每页的记录数
	 */
	public PageModel(List<T> list, int totalCount, int pageNo,int pageSize) {
		this.totalCount = totalCount;
		this.list = list;
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		
		this.adjustData();
	}
	
	/**
	 * 使数据合理化
	 */
	public void adjustData(){
		if(pageSize<1){
			this.pageSize = this.DEFAULT_PAGE_SIZE;
		}
		if(pageNo<1){
			this.pageNo = this.DEFAULT_PAGE_NO;
		}
		this.pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount
				/ pageSize + 1;
		
		if(pageNo>this.pageCount){
			pageNo = this.pageCount;
		}
	}

	/* (non-Javadoc)
	 * @see com.pds.common.page.Paginable#isLastPage()
	 */
	public boolean isLastPage() {
		return this.pageNo == getPageCount();
	}

	/* (non-Javadoc)
	 * @see com.pds.common.page.Paginable#getPageCount()
	 */
	public int getPageCount() {
		return this.pageCount;
	}

	/* (non-Javadoc)
	 * @see com.pds.common.page.Paginable#getPageSize()
	 */
	public int getPageSize() {
		return pageSize;
	}

	/* (non-Javadoc)
	 * @see com.pds.common.page.Paginable#getTotalCount()
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/* (non-Javadoc)
	 * @see com.pds.common.page.Paginable#isFirstPage()
	 */
	public boolean isFirstPage() {
		return this.pageNo == 1;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount < 1 ? 1 : pageCount;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/* (non-Javadoc)
	 * @see com.pds.common.page.Paginable#getList()
	 */
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see com.pds.common.page.Paginable#getPageNo()
	 */
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		System.out.println(this.isFirstPage()+","+this.isLastPage());
		return "PageModel [list=" + list + ", pageCount=" + pageCount
				+ ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + "]";
	}

	
	
	
	
}
