package com.isg.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.isg.poc.mode.UserModel;

@SpringBootApplication
public class RedisPracApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, UserModel> redisTemplate() {
		final RedisTemplate<String, UserModel> template = new RedisTemplate<String, UserModel>();
		template.setConnectionFactory(jedisConnectionFactory());
//		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;

	}
	
	public static void main(String[] args) {
		SpringApplication.run(RedisPracApplication.class, args);
	}
}
