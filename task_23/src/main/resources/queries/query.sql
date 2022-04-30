create table student (
    id bigserial primary key,
    first_name varchar(100),
    last_name varchar(100),
    university_id int
);

create sequence student_sequence start 1 increment 1;

create table university (
    id bigserial primary key,
    name text,
    creation_date date
);

create sequence university_sequence start 1 increment 1;

create table app_user (
    id bigserial primary key,
    login text,
    password text
);

create sequence app_user_sequence start 1 increment 1;
