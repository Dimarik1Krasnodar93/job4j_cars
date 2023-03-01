ALTER TABLE car ADD COLUMN car_body_id int REFERENCES car_body(id);
ALTER TABLE car ADD COLUMN new_car BOOLEAN;