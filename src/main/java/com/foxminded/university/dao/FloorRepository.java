package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FloorRepository extends CrudRepository<Floor, Integer> {
}
