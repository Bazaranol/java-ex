package com.example.demo.services;

import com.example.demo.models.SchedulePeriod;
import com.example.demo.repositories.SchedulePeriodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SchedulePeriodService {
    private final SchedulePeriodRepository schedulePeriodRepository;

    public SchedulePeriod save(SchedulePeriod schedulePeriod) { return schedulePeriodRepository.save(schedulePeriod);   }
    public List<SchedulePeriod> findAll() { return schedulePeriodRepository.findAll();  }
    public SchedulePeriod get(String id) {  return schedulePeriodRepository.findById(id).get(); }
}
