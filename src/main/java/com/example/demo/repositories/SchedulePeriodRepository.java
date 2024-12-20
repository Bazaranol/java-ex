package com.example.demo.repositories;

import com.example.demo.models.SchedulePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SchedulePeriodRepository extends JpaRepository<SchedulePeriod, String>, JpaSpecificationExecutor<SchedulePeriod> {
}
