
DROP TABLE IF EXISTS buildings CASCADE;
DROP TABLE IF EXISTS floors CASCADE;
DROP TABLE IF EXISTS classrooms CASCADE;
DROP TABLE IF EXISTS departments CASCADE;
DROP TABLE IF EXISTS streams CASCADE;
DROP TABLE IF EXISTS groups CASCADE;
DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS professors CASCADE;
DROP TABLE IF EXISTS subjects CASCADE;
DROP TABLE IF EXISTS lectures CASCADE;
DROP TABLE IF EXISTS lectureGroups CASCADE;

create table buildings
(
    id serial
        constraint buildings_pkey
            primary key,
    name   varchar(30),
    floors integer
);

create table floors
(
    id serial primary key,
    number int,
    "building_id" int
        constraint "building_id"
            references buildings
);

create table classrooms
(
    id serial primary key,
    number int,
    "floor_id" int references floors (id)
);

create table departments
(
    id serial primary key,
    name varchar(30)
);

create table streams
(
    id serial primary key,
    name varchar(30),
    "department_id" int references departments (id)
);

create table groups
(
    id serial primary key,
    name varchar(30),
    "stream_id" int references streams (id)
);

create table students
(
    id serial primary key,
    name varchar(30),
    "group_id" int references groups (id)
);

create table professors
(
    id serial primary key,
    name varchar(30),
    "department_id" int references departments (id)
);

create table subjects
(
    id serial primary key,
    name varchar(30)
);

create table lectures
(
    id serial primary key,
    date date,
    time time,
    "subject_id" int references subjects (id),
    "professor_id" int references professors (id),
    "classroom_id" int references classrooms (id)
);

create table lectureGroups
(
    id serial primary key,
    "lecture_id" int references lectures (id),
    "group_id" int references groups (id)
);




