CREATE TABLE IF NOT EXISTS orders(
    id BIGSERIAL PRIMARY KEY,
    the_name VARCHAR(200),
    total_amount DOUBLE PRECISION,
    status VARCHAR(9),
    the_date TIMESTAMP
);