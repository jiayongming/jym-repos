import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.junit.Test;


public class TestNodeWacher {
	ZkClient zkClient=new ZkClient("192.168.1.128:2181");
	/**
	 * 监听节点的数据变化
	 * @throws IOException
	 */
	@Test
	public void testNodeDataWatcher() throws IOException{
		zkClient.subscribeDataChanges("/root", new IZkDataListener() {
			
			public void handleDataDeleted(String path) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(path);
			}
			
			public void handleDataChange(String path, Object pathData) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(path);
				System.out.println(pathData);
			}
		});
		System.in.read();
	}
	/**
	 * 监视集群孩子的变化
	 */
	@Test
	public void testNodeChildWatcher() throws IOException{
		zkClient.subscribeChildChanges("/root",new IZkChildListener() {
			
			public void handleChildChange(String path, List<String> childs)
					throws Exception {
				// TODO Auto-generated method stub
				System.out.println(path);
				System.out.println(childs);
			}
		});
		System.in.read();
	}
	@Test
	public void testCreateNode(){
		zkClient.createPersistent("/root");
	}
}
