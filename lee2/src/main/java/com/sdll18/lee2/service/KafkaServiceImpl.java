package com.sdll18.lee2.service;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-11
 */
@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    @Qualifier("inputToKafka")
    private MessageChannel messageChannel;


    @Override
    public JSONObject sendMessage(String key, JSONObject data) {
        Message<String> message = MessageBuilder.withPayload(data.toString()).setHeader(KafkaHeaders.MESSAGE_KEY, key).build();
        boolean result = messageChannel.send(message,3000);
//        messageHandler.handleMessage();
//        Partitioner p =
//        kafkaTemplate
        JSONObject r = new JSONObject();
        r.put("result", result);
        return r;
    }
}
