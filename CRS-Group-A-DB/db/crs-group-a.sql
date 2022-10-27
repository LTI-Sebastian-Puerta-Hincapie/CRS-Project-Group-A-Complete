/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs-group-a
Target Host: localhost
Target Database: crs-group-a
Date: 10/24/2022 9:11:44 AM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(32) NOT NULL auto_increment,
  `Name` varchar(64) NOT NULL,
  `Email` varchar(64) NOT NULL,
  `Phone` varchar(16) NOT NULL,
  `Address` varchar(64) NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CourseId` int(32) NOT NULL auto_increment,
  `CourseName` varchar(32) NOT NULL,
  `Description` varchar(32) NOT NULL,
  PRIMARY KEY  (`CourseId`)
) ENGINE=InnoDB AUTO_INCREMENT=1042 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for coursecatalog
-- ----------------------------
DROP TABLE IF EXISTS `coursecatalog`;
CREATE TABLE `coursecatalog` (
  `Id` int(32) NOT NULL auto_increment,
  `ProfessorId` int(32) NOT NULL,
  `DepartmentId` int(32) NOT NULL,
  `Prerequisite` varchar(32) NOT NULL,
  `Credits` tinyint(2) NOT NULL,
  `Capacity` int(32) NOT NULL,
  `Enrolled` int(32) NOT NULL,
  `Semester` varchar(32) NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1043 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DepartmentId` int(32) NOT NULL auto_increment,
  `DepartmentName` varchar(32) NOT NULL,
  `Description` varchar(32) default NULL,
  PRIMARY KEY  (`DepartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `MajorId` int(32) NOT NULL auto_increment,
  `MajorName` varchar(32) NOT NULL,
  `Description` varchar(32) NOT NULL,
  PRIMARY KEY  (`MajorId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `PaymentId` int(32) NOT NULL auto_increment,
  `PaymentAmount` decimal(10,0) NOT NULL,
  `StudentId` int(32) NOT NULL,
  `DueDate` datetime NOT NULL,
  `Semester` varchar(32) NOT NULL,
  `PaymentMethod` varchar(32) default NULL,
  `IsPaid` bit(1) default NULL,
  PRIMARY KEY  (`PaymentId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professorcourses
-- ----------------------------
DROP TABLE IF EXISTS `professorcourses`;
CREATE TABLE `professorcourses` (
  `ProfessorId` int(32) NOT NULL,
  `CourseId` int(32) NOT NULL,
  PRIMARY KEY  (`ProfessorId`,`CourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professors
-- ----------------------------
DROP TABLE IF EXISTS `professors`;
CREATE TABLE `professors` (
  `Id` int(32) NOT NULL auto_increment,
  `Name` varchar(32) NOT NULL,
  `DepartmentId` int(32) unsigned NOT NULL,
  `Email` varchar(64) NOT NULL,
  `Phone` varchar(16) NOT NULL,
  `Address` varchar(64) NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registeredcourse
-- ----------------------------
DROP TABLE IF EXISTS `registeredcourse`;
CREATE TABLE `registeredcourse` (
  `StudentId` int(32) NOT NULL,
  `CourseId` int(32) NOT NULL,
  `CourseName` varchar(32) default NULL,
  `RegistrationStatus` bit(1) NOT NULL,
  `Grade` varchar(2) default NULL,
  PRIMARY KEY  (`StudentId`,`CourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `RoleId` int(32) NOT NULL,
  `RoleName` varchar(32) NOT NULL,
  `Description` varchar(32) NOT NULL,
  PRIMARY KEY  (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for semesterregistration
-- ----------------------------
DROP TABLE IF EXISTS `semesterregistration`;
CREATE TABLE `semesterregistration` (
  `RegistrationId` int(32) NOT NULL auto_increment,
  `StudentId` int(32) NOT NULL,
  `ApprovalStatus` int(32) NOT NULL,
  `AdminId` int(32) NOT NULL,
  `Comment` varchar(64) default NULL,
  PRIMARY KEY  (`RegistrationId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `Id` int(32) NOT NULL auto_increment,
  `Name` varchar(32) NOT NULL,
  `MajorId` int(32) NOT NULL,
  `Email` varchar(64) NOT NULL,
  `Phone` varchar(16) NOT NULL,
  `Address` varchar(64) NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `Id` int(11) NOT NULL auto_increment,
  `Username` varchar(32) NOT NULL,
  `Password` varchar(64) NOT NULL,
  `RoleId` int(32) NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin@test.com', '111-222-3333', '100 Test Ave.');
INSERT INTO `course` VALUES ('1010', 'Biology 0', 'Science');
INSERT INTO `course` VALUES ('1011', 'Biology 1', 'Science');
INSERT INTO `course` VALUES ('1012', 'Biology 2', 'Science');
INSERT INTO `course` VALUES ('1020', 'Psychology 0', 'Behavioral Science');
INSERT INTO `course` VALUES ('1021', 'Psychology 1', 'Behavioral Science');
INSERT INTO `course` VALUES ('1022', 'Psychology 2', 'Behavioral Science');
INSERT INTO `course` VALUES ('1030', 'Economics 0', 'Business');
INSERT INTO `course` VALUES ('1031', 'Economics 1', 'Business');
INSERT INTO `course` VALUES ('1032', 'Economics 2', 'Business');
INSERT INTO `course` VALUES ('1040', 'Calculus 0', 'Mathematics');
INSERT INTO `course` VALUES ('1041', 'Calculus 1', 'Mathematics');
INSERT INTO `course` VALUES ('1042', 'Calculus 2', 'Mathematics');
INSERT INTO `coursecatalog` VALUES ('1010', '104', '100', '-', '3', '100', '1', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1011', '104', '100', 'Biology 0', '3', '80', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1012', '104', '100', 'Biology 1', '3', '80', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1020', '105', '200', '-', '3', '100', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1021', '105', '200', 'Psychology 0', '3', '75', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1022', '105', '200', 'Psychology 1', '3', '75', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1030', '106', '300', '-', '3', '50', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1031', '106', '300', 'Economics 0', '3', '50', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1032', '106', '300', 'Economics 1', '3', '50', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1040', '107', '400', '-', '3', '40', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1041', '107', '400', 'Calculus 0', '3', '40', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('1042', '107', '400', 'Calculus 1', '3', '40', '0', 'Fall 2022');
INSERT INTO `department` VALUES ('100', 'Biology', '');
INSERT INTO `department` VALUES ('200', 'Psychology', '');
INSERT INTO `department` VALUES ('300', 'Economoics', null);
INSERT INTO `department` VALUES ('400', 'Mathematics', '');
INSERT INTO `department` VALUES ('500', 'Physics', null);
INSERT INTO `major` VALUES ('1', 'Biology', 'Science');
INSERT INTO `major` VALUES ('2', 'Psychology', 'Science');
INSERT INTO `major` VALUES ('3', 'Economics', 'Business');
INSERT INTO `major` VALUES ('4', 'Mathematics', 'Science');
INSERT INTO `major` VALUES ('5', 'Physics', 'Science');
INSERT INTO `payment` VALUES ('22', '10125', '101', '2022-11-20 00:00:00', 'Fall 2022', 'credit', '');
INSERT INTO `professorcourses` VALUES ('104', '1010');
INSERT INTO `professorcourses` VALUES ('104', '1011');
INSERT INTO `professorcourses` VALUES ('104', '1012');
INSERT INTO `professorcourses` VALUES ('105', '1020');
INSERT INTO `professorcourses` VALUES ('105', '1021');
INSERT INTO `professorcourses` VALUES ('105', '1022');
INSERT INTO `professorcourses` VALUES ('106', '1030');
INSERT INTO `professorcourses` VALUES ('106', '1031');
INSERT INTO `professorcourses` VALUES ('106', '1032');
INSERT INTO `professors` VALUES ('104', 'Rubin Wu', '1', 'rwur@test.com', '111-222-3333', 'Rubin Ave, NY');
INSERT INTO `professors` VALUES ('105', 'Axel Ortega', '2', 'aortega@test.com', '111-222-3333', 'Axel Ln, NJ');
INSERT INTO `professors` VALUES ('106', 'Nelson Morrison', '3', 'nmorrison@test.com', '111-222-3333', 'Nelson Rd, CT');
INSERT INTO `professors` VALUES ('107', 'Charlie Johnson', '4', 'cjohnson@test.com', '111-222-3333', '40 Jonhnson Cr');
INSERT INTO `professors` VALUES ('108', 'Willy Wonka', '5', 'wWonka@test.com', '111-222-3333', '1272 Wonka Rd');
INSERT INTO `registeredcourse` VALUES ('101', '1010', 'Biology 0', '', '');
INSERT INTO `role` VALUES ('1', 'Admin', 'Administrator');
INSERT INTO `role` VALUES ('2', 'Professor', 'Staff');
INSERT INTO `role` VALUES ('3', 'Student', 'Student');
INSERT INTO `semesterregistration` VALUES ('22', '101', '1', '1', 'Approved');
INSERT INTO `students` VALUES ('101', 'Thomas Parker', '1', 'tparker@test.com', '111-222-3333', 'Parker Ave, NY');
INSERT INTO `students` VALUES ('102', 'Abigail Malik', '2', 'amalik@test.com', '111-222-3333', 'Abigail Ln, NJ');
INSERT INTO `students` VALUES ('103', 'Tej Watkins', '3', 'twatkins@test.com', '111-222-3333', 'Tej Rd, CT');
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `users` VALUES ('101', 'tparker', 'tiger123', '3');
INSERT INTO `users` VALUES ('102', 'amalik', 'shoes123', '3');
INSERT INTO `users` VALUES ('103', 'twatkins', 'ocean123', '3');
INSERT INTO `users` VALUES ('104', 'rwu', 'mountain123', '2');
INSERT INTO `users` VALUES ('105', 'aortega', 'landscape123', '2');
INSERT INTO `users` VALUES ('106', 'nmorrison', 'fountain123', '2');
INSERT INTO `users` VALUES ('107', 'cjohnson', 'grass123', '2');
INSERT INTO `users` VALUES ('108', 'wWonka', 'fire123', '2');
