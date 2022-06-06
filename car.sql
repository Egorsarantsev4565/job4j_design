create table car (
id serial primary key,
marka varchar(255),
model varchar(255),
engine float,
horse_power int,
availability boolean);

insert into car(marka,model,engine,horse_power,availability) values ('Kia', 'Rio', 1.6, 123, false);
insert into car(marka,model,engine,horse_power,availability) values ('Scoda', 'Rapid', 1.6, 110, false);
insert into car(marka,model,engine,horse_power,availability) values ('Toyota', 'Kamry', 3.5, 249, false);

update car set availability=true;

delete from car;