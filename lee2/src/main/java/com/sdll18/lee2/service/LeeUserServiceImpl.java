package com.sdll18.lee2.service;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.lee2.dao.LeeUserDao;
import com.sdll18.lee2.model.Lee;
import com.sdll18.service.LeeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (C) 2015 - 2016 MICROSCENE Inc., All Rights Reserved.
 *
 * @Author: lee@visualbusiness.com
 * @Data: 2016-09-22
 */
@Service("leeUserService")
@Transactional
public class LeeUserServiceImpl implements LeeUserService{

    @Autowired
    private LeeUserDao leeUserDao;

    @Override
    public JSONObject createUser(JSONObject json) {
        Lee lee = new Lee();
        lee.setName(json.getString("name"));
        lee.setAge(json.getInteger("age"));
        String id = leeUserDao.save(lee);
        JSONObject result = new JSONObject();
        result.put("id",id);
        return result;
    }

    @Override
    public JSONObject getUser(String id) {
        Lee lee = leeUserDao.get(id);
        return JSONObject.parseObject(JSONObject.toJSONString(lee));
    }
}
