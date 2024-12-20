package com.example.demo.specifications.period;

import lombok.Getter;

@Getter
public class Filter {
    private final String id;
    private final String slotId;
    private final String scheduleId;
    private final String slotType;
    private final String administratorId;
    private final String executorId;

    public Filter(String id, String slotId, String scheduleId, String slotType, String administratorId, String executorId) {
        this.id = id;
        this.slotId = slotId;
        this.scheduleId = scheduleId;
        this.slotType = slotType;
        this.administratorId = administratorId;
        this.executorId = executorId;
    }
}
