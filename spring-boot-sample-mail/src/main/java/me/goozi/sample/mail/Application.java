package me.goozi.sample.mail;/*
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goozi
 * @create 2016-05-28 14:15
 * @since 1.0.0
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@RestController
class MailSubmissionController {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailSubmissionController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RequestMapping("/mail")
    @ResponseStatus(HttpStatus.CREATED)
    SimpleMailMessage send() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("472242925@qq.com");
        //mailMessage.setReplyTo("xinyun_08wh@126.com");
        mailMessage.setFrom("xinyun_08wh@126.com");
        mailMessage.setSubject("Hi Goozi");
        mailMessage.setText("Hi Goozi Goozi Goozi Goozi Goozi Goozi Goozi Goozi");
        try {
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mailMessage;
    }
}