package com.example.demo.specifications.period;

import com.example.demo.models.Schedule;
import com.example.demo.models.SchedulePeriod;
import com.example.demo.models.ScheduleSlot;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    public static Specification<SchedulePeriod> build(Filter filter) {
        return (root, query, criteriaBuilder) -> {
             List<Predicate> predicates = new ArrayList<>();
             if (filter.getId() != null) {
                 predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
             }
             if (filter.getSlotId() != null) {
                 predicates.add(criteriaBuilder.equal(root.get("slotId"), filter.getSlotId()));
             }
             if (filter.getScheduleId() != null) {
                 predicates.add(criteriaBuilder.equal(root.get("scheduleId"), filter.getScheduleId()));
             }
             if(filter.getSlotType() != null) {
                 predicates.add(criteriaBuilder.equal(root.get("slotType"), filter.getSlotType()));
             }
             if (filter.getAdministratorId() != null) {
                 predicates.add(criteriaBuilder.equal(root.get("administratorId"), filter.getAdministratorId()));
             }
             if (filter.getExecutorId() != null) {
                 predicates.add(criteriaBuilder.equal(root.get("executorId"), filter.getExecutorId()));
             }
             return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
             //return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    public static Specification<SchedulePeriod> checkOverlappingTime(ScheduleSlot slot, String periodId) {
        return (root, query, criteriaBuilder) -> {
            Predicate isNotSamePeriod = criteriaBuilder.notEqual(root.get("id"), periodId);
            Predicate isOverlap = criteriaBuilder.and(
                    criteriaBuilder.lessThanOrEqualTo(root.get("slot").get("beginTime"), slot.getEndTime()),
                    criteriaBuilder.greaterThanOrEqualTo(root.get("slot").get("endTime"), slot.getBeginTime())
            );
            return criteriaBuilder.and(isNotSamePeriod, isOverlap);
        };
    }
}
