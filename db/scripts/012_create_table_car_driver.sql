CREATE TABLE car_driver (
id  SERIAL PRIMARY KEY,
car_id INT REFERENCES car(id),
driver_id INT REFERENCES driver(id)
)