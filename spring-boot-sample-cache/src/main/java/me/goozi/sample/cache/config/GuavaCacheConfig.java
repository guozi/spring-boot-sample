/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.goozi.sample.cache.config;

import com.google.common.cache.CacheBuilder;
import org.apache.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Guava的cache配置文件
 *
 * @author goozi
 * @create 2016-05-13 17:06
 * @since 1.0.0
 */
@Configuration
@EnableCaching
public class GuavaCacheConfig implements CachingConfigurer {

    private final Logger logger = Logger.getLogger(this.getClass());

    public static final String CACHE_ONE = "cacheOne";

    public static final String CACHE_TWO = "cacheTwo";


    @Bean
    @Override
    public CacheManager cacheManager() {
        logger.info("initializing simple guava cache manage.");

        SimpleCacheManager cacheManager = new SimpleCacheManager();
        //cache expire after 60 min
        GuavaCache cache1 = new GuavaCache(CACHE_ONE, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .build());

        //cache expire after 60 sec
        GuavaCache cache2 = new GuavaCache(CACHE_TWO, CacheBuilder.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build());

        cacheManager.setCaches(Arrays.asList(cache1, cache2));

        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}
