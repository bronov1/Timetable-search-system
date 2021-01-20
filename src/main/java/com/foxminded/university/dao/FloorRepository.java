package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FloorRepository extends JpaRepository<Floor, Integer> {
}
