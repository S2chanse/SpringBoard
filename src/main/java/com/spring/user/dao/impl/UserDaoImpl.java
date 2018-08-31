package com.spring.user.dao.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.user.dao.UserDao;
import com.spring.user.vo.UserVo;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
@Autowired
private SqlSession sqlSession;

@Override
public UserVo getUserInfo(HashMap<String, Object> map) {
	UserVo vo=sqlSession.selectOne("User.GetInfo", map);
	return vo;
}
}
