package com.baizhi.service;

import java.util.Date;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.baizhi.entity.User;

public interface IDemoService {

	public Object sum(int x,int y);
	public Object saveUser(User user);
}
