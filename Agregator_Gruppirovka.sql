create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values ('Apple Iphone 13', 60000);
insert into devices(name, price) values ('Apple Iphone 12', 49000);
insert into devices(name, price) values ('Apple Iphone 10', 29000);
insert into devices(name, price) values ('Honor 50 Lite', 23000);
insert into devices(name, price) values ('Huawei MateBook',25000);
insert into devices(name, price) values ('Honor 30i', 15000);
insert into devices(name, price) values ('Apple iMac Retina', 180000);
insert into devices(name, price) values ('Apple iMac', 221000);

insert into people(name) values ('Ваня');
insert into people(name) values ('Егор');
insert into people(name) values ('Данила');
insert into people(name) values ('Денис');

insert into devices_people(device_id, people_id) values (1, 2);
insert into devices_people(device_id, people_id) values (2, 1);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (4, 4);
insert into devices_people(device_id, people_id) values (5, 4);
insert into devices_people(device_id, people_id) values (6, 1);
insert into devices_people(device_id, people_id) values (7, 2);
insert into devices_people(device_id, people_id) values (8, 3);


select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp join people as p on dp.people_id=p.id join devices as d on dp.device_id=d.id group by p.name;

select p.name, avg(d.price) from devices_people as dp join people as p on dp.people_id=p.id join devices as d on dp.device_id=d.id group by p.name having avg(d.price)>30000;

