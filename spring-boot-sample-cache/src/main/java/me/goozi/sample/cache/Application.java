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

package me.goozi.sample.cache;

import me.goozi.sample.cache.config.GuavaCacheConfig;
import me.goozi.sample.cache.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goozi
 * @create 2016-05-13 16:48
 * @since 1.0.0
 */
@SpringBootApplication
@RestController
@RequestMapping("/")
public class Application implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(Application.class);


    @Autowired
    CacheService cacheService;

    /**
     * clear cache one and cache two.
     *
     * @return
     */
    @RequestMapping(value = "/clearCache", method = RequestMethod.GET)
    @CacheEvict(value = {GuavaCacheConfig.CACHE_ONE, GuavaCacheConfig.CACHE_TWO}, allEntries = true)
    public String clearCache() {
        logger.info("starting clear cache...");
        return "Cache Cleared...";
    }

    @RequestMapping(value = "/cache1/{tel}", method = RequestMethod.GET)
    public String getGuavaCache1(@PathVariable String tel) {
        return cacheService.getGuavaCacheOne(tel);
    }

    @RequestMapping(value = "/cache2/{cardnum}", method = RequestMethod.GET)
    public String getGuavaCache2(@PathVariable String cardnum) {
        return cacheService.getGuavaCacheTwo(cardnum);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("application starting...");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
