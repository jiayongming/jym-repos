package com.baizhi.service.impl;

import java.util.Date;
import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
import com.baizhi.entity.Computer;
import com.baizhi.entity.User;
import com.baizhi.service.IDemoService;

public class DemoService_v1 implements IDemoService {

	public User methodInvoke(Integer id, String name) {
		// TODO Auto-generated method stub
		System.out.println("id:"+id+","+name);
		User user = new User();
		user.setId(id);
		user.setName(name);
		return user;
	}
   
	

}
