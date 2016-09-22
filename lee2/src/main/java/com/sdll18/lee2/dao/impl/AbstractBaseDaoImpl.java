package com.sdll18.lee2.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright (C) 2015 - 2016 SOHU FOCUS Inc., All Rights Reserved.
 *
 * @Author: junlanli@sohu-inc.com
 * @Data: 2016-09-22
 */
public abstract class AbstractBaseDaoImpl{

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
