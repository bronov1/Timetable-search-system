
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
    "buildingid" int
        constraint "buildingid"
            references buildings
);

create table classrooms
(
    id serial primary key,
    number int,
    "floorid" int references floors (id)
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
    "departmentid" int references departments (id)
);

create table groups
(
    id serial primary key,
    name varchar(30),
    "streamid" int references streams (id)
);

create table students
(
    id serial primary key,
    name varchar(30),
    "groupid" int references groups (id)
);

create table professors
(
    id serial primary key,
    name varchar(30),
    "professorid" int references professors (id)
);

create table subjects
(
    id serial primary key,
    name varchar(30),
    "subjectid" int references subjects (id)
);

create table lectures
(
    id serial primary key,
    date Date,
    "subjectid" int references subjects (id),
    "professorid" int references professors (id),
    "classroomid" int references classrooms (id)
);

create table lectureGroups
(
    id serial primary key,
    "lectureid" int references lectures (id),
    "groupid" int references groups (id)
);




