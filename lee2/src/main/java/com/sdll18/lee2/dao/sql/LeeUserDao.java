package com.sdll18.lee2.dao.sql;

import com.sdll18.lee2.model.sql.Lee;

/**
 * Copyright (C) 2015 - 2016 MICROSCENE Inc., All Rights Reserved.
 *
 * @Author: lee@visualbusiness.com
 * @Data: 2016-09-22
 */
public interface LeeUserDao {

    String save(Lee enity);

    Lee get(String id);
}
