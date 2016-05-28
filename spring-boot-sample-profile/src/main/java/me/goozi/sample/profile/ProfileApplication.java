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

package me.goozi.sample.profile;

import me.goozi.sample.profile.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goozi
 * @create 2016-05-27 22:44
 * @since 1.0.0
 */
@SpringBootApplication
public class ProfileApplication {

    @Autowired
    HelloWorldService service;

    @Autowired
    Environment environment;

    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println(environment.getActiveProfiles()[0]);
                System.out.println(service.sayHelloWorld());
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ProfileApplication.class);
        //set profile
        //application.setAdditionalProfiles("chinese");

        System.setProperty("spring.profiles.active", "english");

        //like commandline
        //application.run(new String[]{"--spring.profiles.active=chinese"});

        application.run(args);
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
        mailMessage.setTo("someone@goozi.com");
        mailMessage.setFrom("otherone@goozi.com");
        mailMessage.setSubject("Send A Email With Spring Boot");
        mailMessage.setText("How to use spring boot send a email!!!");
        javaMailSender.send(mailMessage);
        return mailMessage;
    }
}
