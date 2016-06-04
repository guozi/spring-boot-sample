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

package me.goozi.sample.aysnc;

import me.goozi.sample.async.AsyncApplication;
import me.goozi.sample.async.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * @author goozi
 * @create 2016-06-04 20:54
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AsyncApplication.class)
public class ApplicationTests {
    long start = System.currentTimeMillis();

    @Autowired
    private Task task;

    @Test
    public void test() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        Future<String> future = task.doTaskThree();
        task.asyncMethodWithConfiguredExecutor();
        while (true) {
            if (future.isDone()) {
                System.out.println(future.get());
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println("任务全部完成，总耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
