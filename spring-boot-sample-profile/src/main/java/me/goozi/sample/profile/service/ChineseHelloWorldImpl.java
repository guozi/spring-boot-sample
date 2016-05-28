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

package me.goozi.sample.profile.service;

import me.goozi.sample.profile.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author goozi
 * @create 2016-05-27 23:01
 * @since 1.0.0
 */
@Service
@Profile({"chinese", "default"})
public class ChineseHelloWorldImpl implements HelloWorldService {

    @Autowired
    UserConfig userConfig;

    @Override
    public String sayHelloWorld() {
        System.out.println(userConfig.getRemark());
        System.out.println(userConfig.getAddress());
        return userConfig.getName() + " 你好！";
    }
}
