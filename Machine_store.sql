create table car_bodies(
	id serial primary key,
	name varchar(255));

create table car_engines(
	id serial primary key,
	name varchar(255));

create table car_transmissions(
	id serial primary key,
	name varchar(255));

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id));
	
insert into car_bodies(name) values ('Седан');
insert into car_bodies(name) values ('Хетчбэк');
insert into car_bodies(name) values ('Универсал');
insert into car_bodies(name) values ('Кроссовер');
insert into car_bodies(name) values ('Пикап');

insert into car_engines(name) values ('1.6');
insert into car_engines(name) values ('1.8');
insert into car_engines(name) values ('2.0');
insert into car_engines(name) values ('2.5');
insert into car_engines(name) values ('3.5');
insert into car_engines(name) values ('5.5');

insert into car_transmissions(name) values ('Механическая');
insert into car_transmissions(name) values ('Вариатор');
insert into car_transmissions(name) values ('Автомат');
insert into car_transmissions(name) values ('Робот');
insert into car_transmissions(name) values ('Гибрид');

insert into cars(name, body_id, engine_id, transmission_id) values ('Kia Rio', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota Camry', 1, 5, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Volkswagen Polo', 1, 1, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('LADA Vesta', 1, 1, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('Hyundai i40', 1, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Chevrolet Epica', 1, 3, 1);

insert into cars(name, body_id, engine_id, transmission_id) values ('Kia Soul', 2, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('LADA XRAY', 2, 2, 4);
insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota Prius', 2, 2, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Kia Picanto', 2, null, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Chevrolet Spark', 2, null, 3);

insert into cars(name, body_id, engine_id, transmission_id) values ('LADA Kalina', 3, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Ford Focus', 3, 3, null);
insert into cars(name, body_id, engine_id, transmission_id) values ('Subaru Outback', 3, null, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('Volkswagen Passat', null, 3, 4);

insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota Highlander', 4, 5, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Lexus RX 330', 4, null, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Nissan Murano', 4, 5, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('Renault Arkana', null, null, null);
insert into cars(name, body_id, engine_id, transmission_id) values ('Unknown', 1, 1, null);


select c.name as Автомобиль, b.name as Кузов, e.name as Двигатель, t.name as Трансмиссия
from cars as c 
left join car_bodies as b on b.id=c.body_id
left join car_engines as e on e.id=c.engine_id
left join car_transmissions as t on t.id=c.transmission_id;

select c.name as Автомобиль, b.name as Кузов 
from car_bodies as b 
left join cars as c on b.id=c.body_id 
where c.body_id is null;

select c.name as Автомобиль, e.name as Двигатель 
from car_engines as e 
left join cars as c on e.id=c.engine_id 
where c.engine_id is null;

select c.name as Автомобиль, t.name as Трансмиссия 
from car_transmissions as t 
left join cars as c on t.id=c.transmission_id 
where c.transmission_id is null;