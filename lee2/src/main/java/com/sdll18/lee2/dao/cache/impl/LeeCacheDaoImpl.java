package com.sdll18.lee2.dao.cache.impl;

import com.sdll18.lee2.common.CacheKeyGetter;
import com.sdll18.lee2.dao.cache.LeeCacheDao;
import com.sdll18.lee2.model.sql.Lee;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-09
 */
@Repository("leeCacheDao")
public class LeeCacheDaoImpl extends AbstractBaseCacheDaoImpl<Lee> implements LeeCacheDao {

    @Override
    public Lee getCacheLee(final String id) {
        return (Lee) getRedisTemplate().opsForValue().get(CacheKeyGetter.getKey(Lee.class, id));
//        BoundValueOperations valueOperations = getRedisTemplate().boundValueOps(CacheKeyGetter.getKey(Lee.class, id));
//        Lee l = (Lee) valueOperations.get();
    }

    @Override
    public void setCacheLee(final Lee lee) {
        getRedisTemplate().opsForValue().set(CacheKeyGetter.getKey(Lee.class, lee.getId()), lee);
    }
}
