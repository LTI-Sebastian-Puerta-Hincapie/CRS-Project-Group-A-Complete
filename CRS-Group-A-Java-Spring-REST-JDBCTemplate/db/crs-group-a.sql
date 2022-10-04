/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs-group-a
Target Host: localhost
Target Database: crs-group-a
Date: 9/23/2022 1:30:26 PM
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `CourseId` int(32) NOT NULL auto_increment,
  `CourseName` varchar(32) NOT NULL,
  `Description` varchar(32) NOT NULL,
  PRIMARY KEY  (`CourseId`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DepartmentId` int(32) NOT NULL auto_increment,
  `DepartmentName` varchar(32) NOT NULL,
  `Description` varchar(32) default NULL,
  PRIMARY KEY  (`DepartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `MajorId` int(32) NOT NULL auto_increment,
  `MajorName` varchar(32) NOT NULL,
  `Description` varchar(32) NOT NULL,
  PRIMARY KEY  (`MajorId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for professorcourses
-- ----------------------------
DROP TABLE IF EXISTS `professorcourses`;
CREATE TABLE `professorcourses` (
  `ProfessorId` int(32) NOT NULL,
  `CourseId` int(32) NOT NULL
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registeredcourse
-- ----------------------------
DROP TABLE IF EXISTS `registeredcourse`;
CREATE TABLE `registeredcourse` (
  `StudentId` int(32) NOT NULL,
  `CourseId` int(32) NOT NULL,
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
  `ApprovalStatus` bit(1) NOT NULL,
  `AdminId` int(32) default NULL,
  `Comment` varchar(64) default NULL,
  PRIMARY KEY  (`RegistrationId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'Biology 0', 'Science');
INSERT INTO `course` VALUES ('2', 'Biology 1', 'Science');
INSERT INTO `course` VALUES ('3', 'Biology 2', 'Science');
INSERT INTO `course` VALUES ('4', 'Psychology 0', 'Behavioral Science');
INSERT INTO `course` VALUES ('5', 'Psychology 1', 'Behavioral Science');
INSERT INTO `course` VALUES ('6', 'Psychology 2', 'Behavioral Science');
INSERT INTO `course` VALUES ('7', 'Economics 0', 'Business');
INSERT INTO `course` VALUES ('8', 'Economics 1', 'Business');
INSERT INTO `course` VALUES ('9', 'Economics 2', 'Business');
INSERT INTO `coursecatalog` VALUES ('1', '1', '100', '-', '3', '100', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('2', '1', '100', 'Biology 0', '3', '80', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('3', '1', '100', 'Biology 1', '3', '80', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('4', '2', '200', '-', '3', '100', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('5', '2', '200', 'Psychology 0', '3', '75', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('6', '2', '200', 'Psychology 1', '3', '75', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('7', '3', '300', '-', '3', '50', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('8', '3', '300', 'Economics 0', '3', '50', '0', 'Fall 2022');
INSERT INTO `coursecatalog` VALUES ('9', '3', '300', 'Economics 1', '3', '50', '0', 'Fall 2022');
INSERT INTO `department` VALUES ('1', 'Biology', null);
INSERT INTO `department` VALUES ('2', 'Psychology', null);
INSERT INTO `department` VALUES ('3', 'Economoics', null);
INSERT INTO `major` VALUES ('1', 'Biology', 'Science');
INSERT INTO `major` VALUES ('2', 'Psychology', 'Science');
INSERT INTO `major` VALUES ('3', 'Economics', 'Business');
INSERT INTO `payment` VALUES ('12', '3375', '1', '2022-10-23 00:00:00', 'Fall 2022', 'credit', '');
INSERT INTO `professorcourses` VALUES ('5', '1');
INSERT INTO `professorcourses` VALUES ('5', '2');
INSERT INTO `professorcourses` VALUES ('5', '3');
INSERT INTO `professorcourses` VALUES ('6', '4');
INSERT INTO `professorcourses` VALUES ('6', '5');
INSERT INTO `professorcourses` VALUES ('6', '6');
INSERT INTO `professorcourses` VALUES ('7', '7');
INSERT INTO `professorcourses` VALUES ('7', '8');
INSERT INTO `professorcourses` VALUES ('7', '9');
INSERT INTO `professors` VALUES ('5', 'Rubin Wu', '1', 'rwur@test.com', '111-222-3333', 'Rubin Ave, NY');
INSERT INTO `professors` VALUES ('6', 'Axel Ortega', '2', 'aortega@test.com', '111-222-3333', 'Axel Ln, NJ');
INSERT INTO `professors` VALUES ('7', 'Nelson Morrison', '3', 'nmorrison@test.com', '111-222-3333', 'Nelson Rd, CT');
INSERT INTO `role` VALUES ('1', 'Admin', 'Administrator');
INSERT INTO `role` VALUES ('2', 'Professor', 'Staff');
INSERT INTO `role` VALUES ('3', 'Student', 'Student');
INSERT INTO `semesterregistration` VALUES ('8', '1', '', '1', 'none');
INSERT INTO `students` VALUES ('1', 'Thomas Parker', '1', 'tparker@test.com', '111-222-3333', 'Parker Ave, NY');
INSERT INTO `students` VALUES ('2', 'Abigail Malik', '2', 'amalik@test.com', '111-222-3333', 'Abigail Ln, NJ');
INSERT INTO `students` VALUES ('3', 'Tej Watkins', '3', 'twatkins@test.com', '111-222-3333', 'Tej Rd, CT');
INSERT INTO `users` VALUES ('1', 'tparker', 'lion123', '3');
INSERT INTO `users` VALUES ('2', 'amalik', 'cheese123', '3');
INSERT INTO `users` VALUES ('3', 'twatkins', 'ocean123', '3');
INSERT INTO `users` VALUES ('4', 'test', 'test123', '1');
INSERT INTO `users` VALUES ('5', 'rwu', 'mountain123', '2');
INSERT INTO `users` VALUES ('6', 'aortega', 'landscape123', '2');
INSERT INTO `users` VALUES ('7', 'nmorrison', 'fountain123', '2');
