package online.cangjie;

import java.util.UUID;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {
	@Test
	public void testConnection(){
	}
	
	@Test
	public void test(){
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
	}
}
