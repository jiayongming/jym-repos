package com.baizhi.service.impl;

import com.baizhi.service.IDemoService;

public class DemoService_v2 implements IDemoService {

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
		return "1.1.1版本";
	}

}
