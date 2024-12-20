package com.example.demo.services;

import com.example.demo.models.SchedulePeriod;
import com.example.demo.models.ScheduleSlot;
import com.example.demo.repositories.SchedulePeriodRepository;
import com.example.demo.specifications.period.Builder;
import com.example.demo.specifications.period.Filter;
//import com.example.demo.specifications.period.Sort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulePeriodService {
    private final SchedulePeriodRepository schedulePeriodRepository;

   // public SchedulePeriod save(SchedulePeriod schedulePeriod) { return schedulePeriodRepository.save(schedulePeriod);   }
   // public List<SchedulePeriod> findAll() { return schedulePeriodRepository.findAll();  }
    public SchedulePeriod get(String id) {
        return schedulePeriodRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Period not found"));
    }
    @Transactional
    public SchedulePeriod save(SchedulePeriod schedulePeriod) {
        ScheduleSlot slot = schedulePeriod.getSlot();

        boolean isOverlap = checkOverlap(schedulePeriod.getId(), slot);

        if (isOverlap) {
            throw new IllegalArgumentException("Period is overlap with existing period. Cant create new period");
        }

        return schedulePeriodRepository.save(schedulePeriod);
    }

    public List<SchedulePeriod> filter(Filter filter, com.example.demo.specifications.period.Sort  sort, int page, int size) {
        Specification<SchedulePeriod> specification = Builder.build(filter);
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(sort.getDirection()), sort.getField());
        return schedulePeriodRepository.findAll(specification, pageRequest).getContent();
    }

    private boolean checkOverlap(String periodId, ScheduleSlot slot) {
        return schedulePeriodRepository.exists(Specification.where(Builder.checkOverlappingTime(slot, periodId)));
    }
}
