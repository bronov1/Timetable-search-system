package com.foxminded.university.dao;

import com.foxminded.university.entity.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StreamRepository extends JpaRepository<Stream, Integer> {
}
