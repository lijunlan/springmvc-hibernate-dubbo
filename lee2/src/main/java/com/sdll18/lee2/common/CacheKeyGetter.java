package com.sdll18.lee2.common;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-09
 */
public class CacheKeyGetter {

    public static String getKey(Class cl, String id) {
        return cl.getName() + "_" + id;
    }
}
