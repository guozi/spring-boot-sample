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
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * Spring Boot 配置环境事件监听
 *
 * @author goozi
 * @create 2016-05-14 13:37
 * @since 1.0.0
 */
public class MyApplicationEnvironmentPreparedEventListener
        implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        if (propertySources == null) return;
        Iterator<PropertySource<?>> iterator = propertySources.iterator();
        while (iterator.hasNext()) {
            PropertySource<?> propertySource = iterator.next();
            logger.info("ps.getName:{};ps.getSource:{};ps.getClass:{}",
                    propertySource.getName(),
                    propertySource.getSource(),
                    propertySource.getClass());

        }
    }
}
