create table information(
	id serial primary key,
	requisite int,
	balance int);
	
create table client(
	id serial primary key,
	name varchar(255),
	salary int,
	inf_id int references information(id) unique);
	
insert into information(requisite, balance) values (123456, 1000000);
insert into information(requisite, balance) values (654321, 150000);
insert into information(requisite, balance) values (456789, 400000);
insert into information(requisite, balance) values (987654, 200000);
	
insert into client(name, salary, inf_id) values ('Егор', 150000, 1);
insert into client(name, salary, inf_id) values ('Иван', 50000, 2);
insert into client(name, salary, inf_id) values ('Марина', 60000, 3);
insert into client(name, salary, inf_id) values ('Женя', 45000, 4);


select c.name as Имя_Клиента, c.salary as Зарплата, i.requisite as Реквизиты, i.balance as Баланс from client as c join information as i on c.inf_id=i.id;