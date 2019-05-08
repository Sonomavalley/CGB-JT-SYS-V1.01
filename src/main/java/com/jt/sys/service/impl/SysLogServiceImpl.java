package com.jt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.service.SysLogService;
/**业务层对象
 * @Service 注解对于spring底层矿建而言与@Controller注解
 * 的待遇一样的(Spring都会将其看成是由它管理的Bean对象).
 * */
@Service //<bean id="" class="">
public class SysLogServiceImpl implements SysLogService {
    //DI (SPRING)
	//告诉spring帮我找这个类型的对象,然后给我注入
	@Autowired
	//@Qualifier("sysLogDaoImpl")//按名字"sysLogDaoImpl"从容器找对象,然后进行DI
	private SysLogDao sysLogDao;//ref 
	/*@Autowired
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}*/
	@Override
	public PageObject<SysLog> findPageObjects(
			String username, 
			Integer pageCurrent) {
		//1.判定pageCurrent参数的合法性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.基于用户名统计日志记录总数
		int rowCount=sysLogDao.getRowCount(username);
		//3.对日志记录总数进行验证(总数为0就没有必要继续查询了)
		if(rowCount==0)
		throw new ServiceException("记录不存在");
		//4.查询当前页要显示的记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records=
		sysLogDao.findPageObjects(username, 
				startIndex, pageSize);//limit startIndex,pageSize
		//5.对象查询的记录,总记录数以及相关分页信息进行封装.
		PageObject<SysLog> po=new PageObject<>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		//int pageCount=rowCount/pageSize;
		//if(rowCount%pageSize!=0)pageCount++;
		int pageCount=(rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);//总页数
		//6.返回结果
		return po;
	}

}






