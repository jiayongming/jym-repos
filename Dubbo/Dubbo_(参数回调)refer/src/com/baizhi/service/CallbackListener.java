package com.baizhi.service;

import java.io.Serializable;

import com.baizhi.entity.User;

public interface CallbackListener extends Serializable{
	public User callBack(User v);
}
