package com.sdll18.lee2.dao.cache;

import com.sdll18.lee2.model.sql.Lee;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Date: 2016-10-09
 */
public interface LeeCacheDao {

    Lee getCacheLee(String id);

    void setCacheLee(Lee lee);
}
