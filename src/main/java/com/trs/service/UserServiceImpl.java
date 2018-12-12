package com.trs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.trs.bean.User;
import com.trs.mapper.UserMapper;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		// TODO 存入redis数据
		 //清空
		while (redisTemplate.opsForList().size("user") > 0) {
			redisTemplate.opsForList().leftPop("user");
		}
		 //向redis的某个key下面的list列表里面插入一个list列表，不会去重。
		redisTemplate.opsForList().rightPushAll("user", userMapper.findAll());
		return userMapper.findAll();
	}

	@Override
	public User getinfo(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
