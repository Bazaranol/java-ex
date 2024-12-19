CREATE TABLE schedule_slots (
    id VARCHAR(32) PRIMARY KEY,
    schedule_template_id VARCHAR(32) NOT NULL,
    begin_time TIMETZ NOT NULL,
    end_time TIMETZ NOT NULL,
    CONSTRAINT fk_schedule_template FOREIGN KEY (schedule_template_id) REFERENCES schedules(id)
);

