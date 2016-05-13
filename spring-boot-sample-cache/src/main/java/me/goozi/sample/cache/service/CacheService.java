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

package me.goozi.sample.cache.service;

import me.goozi.sample.cache.config.GuavaCacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author goozi
 * @create 2016-05-13 17:28
 * @since 1.0.0
 */
@Component
public class CacheService {

    private static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
    }

    @Cacheable(GuavaCacheConfig.CACHE_ONE)
    public String getGuavaCacheOne(String tel) {
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + tel;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @Cacheable(GuavaCacheConfig.CACHE_TWO)
    public String getGuavaCacheTwo(String cardnum) {
        String apikey = "e008b939129383310e4b177b53b29177";
        String url = "http://apis.baidu.com/datatiny/cardinfo/cardinfo?cardnum=" + cardnum;

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apikey);
        HttpEntity<String> entity = new HttpEntity<>(url, headers);

        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.GET,
                entity,
                String.class);

        return response.getBody();
    }

}
