package com.sdll18.lee2.dao.impl;

import com.sdll18.lee2.dao.LeeUserDao;
import com.sdll18.lee2.model.Lee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright (C) 2015 - 2016 MICROSCENE Inc., All Rights Reserved.
 *
 * @Author: lee@visualbusiness.com
 * @Data: 2016-09-19
 */
@Repository("leeUserDao")
public class LeeUserDaoImpl extends AbstractBaseDaoImpl implements LeeUserDao{

    @Override
    public String save(Lee entity) {
        Session session = getSessionFactory().getCurrentSession();
        String r = (String) session.save(entity);
        return r;
    }

    @Override
    public Lee get(String id) {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.createQuery("FROM Lee l WHERE l.id='" + id + "'");
        List<Lee> l = query.list();
        return l.get(0);
    }
}
