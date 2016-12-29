package com.baizhi.service;

public interface INotify {
	public void onreturn(Object res,Object... args);
	public void onthrow(Throwable ex,Object... args);
}
