package com;

import java.util.ArrayList; 
import java.util.List; 
 
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.WatchedEvent; 
import org.apache.zookeeper.Watcher; 
import org.apache.zookeeper.ZooDefs.Ids; 
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.data.ACL; 
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider; 
/**
 * zk的ACL控制
 * @author Administrator
 *
 */
public class TestZookeeperACL{ 
    final static String PATH = "/root"; 
    final static String PATH_DEL = "/root/child"; 
    final static String authentication_type = "digest"; 
    final static String correctAuthentication = "jiangzz:123"; 
    final static String badAuthentication = "zookeeper:456"; 
    final static String superAuthentication = "super:jiangzz2013"; 
    static ZkClient zkClient = null; 
    public static void main( String[] args ) throws Exception { 
    	System.out.println(DigestAuthenticationProvider.generateDigest("super:jiangzz2013"));
        List<ACL> acls = Ids.CREATOR_ALL_ACL;
       
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( "digest", correctAuthentication.getBytes() ); 
       
        
            zkClient.createPersistent( PATH, "init content",acls); 
            System.out.println( "使用授权key：" + correctAuthentication + "创建节点：" + PATH + ", 初始内容是: init content" ); 
        
        
            zkClient.createPersistent( PATH_DEL, "待删节点",acls); 
            System.out.println( "使用授权key：" + correctAuthentication + "创建节点：" + PATH_DEL + ", 初始内容是: init content" ); 
        

//        // 获取数据 
//        getDataByNoAuthentication(); 
//      getDataByBadAuthentication(); 
//      getDataByCorrectAuthentication(); 
//      getDataBySuperAuthentication(); 
// 
//      // 更新数据 
//        updateDataByNoAuthentication(); 
//      updateDataByBadAuthentication(); 
     //   updateDataByCorrectAuthentication(); 
// 
//      // 获取数据 
//      getDataByNoAuthentication(); 
//      getDataByBadAuthentication(); 
//      getDataByCorrectAuthentication(); 
// 
//      //删除数据 
     //  deleteNodeByBadAuthentication(); 
    //  deleteNodeByNoAuthentication(); 
     //  deleteNodeByCorrectAuthentication(); 
 
     //   deleteNodeByCorrectAuthentication();
    //    deleteParent(); 
        zkClient.close(); 
    } 
 
