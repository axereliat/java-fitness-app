package com.fitness.domain.repository;

import com.fitness.domain.entities.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyActivityRepository extends JpaRepository<DailyActivity, Integer> {

}
