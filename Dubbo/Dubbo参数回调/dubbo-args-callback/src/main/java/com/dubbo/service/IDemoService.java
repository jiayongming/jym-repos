package com.dubbo.service;

import com.dubbo.entity.Computer;

public interface IDemoService {

	public Computer methodInvoke(String value,CallbackListener callbackListener);
}
