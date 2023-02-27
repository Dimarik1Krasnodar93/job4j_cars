CREATE TABLE car_driver (
id INT SERIAL PRIMARY KEY,
car_id REFERENCES car(id),
driver_id REFERENCES driver(id)
)