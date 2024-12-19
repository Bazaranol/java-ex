package com.example.demo.models;

import lombok.*;
import jakarta.persistence.*;

import java.time.OffsetTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "schedule_slots")
public class ScheduleSlot {
    @Id
    @Generated
    private String id;

    @Column
    private String scheduleTemplateId;
    @Column
    private OffsetTime beginTime;
    @Column
    private OffsetTime endTime;
}
