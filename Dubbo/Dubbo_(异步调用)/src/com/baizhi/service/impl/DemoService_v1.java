package com.baizhi.service.impl;

import java.util.Date;
import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
import com.baizhi.service.IDemoService;

public class DemoService_v1 implements IDemoService {

	public int sum(Integer x, Integer y) {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return x+y;
	}

	public int multi(Integer x, Integer y) {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return x*y;
	}

	public String methodInvoke() {
		// TODO Auto-generated method stub
		return "node-A";
	}

}
