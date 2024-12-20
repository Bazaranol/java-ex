package com.example.demo.services;

import com.example.demo.models.ScheduleSlot;

import com.example.demo.repositories.ScheduleSlotRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleSlotService {
    private final ScheduleSlotRepository scheduleSlotRepository;

    public ScheduleSlot save(ScheduleSlot scheduleSlot) {   return scheduleSlotRepository.save(scheduleSlot);  }
    public ScheduleSlot get(String id) { return scheduleSlotRepository.findById(id).get();  }
    public List<ScheduleSlot> findAll() {   return scheduleSlotRepository.findAll();    }

    // public ScheduleSlot get(String id) { return scheduleSlotRepository.findById(id).orElse(null);  }
}
