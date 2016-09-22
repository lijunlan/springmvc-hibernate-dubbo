package com.sdll18.lee2.Starter;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.lee2.dao.impl.LeeUserDaoImpl;
import com.sdll18.lee2.model.Lee;
import com.sdll18.service.LeeUserService;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import java.util.concurrent.CountDownLatch;

/**
 * Copyright (C) 2015 - 2016 MICROSCENE Inc., All Rights Reserved.
 *
 * @Author: lee@visualbusiness.com
 * @Data: 2016-09-19
 */
public class Starter {

    private static final Logger logger = Logger.getLogger(Starter.class);

    private String contextFile;
    private CountDownLatch shutdownLatch = new CountDownLatch(1);

    public Starter(String contextFile) {
        this.contextFile = contextFile;
    }

    public void startup() {
        try {
            Log4jConfigurer.initLogging("classpath:log4j.properties");
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                    new String[]{contextFile});
            context.start();
            LeeUserService s = (LeeUserService) context.getBean("leeUserService");
            JSONObject ll = new JSONObject();
            ll.put("name","李俊澜");
            ll.put("age","24");
            JSONObject t = s.createUser(ll);
            System.out.println("return :" + t);

            JSONObject t2 = s.getUser(t.getString("id"));
            System.out.println(t2);
            //redis 初始化
//            try {
//                QRedisConfig.loadRedisConf();
//                QRedisUtil.init();
//                logger.info("init redis: " + QRedisConfig.HOST);
//            } catch (IOException e) {
//                logger.error("Failed to load redis conf");
//                throw new RuntimeException("Failed to load conf");
//            }

            System.out.println("Provider Service is started!");
            shutdownLatch.await();
        } catch (Exception e) {
            logger.error("Failed to start", e);
            shutdown();
        }

    }

    public void shutdown() {
        shutdownLatch.countDown();
        logger.info("shutdown starter");
    }
}
