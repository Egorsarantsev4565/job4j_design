create table departments(
	id serial primary key, 
	name varchar(255));

create table employees(
	id serial primary key,
	name varchar(255),
	dep_id int references departments(id));

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255));

insert into departments(name) values('1');
insert into departments(name) values('2');
insert into departments(name) values('3');
insert into departments(name) values('4');
insert into departments(name) values('5');

insert into employees(name, dep_id) values('Егор', 1);
insert into employees(name, dep_id) values('Ваня', 2);
insert into employees(name, dep_id) values('Данила', 3);
insert into employees(name, dep_id) values('Денис', 3);
insert into employees(name, dep_id) values('Степа', 1);
insert into employees(name, dep_id) values('Никита', 5);
insert into employees(name, dep_id) values('Даша', null);
insert into employees(name, dep_id) values('Максим', null);

insert into teens(name, gender) values('Марина', 'жен');
insert into teens(name, gender) values('Аня', 'жен');
insert into teens(name, gender) values('Настя', 'жен');
insert into teens(name, gender) values('Кирилл', 'муж');
insert into teens(name, gender) values('Артем', 'муж');
insert into teens(name, gender) values('Андрей', 'муж');

select d.name as Департамент, e.name Сотрудник 
from departments d 
left join employees e 
on d.id=e.dep_id;

select e.name Сотрудник, d.name as Департамент 
from employees e 
right join departments d 
on d.id=e.dep_id;

select d.name as Департамент, e.name Сотрудник 
from departments d 
full join employees e on 
d.id=e.dep_id;

select d.name as Департамент, e.name Сотрудник 
from departments d 
cross join employees e;

select e.name Сотрудник, d.name as Департамент  
from employees e 
cross join departments d;

select d.name as Департамент, e.name Сотрудник 
from departments d
left join employees e 
on e.dep_id=d.id 
where e.id is null;

select e.name Сотрудник, d.name as Департамент 
from employees e 
left join departments d 
on e.dep_id=d.id;

select d.name as Департамент, e.name Сотрудник 
from departments d
right join employees e 
on e.dep_id=d.id;

select t1.name as t1, t2.name as t2 
from teens t1 
cross join teens t2 
where t1.gender!=t2.gender;