INSERT INTO buildings (NAME, FLOORS) VALUES
('Building1', 1),
('Building2', 2),
('Building3', 3);

INSERT INTO floors (number, buildingid) VALUES
(1, 1),
(1, 2),
(2, 2),
(1, 3),
(2, 3),
(3, 3);

INSERT INTO classrooms (number, floorid) VALUES
(12, 1),
(23, 2),
(34, 3),
(43, 4),
(51, 5),
(14, 5);

INSERT INTO departments (name) VALUES
('Math Department'),
('History Department');


INSERT INTO professors (name, departmentid) VALUES
('Smith', 1),
('Stevenson', 1),
('Anderson', 2),
('Jackson', 2);

INSERT INTO streams (name, departmentid) VALUES
('M-1', 1),
('H-1', 2);

INSERT INTO groups (name, streamid) VALUES
('M-1-1', 1),
('H-1-1', 2);

INSERT INTO students (name, groupid) VALUES
('James', 1),
('Rose', 1),
('Steven', 2),
('Chris', 2);

INSERT INTO subjects (name) VALUES
('Math'),
('Physics'),
('History'),
('Geography');

INSERT INTO lectures (date, time, subjectid, professorid, classroomid) VALUES
('2020-10-7', '7:45', 1, 1, 1),
('2020-10-7', '9:30', 2, 2, 2),
('2020-10-7', '11:15', 3, 3, 3),
('2020-10-7', '13:10', 4, 4, 4),
('2020-10-14', '7:45', 1, 1, 1),
('2020-10-14', '9:30', 2, 2, 2),
('2020-10-14', '11:15', 3, 3, 3),
('2020-10-14', '13:10', 4, 4, 4),
('2020-10-21', '7:45', 1, 1, 1),
('2020-10-21', '9:30', 2, 2, 2),
('2020-10-21', '11:15', 3, 3, 3),
('2020-10-21', '13:10', 4, 4, 4);

INSERT INTO lecturegroups (LECTUREID, GROUPID) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 2),
(3, 1),
(4, 2),
(5, 1),
(7, 1);
