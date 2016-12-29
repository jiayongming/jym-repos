package com.baizhi.service;

import java.util.Date;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public class IDemoService implements GenericService{

	public Object $invoke(String method, String[] parameterTypes, Object[] args)
			throws GenericException {
		// TODO Auto-generated method stub
		System.out.println("方法:"+method);
		System.out.println("parameterTypes:");
		for (Object type : parameterTypes) {
			System.out.println("\t"+type);
		}
		System.out.println("args:");
		for (Object arg : args) {
			System.out.println("\t"+arg);
		}
		
		System.out.println("args:"+args);
		return new Date();
	}

}
