package com.baizhi.service.impl;

import java.util.Date;

import com.baizhi.entity.Computer;
import com.baizhi.entity.User;
import com.baizhi.service.IDemoService;

public class DemoService_v1 implements IDemoService {

	public int sum(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	public int multi(Integer x, Integer y) {
		// TODO Auto-generated method stub
		return x*y;
	}

	public String methodInvoke() {
		// TODO Auto-generated method stub
		System.out.println("方法被调用了@"+new Date().toLocaleString()+"@时间");
		return "node-A";
	}

	public User queryUser(Integer id) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(id);
		user.setName("张三"+id);
		Computer computer=new Computer();
		computer.setId(id);
		computer.setName("张三的电脑");
		user.setComputer(computer);
		return user;
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("用户保存了");
		System.out.println(user.getName());
		System.out.println(user.getComputer().getName());
	}
	
}
