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

package me.goozi.sample.profile.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author goozi
 * @create 2016-05-28 0:56
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(MailProperties.class)
public class MailConfiguration {

    //@Autowired
    //private MailProperties mailProperties;

    @Bean
    public JavaMailSender javaMailSender(MailProperties mailProperties) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", mailProperties.getSmtp().isAuth());
        properties.put("mail.smtp.starttls.enable", mailProperties.getSmtp().isStarttlsEnable());
        properties.put("mail.debug", true);
        mailSender.setJavaMailProperties(properties);
        mailSender.setHost(mailProperties.getHost());
        mailSender.setPort(mailProperties.getPort());
        mailSender.setUsername(mailProperties.getUsername());
        mailSender.setPassword(mailProperties.getPassword());
        return mailSender;
    }

}
