package com.sdll18.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-11
 */
public interface KafkaService {

    JSONObject sendMessage(String key, JSONObject data);

}
