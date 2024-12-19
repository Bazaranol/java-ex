package com.example.demo.models;

import com.example.demo.models.enums.SlotType;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "schedule_periods")
public class SchedulePeriod {
    @Id
    @Generated
    @Column
    private String id;

    @Column
    private String slotId;

    @Column
    private String scheduleId;

    @Column
    private SlotType slotType;

    @Column
    private String administratorId;

    @Column
    private String executorId;
}
