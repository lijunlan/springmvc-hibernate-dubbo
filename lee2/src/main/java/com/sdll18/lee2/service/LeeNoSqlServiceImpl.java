package com.sdll18.lee2.service;

import com.alibaba.fastjson.JSONObject;
import com.sdll18.lee2.dao.cache.LeeCacheDao;
import com.sdll18.lee2.dao.nosql.LeeNoSqlDao;
import com.sdll18.lee2.model.nosql.LeeNoSql;
import com.sdll18.service.LeeNoSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-09-30
 */
@Service("leeNoSqlService")
@Transactional
public class LeeNoSqlServiceImpl implements LeeNoSqlService{

    @Autowired
    private LeeNoSqlDao leeNoSqlDao;

    @Override
    public JSONObject createLee(JSONObject json) {
        LeeNoSql lee = new LeeNoSql();
        lee.setName(json.getString("name"));
        lee.setAge(json.getInteger("age"));
        String id = leeNoSqlDao.save(lee);
        JSONObject result = new JSONObject();
        result.put("id", id);
        return result;
    }

    @Override
    public JSONObject getLee(String id) {
        LeeNoSql lee = leeNoSqlDao.get(id);
        return JSONObject.parseObject(JSONObject.toJSONString(lee));
    }
}
