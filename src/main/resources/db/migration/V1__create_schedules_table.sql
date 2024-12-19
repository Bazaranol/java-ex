CREATE TABLE schedules (
    id VARCHAR(32) PRIMARY KEY,
    schedule_name VARCHAR(255),
    creationDate TIMESTAMPTZ NOT NULL,
);

