create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('SEA_fish', 5000, null);
insert into fauna(name, avg_age, discovery_date) values ('RIVER_fish', 15000, '1900-09-01');
insert into fauna(name, avg_age, discovery_date) values ('LAKE_fish', 11000, '1910-04-09');
insert into fauna(name, avg_age, discovery_date) values ('AFRIKA1', 25000, '1915-07-01');
insert into fauna(name, avg_age, discovery_date) values ('AFRIKA2', 50000, null);
insert into fauna(name, avg_age, discovery_date) values ('AFRIKA3', 20000, '2001-04-24');
insert into fauna(name, avg_age, discovery_date) values ('RUSSIA1', 21000, null);
insert into fauna(name, avg_age, discovery_date) values ('RUSSIA2', 15000, '1940-06-15');
insert into fauna(name, avg_age, discovery_date) values ('RUSSIA3', 9000, null);
insert into fauna(name, avg_age, discovery_date) values ('USA1', 13000, '1945-01-05');
insert into fauna(name, avg_age, discovery_date) values ('USA2', 16000, '1815-05-06');
insert into fauna(name, avg_age, discovery_date) values ('USA3', 2000, '1800-03-07');
insert into fauna(name, avg_age, discovery_date) values ('AUSTRALIA1', 30000, null);
insert into fauna(name, avg_age, discovery_date) values ('AUSTRALIA2', 21500, '2020-02-02');
insert into fauna(name, avg_age, discovery_date) values ('AUSTRALIA3', 19000, null);