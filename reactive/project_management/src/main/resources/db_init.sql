CREATE TABLE IF NOT EXISTS project (
    id BIGSERIAL PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    done BOOLEAN NOT NULL
);