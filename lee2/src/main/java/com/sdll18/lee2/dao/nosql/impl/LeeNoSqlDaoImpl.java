package com.sdll18.lee2.dao.nosql.impl;

import com.sdll18.lee2.dao.nosql.LeeNoSqlDao;
import com.sdll18.lee2.model.nosql.LeeNoSql;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-09-30
 */
@Repository("leeNoSqlDao")
public class LeeNoSqlDaoImpl extends AbstractBaseNoSqlDaoImpl implements LeeNoSqlDao{


    @Override
    public String save(LeeNoSql enity) {
        getMongoTemplate().save(enity);
        return enity.getUid();
    }

    @Override
    public LeeNoSql get(String id) {
        return getMongoTemplate().findById(id,LeeNoSql.class);
    }
}
