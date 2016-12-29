package com.baizhi.service.impl;

import org.omg.PortableInterceptor.INACTIVE;

import com.baizhi.service.INotify;

public class Notify implements INotify {

	public void onreturn(Object res, Object... args) {
		// TODO Auto-generated method stub
		System.out.println("返回值："+res);
		for (Object object : args) {
			System.out.println("参数："+object);
		}
	}

	public void onthrow(Throwable ex, Object... args) {
		// TODO Auto-generated method stub
		System.out.println("异常："+ex.getMessage());
		for (Object object : args) {
			System.out.println("异常参数："+object);
		}
	}


}
