package com.foxminded.university.dao;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t, Object[] params);

    void delete(T t);
}

