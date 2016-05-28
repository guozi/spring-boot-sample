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

package me.goozi.sample.scheduled.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author goozi
 * @create 2016-05-13 22:49
 * @since 1.0.0
 */
public class ScheduledService {
    private final Logger logger = LoggerFactory.getLogger(ScheduledService.class);

    //以一个固定延迟时间5秒钟调用一次执行，这个周期是以上一个调用任务的完成时间为基准，在上一个任务完成之后，5s后再次执行
    //@Scheduled(fixedDelay = 15000, initialDelay = 5000)
    public void fixedDelayJobWithInitialDelay() throws InterruptedException {
        logger.info("> fixedDelayJobWithInitialDelay");

        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        logger.info("Processing time was {} seconds.", pause / 1000);
        logger.info("< fixedDelayJobWithInitialDelay");
    }


    //以一个固定速率5s来调用一次执行，这个周期是以上一个任务开始时间为基准，从上一任务开始执行后5s再次调用
    @Scheduled(fixedRate = 15000, initialDelay = 5000)
    public void fixedRateJobWithInitialDelay() throws InterruptedException {
        logger.info("> fixedRateJobWithInitialDelay");

        long pause = 5000;
        long start = System.currentTimeMillis();
        do {
            if (start + pause < System.currentTimeMillis()) {
                break;
            }
        } while (true);
        logger.info("Processing time was {} seconds.", pause / 1000);
        logger.info("< fixedRateJobWithInitialDelay");
    }

    //提供了一种通用的定时任务表达式，这里表示每隔5秒执行一次
    //@Scheduled(cron = "*/5 * * * * *")
    public void cronJob() throws InterruptedException {
        logger.info("> croJob");
        logger.info("Doing cronJob...");
        logger.info("< croJob");
    }
}
