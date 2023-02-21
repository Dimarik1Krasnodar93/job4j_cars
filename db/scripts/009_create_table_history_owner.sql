CREATE TABLE history_owner (
car_id INT REFERENCES car(id),
driver_id INT REFERENCES driver(id),
start_at TIMESTAMP,
end_at TIMESTAMP
)