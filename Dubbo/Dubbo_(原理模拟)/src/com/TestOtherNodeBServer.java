package com;

import java.io.IOException;
import java.util.UUID;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class TestOtherNodeBServer {
	 private ZkClient zkClient;
	    
	   
	    /**
	     * 初始化zookeeper
	     */
	    public void initialize() {
	        String connectionString="192.168.0.103:2181";
	        int connectionTimeout=500000;
	        zkClient=new ZkClient(connectionString, connectionTimeout);
	        new Thread(new Runnable() {
	            public void run() {
	                zkClient.subscribeDataChanges("/root1", new IZkDataListener() {
	                    public void handleDataDeleted(String dataPath) throws Exception {
	                        System.out.println("配置信息被删除了："+dataPath);    
	                    }
	                    public void handleDataChange(String dataPath, Object data) throws Exception {
	                        System.out.println("配置信息被修改了:"+dataPath+",修改的数据是："+String.valueOf(data));
	                    }
	                });
	            }
	        }).start();
	    }
	    
	    /**
	     * 函数入口
	     * @param args
	     * @throws IOException 
	     */
	    public static void main( String[] args ) throws IOException {
	    	TestOtherNodeBServer bootStrap=new TestOtherNodeBServer();
	        bootStrap.initialize();
	        System.in.read();
	    }
}
