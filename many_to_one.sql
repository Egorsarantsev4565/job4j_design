create table owner(
id serial primary key,
name varchar(255));

create table car(
id serial primary key,
model varchar(255),
owner_id int references owner(id));
