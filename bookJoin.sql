create table book(
	id serial primary key,
	name varchar(255));
	
create table student(
	id serial primary key,
	name varchar(255),
	book_id int references book(id) unique);
	
insert into book(name) values('Мертвые души');
insert into book(name) values('Преступление и наказание');
insert into book(name) values('Война и мир');
insert into book(name) values('Робинзон Крузо');

insert into student(name, book_id) values('Иван', 2);
insert into student(name, book_id) values('Егор', 1);
insert into student(name, book_id) values('Данила', 3);
insert into student(name, book_id) values('Саша', 4);
insert into student(name) values('Денис');

select b.name as Название, st.name as Имя from student as st join book as b on st.book_id=b.id;