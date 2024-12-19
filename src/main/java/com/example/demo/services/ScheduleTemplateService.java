package com.example.demo.services;

import com.example.demo.models.ScheduleTemplate;
import com.example.demo.repositories.ScheduleTemplateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleTemplateService {
    private final ScheduleTemplateRepository scheduleTemplateRepository;

    public ScheduleTemplate get(String id) {return scheduleTemplateRepository.findById(id).get();}
    public List<ScheduleTemplate> getAll() {return scheduleTemplateRepository.findAll();}
    public ScheduleTemplate save(ScheduleTemplate scheduleTemplate) {return scheduleTemplateRepository.save(scheduleTemplate);}
}
