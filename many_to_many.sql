create table people(
id serial primary key,
name varchar(255));

create table taxi_service(
id serial primary key,
name varchar(255));

create table people_taxi_service(
id serial primary key,
people_id int references people(id),
taxi_service_id int references taxi_service(id));