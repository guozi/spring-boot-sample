package me.goozi.sample.event;/*
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

import me.goozi.sample.event.event.MyApplicationReadyEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author goozi
 * @create 2016-05-14 13:15
 * @since 1.0.0
 */
@SpringBootApplication
public class EventApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EventApplication.class);
        //application.addListeners(new MyApplicationStartedEventListener());
        //application.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        //application.addListeners(new MyApplicationPreparedEventListener());
        //application.addListeners(new MyApplicationFailedEventListener());
        application.addListeners(new MyApplicationReadyEventListener());
        application.run(args);
    }
}
