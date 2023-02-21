CREATE TABLE history_owner (
car_id REFERENCES car(id),
driver_id REFERENCES driver(id),
start_at TIMESTAMP,
end_at TIMESTAMP
)