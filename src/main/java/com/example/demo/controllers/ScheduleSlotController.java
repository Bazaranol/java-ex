package com.example.demo.controllers;

import com.example.demo.models.ScheduleSlot;
import com.example.demo.services.ScheduleSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ScheduleSlotController {
    private final ScheduleSlotService scheduleSlotService;
    @Autowired
    public ScheduleSlotController(ScheduleSlotService scheduleSlotService) {
        this.scheduleSlotService = scheduleSlotService;
    }
    @GetMapping("/slot/{id}")
    public ScheduleSlot getSlot(@PathVariable("id") String id) { return scheduleSlotService.get(id); }

    @PostMapping("/slot-create")
    public ScheduleSlot createSlot(ScheduleSlot scheduleSlot) { return scheduleSlotService.save(scheduleSlot); }

    @GetMapping("/slot-all")
    public List<ScheduleSlot> getAllSlots() { return scheduleSlotService.findAll(); }
}
