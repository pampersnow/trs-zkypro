package com.trs.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.trs.bean.User;

public interface UserService {
	 public List<User> findAll();
	 public User getinfo(@Param("userid")  int userid);
}
