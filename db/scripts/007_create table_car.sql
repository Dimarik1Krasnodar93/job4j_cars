CREATE TABLE car (
id SERIAL PRIMARY KEY,
name TEXT,
engine_id INT REFERENCES engine(id)
)