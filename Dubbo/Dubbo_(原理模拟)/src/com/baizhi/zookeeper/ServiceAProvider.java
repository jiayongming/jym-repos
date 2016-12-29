package com.baizhi.zookeeper;

import java.net.InetAddress;

import org.I0Itec.zkclient.ZkClient;
public class ServiceAProvider {
	     private String serviceName = "service-A";
	    //向zookeeper注册服务
	    public void init() throws Exception{
	        String serverList = "192.168.0.250:2181";
	        String PATH ="/configcenter";//根节点路径
	        ZkClient zkClient = new ZkClient(serverList);
	        boolean rootExists = zkClient.exists(PATH);
	        if(!rootExists){
	            zkClient.createPersistent(PATH);
	        }
	      //判断是否存在，不存在则创建服务节点
	        boolean serviceExists = zkClient.exists(PATH + "/" + serviceName);
	        if(!serviceExists){
	            zkClient.createPersistent(PATH + "/" + serviceName);
	        }
	        
	        //注册当前服务
	        String ip = "192.168.58.130:20880";
	        
	        //創建當前服務器節點
	        if(!zkClient.exists(PATH + "/" + serviceName + "/" + ip))
	        zkClient.createEphemeral(PATH + "/" + serviceName + "/" + ip);
	        System.out.println("提供的服务节点名称为："+PATH + "/" + serviceName + "/" + ip);
	    }
	    public void deleteSelf(){
	    	    String serverList = "192.168.0.250:2181";
		        String PATH ="/configcenter";//根节点路径
		        ZkClient zkClient = new ZkClient(serverList);
		        boolean rootExists = zkClient.exists(PATH);
		        if(!rootExists){
		            zkClient.createPersistent(PATH);
		        }
		       //判断是否存在，不存在则创建服务节点
		        boolean serviceExists = zkClient.exists(PATH + "/" + serviceName);
		        if(!serviceExists){
		            zkClient.createPersistent(PATH + "/" + serviceName);
		        }
		        String ip = "192.168.58.130:20880";
		        //創建當前服務器節點
		        if(zkClient.exists(PATH + "/" + serviceName + "/" + ip)){
	   	        	zkClient.delete(PATH + "/" + serviceName + "/" + ip);
	   	        }
	    }
	    //提供服务
	    public void provide(){
	    	
	    	 
	    }
	    public static void main(String[]args) throws Exception {
	        ServiceAProvider service = new ServiceAProvider();
	        service.init();
	        System.in.read();
	        service.deleteSelf();
	    }

}