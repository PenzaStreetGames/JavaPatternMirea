create table users (
    id int,
    first_name varchar(100),
    last_name varchar(100)
);

create sequence users_sequence start 1 increment 1;

create table university (
    id bigserial primary key,
    name text,
    creation_date date
);

create  sequence universities start 1 increment 1;
create sequence university_sequence start 1 increment 1;