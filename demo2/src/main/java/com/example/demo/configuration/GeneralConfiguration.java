package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {


    @Bean
    MyBean myBean(){
        MyBean myBean = new MyBean();
        myBean.setMyDouble(452.23);
        myBean.setMyLong(351);
        myBean.setMyString("Bean");
        return myBean;
    }
















}
