package com.example.demo.repositories;

import com.example.demo.models.ScheduleSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleSlotRepository extends JpaRepository<ScheduleSlot, String> {
}
