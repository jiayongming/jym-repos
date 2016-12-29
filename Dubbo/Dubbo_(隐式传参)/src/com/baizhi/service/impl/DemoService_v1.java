package com.baizhi.service.impl;

import java.util.Date;
import java.util.Map;

import com.alibaba.dubbo.rpc.RpcContext;
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
		Map<String, String> attachments = RpcContext.getContext().getAttachments();
		String attch= attachments.get("attch");
		System.out.println("附件信息："+attch);
		return "node-A";
	}

}
