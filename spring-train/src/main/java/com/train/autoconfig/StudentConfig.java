package com.train.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {


    @Bean("student")
    public Student Student(){
        return new Student("李四","23232");
    }
}
