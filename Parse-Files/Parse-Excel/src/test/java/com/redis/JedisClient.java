package com.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.redis.model.Student;

public class JedisClient {

	private static final Logger LOG = Logger.getLogger(JedisClient.class.getName());
	private static Jedis jedis=null;
    /**
     * 初始化Jedis对象
     */
    @Before
    public void before() throws Exception {
    	// Connecting to Redis server on 192.168.10.130
        jedis=new Jedis("192.168.10.130", 6379);
		LOG.info("Connection to server sucessfully");
    }
	
	@Test
	public void testSet() throws Exception {
		/**
		 * 对对象进行序列化存储
		 */
		byte[] student1 = serialize(new Student("name1", 1));
		byte[] student2 = serialize(new Student("name2", 2));

		jedis.lpush("student1", String.valueOf(student1), String.valueOf(student2));

		List<String> lrange = jedis.lrange("student1", 0, -1);
		for (String str : lrange) {
			LOG.info(str);
		}

		// check whether server is running or not
		LOG.info("Server is running: " + jedis.ping());

	}

	@Test
	public void testGet() throws Exception {
		/**
		 * 对对象进行反序列化读取
		 */
		List<byte[]> lrange = jedis.lrange("student1".getBytes(), 0, -1);
		for (byte[] bs : lrange) {
			Student student = (Student) deserialize(bs);
			System.out.println(student);
		}
		
		
		
		
		
		
		
		
		// check whether server is running or not
		LOG.info("Server is running: " + jedis.ping());
	}

	/**
	 * 序列化
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {

		} finally{
			
		}
		return null;
	}
	/**
	 * 反序列化
	 */
	public static Object deserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		} finally{
			
		}
		return null;
	}
}
