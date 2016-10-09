package com.sdll18.lee2.dao.cache.impl;

import com.sdll18.lee2.common.CacheKeyGetter;
import com.sdll18.lee2.dao.cache.LeeCacheDao;
import com.sdll18.lee2.model.sql.Lee;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisCallback;
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
        BoundValueOperations valueOperations = getRedisTemplate().boundValueOps(CacheKeyGetter.getKey(Lee.class, id));
        Lee l = (Lee) valueOperations.get();
        return l;
//        return (Lee) getRedisTemplate().execute(new RedisCallback<Lee>() {
//            @Override
//            public Lee doInRedis(RedisConnection connection) throws DataAccessException {
//                byte[] key = getRedisTemplate().getStringSerializer().serialize(CacheKeyGetter.getKey(Lee.class, id));
//                if (connection.exists(key)) {
//                    byte[] value = connection.get(key);
//                    Lee lee = (Lee) getRedisTemplate().getValueSerializer().deserialize(value);
//                    return lee;
//                }
//                return null;
//            }
//        });
    }

    @Override
    public void setCacheLee(final Lee lee) {
        getRedisTemplate().opsForValue().set(CacheKeyGetter.getKey(Lee.class, lee.getId()), lee);
//        getRedisTemplate().execute(new RedisCallback<Object>() {
//            @Override
//            public Object doInRedis(RedisConnection connection) throws DataAccessException {
//                byte[] key = getRedisTemplate().getStringSerializer().serialize(CacheKeyGetter.getKey(Lee.class, lee.getId()));
////                byte[] value = getRedisTemplate().getValueSerializer().serialize(lee);
//                byte[] value = new byte[]{1, 2, 3, 4, 5};
//                connection.set(key, value);
//                return null;
//            }
//        });
    }
}
