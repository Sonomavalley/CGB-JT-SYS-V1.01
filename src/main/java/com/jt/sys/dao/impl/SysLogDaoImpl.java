package com.jt.sys.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;

@Repository //修饰数据层对象
public class SysLogDaoImpl implements SysLogDao {
    @Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public List<SysLog> findPageObjects(
			String username, 
			Integer startIndex, 
			Integer pageSize) {
		SqlSession session=sqlSessionFactory.openSession();
		String statement="com.jt.sys.dao.SysLogDao.findPageObjects";
		Map<String,Object> map=new HashMap<>();
		map.put("username",username);
		map.put("startIndex",startIndex);
		map.put("pageSize", pageSize);
		List<SysLog> list=session.selectList(statement, map);
	    session.close();
		return list;
	}
	@Override
	public int getRowCount(String username) {
		SqlSession session=sqlSessionFactory.openSession();
		Map<String,Object> map=new HashMap<>();
		map.put("username",username);//@Param("username")
		String statement="com.jt.sys.dao.SysLogDao.getRowCount";
		int rowCount=
	    session.selectOne(statement,map);
		session.close();
		return rowCount;
	}

}
