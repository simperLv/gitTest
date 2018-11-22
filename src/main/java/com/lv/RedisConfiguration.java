package com.lv;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

/**
 * User: simperLv
 * DATE: 2018/11/16
 * TIME: 15:01
 *
 * @Description //TODO
 * github: https://github.com/simperLv
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1));//失效时间
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }
    @Override
    public KeyGenerator keyGenerator() {
        //  设置自动key的生成规则，配置spring boot的注解，进行方法级别的缓存,使用：进行分割，可以很多显示出层级关系
        // 这里其实就是new了一个KeyGenerator对象，只是这是lambda表达式的写法，我感觉很好用，大家感兴趣可以去了解下
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(":");
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(":" + String.valueOf(obj));
            }
            String rsToUse = String.valueOf(sb);
            System.out.println("调用Redis缓存Key : " + rsToUse);
            return rsToUse;
        };
    }

}
