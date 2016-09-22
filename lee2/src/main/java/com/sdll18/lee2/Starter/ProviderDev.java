package com.sdll18.lee2.Starter;

import org.apache.log4j.Logger;

/**
 * Copyright (C) 2015 - 2016 MICROSCENE Inc., All Rights Reserved.
 *
 * @Author: lee@visualbusiness.com
 * @Data: 2016-09-19
 */
public class ProviderDev {

    private final static Logger logger = Logger.getLogger(ProviderDev.class);


    public static void main(String[] args){
        System.out.println("Provider Service is starting......");
        final Starter starter = new Starter("dubbo_provider.xml");
        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook") {
            public void run() {
                starter.shutdown();
            }
        });
        starter.startup();
    }
}
