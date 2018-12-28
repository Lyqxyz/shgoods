package com.shgoods.goods.config;


import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.shgoods.goods.pojo.ShUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;

@Configuration
public class RedisConfig {

    @Autowired
    FastJsonConfig fastJsonConfig;

    @Bean("ShUserRedisTemplate")
    public RedisTemplate<String, ShUser> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {

        RedisTemplate<String, ShUser> template = new RedisTemplate<>();

        template.setDefaultSerializer(new FastJsonRedisSerializer<>(ShUser.class));

        template.setKeySerializer(new StringRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);

        return template;

    }

    @Bean("SHUSERRedisCacheManager")
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory,
                                          ResourceLoader resourceLoader) {

        FastJsonRedisSerializer<Object> objectFastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        objectFastJsonRedisSerializer.setFastJsonConfig(fastJsonConfig);
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(3600))
                .disableCachingNullValues()
                .computePrefixWith(cacheName -> "yourAppName".concat(":").concat(cacheName).concat(":"))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(objectFastJsonRedisSerializer));
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .build();
    }



}
