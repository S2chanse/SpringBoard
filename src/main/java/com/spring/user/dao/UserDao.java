package com.spring.user.dao;

import java.util.HashMap;

import com.spring.user.vo.UserVo;

public interface UserDao {

	UserVo getUserInfo(HashMap<String, Object> map);

}
