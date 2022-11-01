/*
MySQL Data Transfer
Source Host: localhost
Source Database: crs-group-a
Target Host: localhost
Target Database: crs-group-a
Date: 11/1/2022 10:13:46 AM
*/

SET FOREIGN_KEY_CHECKS=0;
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
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `users` VALUES ('101', 'tparker', 'tiger123', '3');
INSERT INTO `users` VALUES ('102', 'amalik', 'shoes123', '3');
INSERT INTO `users` VALUES ('103', 'twatkins', 'ocean123', '3');
INSERT INTO `users` VALUES ('104', 'rwu', 'mountain123', '2');
INSERT INTO `users` VALUES ('105', 'aortega', 'landscape123', '2');
INSERT INTO `users` VALUES ('106', 'nmorrison', 'fountain123', '2');
INSERT INTO `users` VALUES ('107', 'cjohnson', 'grass123', '2');
INSERT INTO `users` VALUES ('108', 'wWonka', 'fire123', '2');
INSERT INTO `users` VALUES ('109', 'dDante', 'wood123', '2');
