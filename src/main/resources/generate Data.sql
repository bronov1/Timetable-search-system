INSERT INTO buildings (NAME, FLOORS) VALUES
('Building1', 1),
('Building2', 2),
('Building3', 3);

INSERT INTO floors (number, building_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(1, 3),
(2, 3),
(3, 3);

INSERT INTO classrooms (number, floor_id) VALUES
(12, 1),
(23, 2),
(34, 3),
(43, 4),
(51, 5),
(14, 5),
(33, 6);

INSERT INTO departments (name) VALUES
('Math Department'),
('History Department');


INSERT INTO professors (name, department_id) VALUES
('Smith', 1),
('Stevenson', 1),
('Anderson', 2),
('Jackson', 2);

INSERT INTO streams (name, department_id) VALUES
('M-1', 1),
('H-1', 2);

INSERT INTO groups (name, stream_id) VALUES
('M-1-1', 1),
('H-1-1', 2);

INSERT INTO students (name, group_id) VALUES
('James', 1),
('Rose', 1),
('Steven', 2),
('Chris', 2);

INSERT INTO subjects (name) VALUES
('Math'),
('Physics'),
('History'),
('Geography');

INSERT INTO lectures (date, time, subject_id, professor_id, classroom_id) VALUES
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

INSERT INTO lecturegroups (LECTURE_ID, GROUP_ID) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 2),
(3, 1),
(4, 2),
(5, 1),
(6, 2),
(7, 1),
(8, 2),
(9, 1),
(10, 1),
(10, 2),
(11, 2),
(12, 1);