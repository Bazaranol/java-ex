CREATE TABLE schedule_periods (
    id VARCHAR(32) PRIMARY KEY,
    slot_id VARCHAR(32) NOT NULL,
    schedule_id VARCHAR(32) NOT NULL,
    slot_type VARCHAR(20) NOT NULL,
    administrator_id VARCHAR(32) NOT NULL,
    executor_id VARCHAR(32),
    CONSTRAINT fk_slot FOREIGN KEY (slot_id) REFERENCES schedule_slots(id),
    CONSTRAINT fk_schedule FOREIGN KEY (schedule_id) REFERENCES schedules(id),
    CONSTRAINT fk_administrator FOREIGN KEY (administrator_id) REFERENCES employees(id),
    CONSTRAINT fk_executor FOREIGN KEY (executor_id) REFERENCES employees(id)
);
