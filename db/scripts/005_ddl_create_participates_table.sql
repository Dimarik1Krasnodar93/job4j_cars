CREATE TABLE participates (
   id serial PRIMARY KEY,
   post_id int not null REFERENCES aoto_post(id),
   user_id int not null REFERENCES auto_user(id)
);