package com.sdll18.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Copyright (C) 2015 - 2016 MICROSCENE Inc., All Rights Reserved.
 *
 * @Author: lee@visualbusiness.com
 * @Data: 2016-09-22
 */
public interface LeeUserService {

        JSONObject createUser(JSONObject json);

        JSONObject getUser(String id);


}
