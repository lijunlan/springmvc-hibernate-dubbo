package com.sdll18.lee1.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sdll18.service.LeeNoSqlService;
import com.sdll18.service.LeeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C) 2015 - 2016 MICROSCENE Inc., All Rights Reserved.
 *
 * @Author: lee@visualbusiness.com
 * @Data: 2016-09-19
 */
@Controller
@RequestMapping("/test")
public class TestController {

    //    @Reference(interfaceName = "leeUserService")
    @Autowired
    private LeeUserService leeUserService;

    @Autowired
    private LeeNoSqlService leeNoSqlService;

    @RequestMapping(value = "/test1/{id}")
    @ResponseBody
    public JSONObject test1(@PathVariable String id) {
        System.out.println(id);
        return JSONObject.parseObject("{\"hello\":\"word\"}");
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public JSONObject test2() {
        JSONObject inData = new JSONObject();
        inData.put("name", "俊澜李");
        inData.put("age", "44");
        return leeUserService.createUser(inData);
    }

    @RequestMapping(value = "/test3/{id}")
    @ResponseBody
    public JSONObject test3(@PathVariable String id) {
        return leeUserService.getUser(id);
    }

    @RequestMapping(value = "/test4")
    @ResponseBody
    public JSONObject test4() {
        JSONObject inData = new JSONObject();
        inData.put("name", "junlanli");
        inData.put("age", "33");
        return leeNoSqlService.createLee(inData);
    }

    @RequestMapping(value = "/test5/{id}")
    @ResponseBody
    public JSONObject test5(@PathVariable String id) {
        return leeNoSqlService.getLee(id);
    }
}
