package com.commons.monitor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;
/**
 * @author jiayongming
 * 该类实现了org.aopalliance.intercept.MethodInterceptor接口
 * 记录方法的运行时间,单位为毫秒
 * 日志标志为 invokeTimeMonitor 
 * Logger.getLogger("invokeTimeMonitor");
 */
public class MethodInvokeTime implements MethodInterceptor {

	private final static Logger LOG = Logger.getLogger("invokeTimeMonitor");

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 用StopWatch 计时
		StopWatch clock = new StopWatch();

		// 计时开始
		clock.start(); 
		
		Object result = null;
		// 监控的类名
		String className = invocation.getMethod().getDeclaringClass().getName();
		// 监控的方法名
		String methodName = className + "." + invocation.getMethod().getName() ;
		StringBuilder sb = new StringBuilder();
		sb.append( "method[" ) ;
		sb.append( methodName ) ;
		sb.append( "(" ) ;
		try {
			// 这个是我们监控的bean的执行并返回结果
			result = invocation.proceed();
		} catch (Throwable e) {
			// 监控的参数
			Object[] objs = invocation.getArguments();
			LOG.error( sb.toString() + this.getString(objs) + ")]：InvokeError.", e );
			throw e;
		}
		
		// 计时结束
		clock.stop();
		
		if (LOG.isInfoEnabled()) {
			LOG.info( sb.toString()+")]：InvokeTime(millisecond): " + clock.getTime() );
		}
		return result;
	}

	/**
	 * 获取执行方法的参数
	 */
	@SuppressWarnings("unchecked")
	public String getString(Object[] objs) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = objs.length; i < len; i++) {
			if (objs[i] instanceof String) {
				sb.append("String类型：" + objs[i].toString());
			} else if (objs[i] instanceof Map) {
				Map<String, Object> hashMap = (Map<String, Object>) objs[i];
				Map<String, Object> map = hashMap;
				Set<String> set = (Set<String>) map.keySet();
				sb.append("Map类型：");
				for (String str : set) {
					sb.append(str + "=" + map.get(str));
				}
			} else if (objs[i] instanceof Integer) {
				sb.append("整数类型：");
				sb.append(objs[i].toString());
			} else {
				sb.append(objs[i].toString());
			}
		}
		return sb.toString();
	}

}
