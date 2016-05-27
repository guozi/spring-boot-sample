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

package me.goozi.sample.event.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Spring Boot 启动监听类
 *
 * @author goozi
 * @create 2016-05-14 13:28
 * @since 1.0.0
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        logger.info("Starting myApplicationStartedEventListener...");
        SpringApplication application = event.getSpringApplication();
        application.setBannerMode(Banner.Mode.OFF);
    }
}
