package com.example.demo.services;

import com.example.demo.models.Schedule;
import com.example.demo.repositories.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule) { return this.scheduleRepository.save(schedule); }

    public List<Schedule> findAll() { return scheduleRepository.findAll(); }

    public Schedule get(String id) { return scheduleRepository.findById(id).get(); }
}
