package com.baizhi.service;

import java.util.Date;
import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
import com.baizhi.entity.Computer;
import com.baizhi.entity.User;

public class DemoServicemock implements IDemoService {
	
	public User methodInvoke(Integer id, String name) {
		// TODO Auto-generated method stub
		 User user=new User();
		 user.setName("不可用");
		 user.setId(-1);
		return user;
	}
   

}
