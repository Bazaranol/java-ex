package com.example.demo.repositories;

import com.example.demo.models.SchedulePeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulePeriodRepository extends JpaRepository<SchedulePeriod, String> {
}
