package com.baizhi.service;

import java.util.Date;
import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
import com.baizhi.entity.Computer;
import com.baizhi.entity.User;

public class DemoServicestub implements IDemoService {
	private IDemoService demoService;
	public DemoServicestub(IDemoService demoService){
		this.demoService=demoService;
	}
	public User methodInvoke(Integer id, String name) {
		// TODO Auto-generated method stub
		return null;
	}
   

}
