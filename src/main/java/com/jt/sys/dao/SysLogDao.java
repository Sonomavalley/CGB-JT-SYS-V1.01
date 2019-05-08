package com.jt.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.sys.entity.SysLog;

public interface SysLogDao {
	 /**
	  * 基于查询条件查询当前页数据
	  * @param username 用户名
	  * @param startIndex 起始位置
	  * @param pageSize  页面大小(每页最多显示多少条记录)
	  * 说明:分页语句limit startIndex,pageSize
	  * @return
	  */
	 List<SysLog> findPageObjects(
			 @Param("username")String username,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
	 
	 
	 /**按用户名获取记录总数
	  * 当dao接口方法中的参数应用在mybatis的动态
	  * sql中时,无论方法中的参数有几个,都要使用
	  * @Param 注解对参数进行定义.
	  * 
	  * @param username 是查询条件
	  * */
	 int getRowCount(@Param("username")String username);
}






