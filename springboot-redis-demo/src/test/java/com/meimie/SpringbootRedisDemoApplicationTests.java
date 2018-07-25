package com.meimie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisDemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void pushKey() {
		redisTemplate.opsForValue().set("key", "dream on sakura rain");
	}

	@Test
	public void getValue() {
		System.out.println(redisTemplate.opsForValue().get("key"));
	}
}