    /** 获取数据：采用错误的密码 */ 
    static void getDataByBadAuthentication() { 
        String prefix = "[使用错误的授权信息]"; 
        try { 
            System.out.println( prefix + "获取数据：" + PATH ); 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, badAuthentication.getBytes() ); 
            System.out.println( prefix + "成功获取数据：" + zkClient.readData( PATH ) ); 
        } catch ( Exception e ) { 
            System.err.println( prefix + "获取数据失败，原因：" + e.getMessage() ); 
        } 
    } 
 
    /** 获取数据：不采用密码 */ 
    static void getDataByNoAuthentication() { 
        String prefix = "[不使用任何授权信息]"; 
        try { 
            System.out.println( prefix + "获取数据：" + PATH ); 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            System.out.println( prefix + "成功获取数据：" + zkClient.readData( PATH ) ); 
        } catch ( Exception e ) { 
            System.err.println( prefix + "获取数据失败，原因：" + e.getMessage() ); 
        } 
    } 
 
    /** 采用正确的密码 */ 
    static void getDataByCorrectAuthentication() { 
        String prefix = "[使用正确的授权信息]"; 
        try { 
            System.out.println( prefix + "获取数据：" + PATH ); 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, correctAuthentication.getBytes() ); 
            System.out.println( prefix + "成功获取数据：" + zkClient.readData( PATH ) ); 
        } catch ( Exception e ) { 
            System.out.println( prefix + "获取数据失败，原因：" + e.getMessage() ); 
        } 
    } 
 
    /** 采用超级用户的密码 */ 
    static void getDataBySuperAuthentication() { 
        String prefix = "[使用超级用户的授权信息]"; 
        try { 
            System.out.println( prefix + "获取数据：" + PATH ); 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, superAuthentication.getBytes() ); 
            System.out.println( prefix + "成功获取数据：" + zkClient.readData( PATH ) ); 
        } catch ( Exception e ) { 
            System.out.println( prefix + "获取数据失败，原因：" + e.getMessage() ); 
        } 
    } 
 
    /** 
     * 更新数据：不采用密码 
     */ 
    static void updateDataByNoAuthentication() { 
 
        String prefix = "[不使用任何授权信息]"; 
 
        System.out.println( prefix + "更新数据： " + PATH ); 
        try { 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            if( zkClient.exists( PATH ) ){ 
                zkClient.writeData( PATH, prefix ); 
                System.out.println( prefix + "更新成功" ); 
            } 
        } catch ( Exception e ) { 
            System.err.println( prefix + "更新失败，原因是：" + e.getMessage() ); 
        } 
    } 
 
    /** 
     * 更新数据：采用错误的密码 
     */ 
    static void updateDataByBadAuthentication() { 
 
        String prefix = "[使用错误的授权信息]"; 
 
        System.out.println( prefix + "更新数据：" + PATH ); 
        try { 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, badAuthentication.getBytes() ); 
            if( zkClient.exists( PATH ) ){ 
                zkClient.writeData( PATH, prefix ); 
                System.out.println( prefix + "更新成功" ); 
            } 
        } catch ( Exception e ) { 
            System.err.println( prefix + "更新失败，原因是：" + e.getMessage() ); 
        } 
    } 
 
    /** 
     * 更新数据：采用正确的密码 
     */ 
    static void updateDataByCorrectAuthentication() { 
 
        String prefix = "[使用正确的授权信息]"; 
 
        System.out.println( prefix + "更新数据：" + PATH ); 
        try { 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, correctAuthentication.getBytes() ); 
            if( zkClient.exists( PATH ) ){ 
                zkClient.writeData( PATH, prefix ); 
                System.out.println( prefix + "更新成功" ); 
            } 
        } catch ( Exception e ) { 
            System.err.println( prefix + "更新失败，原因是：" + e.getMessage() ); 
        } 
    } 
 
 
    /** 
     * 不使用密码 删除节点 
     */ 
    static void deleteNodeByNoAuthentication() throws Exception { 
 
        String prefix = "[不使用任何授权信息]"; 
 
        try { 
            System.out.println( prefix + "删除节点：" + PATH_DEL ); 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            if( zkClient.exists( PATH_DEL ) ){ 
                zkClient.delete( PATH_DEL ); 
                System.out.println( prefix + "删除成功" ); 
            } 
        } catch ( Exception e ) { 
            System.err.println( prefix + "删除失败，原因是：" + e.getMessage() ); 
        } 
    } 
 
 
 
    /** 
     * 采用错误的密码删除节点 
     */ 
    static void deleteNodeByBadAuthentication() throws Exception { 
 
        String prefix = "[使用错误的授权信息]"; 
 
        try { 
            System.out.println( prefix + "删除节点：" + PATH_DEL ); 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, badAuthentication.getBytes() ); 
            if( zkClient.exists( PATH_DEL ) ){ 
                zkClient.delete( PATH_DEL ); 
                System.out.println( prefix + "删除成功" ); 
            } 
        } catch ( Exception e ) { 
            System.err.println( prefix + "删除失败，原因是：" + e.getMessage() ); 
        } 
    } 
 
 
 
    /** 
     * 使用正确的密码删除节点 
     */ 
    static void deleteNodeByCorrectAuthentication() throws Exception { 
 
        String prefix = "[使用正确的授权信息]"; 
 
        try { 
            System.out.println( prefix + "删除节点：" + PATH_DEL ); 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, correctAuthentication.getBytes() ); 
            if( zkClient.exists( PATH_DEL ) ){ 
                zkClient.delete( PATH_DEL ); 
                System.out.println( prefix + "删除成功" ); 
            } 
        } catch ( Exception e ) { 
            System.out.println( prefix + "删除失败，原因是：" + e.getMessage() ); 
        } 
    } 
 
 
 
    /** 
     * 使用正确的密码删除节点 
     */ 
    static void deleteParent() throws Exception { 
        try { 
            zkClient = new ZkClient( "192.168.0.103:2181", 50000); 
            zkClient.addAuthInfo( authentication_type, correctAuthentication.getBytes() ); 
            if( zkClient.exists( PATH ) ){ 
                zkClient.delete( PATH ); 
            } 
        } catch ( Exception e ) { 
            e.printStackTrace(); 
        } 
    } 
 
    public void process( WatchedEvent event ) { 
        // TODO Auto-generated method stub 
    	System.out.println("数据变化了");
    } 
}