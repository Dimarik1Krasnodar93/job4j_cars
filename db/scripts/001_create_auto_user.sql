CREATE table auto_user (
id serial primary key,
login text NOT NULL UNIQUE,
password text
)