package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysLog;

public interface SysLogService {
     /**
      * 查询当前页记录以及总记录数并对其进行封装
      * @param username  查询条件"用户名"
      * @param pageCurrent 当前页的页码
      * @return
      */
	 PageObject<SysLog> findPageObjects(
			 String username,
			 Integer pageCurrent);
	 
	 
}



