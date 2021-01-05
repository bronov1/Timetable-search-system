package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao extends AbstractDao<Department>{

    public DepartmentDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
