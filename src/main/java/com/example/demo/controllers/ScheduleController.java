package com.example.demo.controllers;

import com.example.demo.models.Schedule;
import com.example.demo.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ScheduleController {
    private final ScheduleService scheduleService;
    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping("/schedule/{id}")
    public Schedule getSchedule(@PathVariable("id") String id) {return scheduleService.get(id); }
    @PostMapping("/schedule-create")
    public Schedule createSchedule(Schedule schedule) {return scheduleService.save(schedule);}
    @GetMapping("/schedule-all")
    public List<Schedule> getSchedules() {return scheduleService.findAll();}
}
