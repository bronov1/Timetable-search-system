package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BuildingRepository extends CrudRepository<Building, Integer> {
}
