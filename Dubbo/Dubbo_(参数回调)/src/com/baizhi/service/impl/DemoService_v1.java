package com.baizhi.service.impl;

import java.util.Date;
import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
import com.baizhi.entity.Computer;
import com.baizhi.entity.User;
import com.baizhi.service.CallbackListener;
import com.baizhi.service.IDemoService;

public class DemoService_v1 implements IDemoService {

	public Computer methodInvoke(String value, CallbackListener callbackListener) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setName(value);
		System.out.println("-----------");
		User callUser = callbackListener.callBack(user);
		callUser.getComputer().setId(1);
		System.out.println(callUser.getComputer().getName());
		
		System.out.println(callUser.getComputer());
		
		return callUser.getComputer();
	}

}
