package com.example.demo.controllers;

import com.example.demo.models.ScheduleTemplate;
import com.example.demo.services.ScheduleTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ScheduleTemplateController {
    private final ScheduleTemplateService scheduleTemplateService;
    @Autowired
    public ScheduleTemplateController(ScheduleTemplateService scheduleTemplateService) {
        this.scheduleTemplateService = scheduleTemplateService;
    }
    @GetMapping("/template/{id}")
    public ScheduleTemplate getTemplate(@PathVariable("id") String id) {return scheduleTemplateService.get(id);}
    @PostMapping("/template-create")
    public ScheduleTemplate createTemplate(@RequestBody ScheduleTemplate scheduleTemplate) { return scheduleTemplateService.save(scheduleTemplate);}
    @GetMapping("/template-all")
    public List<ScheduleTemplate> getAllTemplates() {return scheduleTemplateService.getAll();}
}
