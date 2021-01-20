package com.foxminded.university.dao;

import com.foxminded.university.entity.Stream;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StreamRepository extends CrudRepository<Stream, Integer> {
}
