package com.foxminded.university.dao;

import com.foxminded.university.entity.Stream;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StreamDao extends AbstractDao<Stream> {

    public StreamDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
