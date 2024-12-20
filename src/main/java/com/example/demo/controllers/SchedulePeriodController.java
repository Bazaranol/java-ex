package com.example.demo.controllers;

import com.example.demo.models.SchedulePeriod;
import com.example.demo.services.SchedulePeriodService;
import com.example.demo.specifications.period.Filter;
import com.example.demo.specifications.period.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SchedulePeriodController {
    private final SchedulePeriodService schedulePeriodService;
    @Autowired
    public SchedulePeriodController(SchedulePeriodService schedulePeriodService) {
        this.schedulePeriodService = schedulePeriodService;
    }
    
    @GetMapping("/period/{id}")
    public SchedulePeriod getPeriod(@PathVariable("id") String id) { return schedulePeriodService.get(id); }

    @PostMapping("/period-create")
    public SchedulePeriod createPeriod(@RequestBody SchedulePeriod schedulePeriod) { return schedulePeriodService.save(schedulePeriod);}

//    @GetMapping("/period-all")
//    public List<SchedulePeriod> getAllPeriods() { return schedulePeriodService.findAll(); }

    @GetMapping("/period-filter")
    public List<SchedulePeriod> getPeriodFilter(@RequestBody Filter filter, @RequestBody Sort sort, @RequestParam int page, @RequestParam int size) {
        return schedulePeriodService.filter(filter, sort, page, size);
    }
}
