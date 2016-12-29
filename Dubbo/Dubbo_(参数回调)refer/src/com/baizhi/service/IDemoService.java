package com.baizhi.service;

import com.baizhi.entity.Computer;
import com.baizhi.entity.User;

public interface IDemoService {
	/**
	 * 
	 * @param value
	 * @param callbackListener
	 * @return
	 */
	public Computer methodInvoke(String value,
			      CallbackListener callbackListener);
}
