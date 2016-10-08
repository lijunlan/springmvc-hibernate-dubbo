package com.sdll18.lee2.dao.nosql;

import com.sdll18.lee2.model.nosql.LeeNoSql;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-09-30
 */
public interface LeeNoSqlDao {

    String save(LeeNoSql enity);

    LeeNoSql get(String id);

}
