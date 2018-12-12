package com.trs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trs.bean.User;
import com.trs.service.UserService;

@RestController
@RequestMapping("user")  
public class UserController {

	@Autowired
	private UserService userService;
	
	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;
	
	 /**
	    * 获取所有的数据信息
      * @return
      */
	@SuppressWarnings("unchecked")
	@RequestMapping("/findall")
	public List<User> findALL() throws Exception{
		//从redis中取出某一个key下面的list列表， 0表示从列表的第0个元素开始取，-1表示直取到倒数第一个元素，也就是整个列表的所有元素都取出来。
		 List<User> list = redisTemplate.opsForList().range("user", 0, -1);
		//如果缓存中的数据为空的时候进行重新获取数据
		 if (list.size()==0) {
			list=userService.findAll();
		}
	  //返回		   
		return list;
		}

}
