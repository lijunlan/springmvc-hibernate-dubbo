package com.sdll18.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-09-30
 */
public interface LeeNoSqlService {

    JSONObject createLee(JSONObject json);

    JSONObject getLee(String id);

}
