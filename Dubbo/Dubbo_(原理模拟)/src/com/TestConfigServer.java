package com;

import java.io.IOException;
import java.util.UUID;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class TestConfigServer {
	private ZkClient zkClient;

	public ZkClient getZkClient() {
		return zkClient;
	}

	public void setZkClient(ZkClient zkClient) {
		this.zkClient = zkClient;
	}

	/**
	 * 函数入口
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		TestConfigServer bootStrap = new TestConfigServer();
		bootStrap.initialize();
		System.out.println("配置服务服务启动");
		System.in.read();

	}

	/**
	 * 初始化zookeeper
	 */
	public void initialize() {
		String connectionString = "192.168.0.103:2181";
		int connectionTimeout = 50000;

		zkClient = new ZkClient(connectionString, connectionTimeout);

		if (!zkClient.exists("/root1")) {
			zkClient.createEphemeral("/root1", new Long(System.currentTimeMillis()));
		}

		new Thread(new RootNodeChangeThread()).start();
	}

	/**
	 * 
	 * @author Administrator
	 *每隔5秒执行修改一次配置
	 */
	private class RootNodeChangeThread implements Runnable {

		public void run() {

			while (true) {

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// ignore
				}

				String uuidStr = "配置："+UUID.randomUUID().toString();

				System.out.println("你可以理解为集群配置文件发生变化了"
						+ uuidStr);

				zkClient.writeData("/root1", uuidStr);

			}

		}

	}
}
