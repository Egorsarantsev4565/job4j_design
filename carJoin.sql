create table owners(
	id serial primary key,
	name varchar(255));
	
create table car(
	id serial primary key,
	marka_model varchar(255),
	h_p int,
	owners_id int references owners(id));
	

insert into owners(name) values ('Иван');
insert into owners(name) values ('Данил');
insert into owners(name) values ('Егор');
insert into owners(name) values ('Саша');
insert into owners(name) values ('Женя');

insert into car(marka_model, h_p, owners_id) values ('Kia Rio', 120, 1);
insert into car(marka_model, h_p, owners_id) values ('Kia Stinger', 249, 2);
insert into car(marka_model, h_p, owners_id) values ('Kia Sorento', 250, 2);
insert into car(marka_model, h_p, owners_id) values ('Toyota Land Cruiser 200', 250, 3);
insert into car(marka_model, h_p, owners_id) values ('Toyota Camry', 249, 3);
insert into car(marka_model, h_p, owners_id) values ('Cadillac Escalade', 400, 4);
insert into car(marka_model, h_p, owners_id) values ('Volkswagen Toureg', 350, 5);
insert into car(marka_model, h_p, owners_id) values ('Volkswagen Tiguan', 175, 5);

select o.name as Владелец, c.marka_model as Автомобиль, c.h_p as Мощность from car as c join owners as o on c.owners_id=o.id;