create table drivers_license(
id serial primary key,
number int);

create table people(
id serial primary key,
name varchar(255),
drivers_license_id int references drivers_license(id));
