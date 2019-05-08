package com.jt.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysLog;
import com.jt.sys.service.SysLogService;
/**Spring MVC中的控制层对象(后端控制器)*/
@Controller
@RequestMapping("/log/")
public class SysLogController {//Handler
	  @Autowired
	  private SysLogService sysLogService;
	  
      @RequestMapping("doFindPageObjects")
      @ResponseBody
	  public JsonResult doFindPageObjects(
			  String username,Integer pageCurrent){
		  PageObject<SysLog> pageObject=
    	  sysLogService.findPageObjects(username,
				  pageCurrent);
		  return new JsonResult(pageObject);
	  }//借助JsonResult对象封装控制层要返回的结果
}






