package com.baizhi.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class ZkNodeOperation {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 3000,
				new Watcher() {
					// 监控所有被触发的事件
					public void process(WatchedEvent event) {
						System.out.println("已经触发了" + event.getType() + "事件！");
					}
				});
		// 创建一个目录节点
		zk.create("/baizhi-dir", "baizhi-data".getBytes(),
				Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		// 创建一个子目录节点
		zk.create("/baizhi-dir/childone", "childone".getBytes(),
				Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(new String(zk
				.getData("/baizhi-dir", false, null)));
		// 取出子目录节点列表
		System.out.println(zk.getChildren("/baizhi-dir", true));
		// 修改子目录节点数据
		zk.setData("/baizhi-dir/childone", "modifyDataOne".getBytes(), -1);
		System.out.println("目录节点状态：[" + zk.exists("/baizhi-dir", true)
				+ "]");
		// 创建另外一个子目录节点
		zk.create("/baizhi-dir/childtwo", "childtwo".getBytes(),
				Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(new String(zk.getData("/baizhi-dir/childtwo",
				true, null)));
		// 删除子目录节点
		zk.delete("/baizhi-dir/childtwo", -1);
		zk.delete("/baizhi-dir/childone", -1);
		// 删除父目录节点
		zk.delete("/baizhi-dir", -1);
		// 关闭zk连接
		zk.close();
	}

}