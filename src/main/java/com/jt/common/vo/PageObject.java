package com.jt.common.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 业务层VO:借助此对象封装记录以及分页信息
 * @author Administrator
 * @param <T>
 */
public class PageObject<T> implements Serializable {

	private static final long serialVersionUID = -4288938782658423221L;
	/**用于存储当前页的记录信息*/
	private List<T> records;
	/**总记录数*/
	private Integer rowCount=0;//null
	/**记录总页数*/
	private Integer pageCount=0;
	/**当前页页码*/
	private Integer pageCurrent=1;
	/**页面大小(每页最多显示多少条)*/
	private Integer pageSize=3;
	//.....
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
}




