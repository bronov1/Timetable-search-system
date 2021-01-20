package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
