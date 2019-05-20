/*
Navicat MySQL Data Transfer

Source Server         : vincent
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : db_evaluating_system

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-05-20 21:15:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for table_patient
-- ----------------------------
DROP TABLE IF EXISTS `table_patient`;
CREATE TABLE `table_patient` (
  `patient_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `patient_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `patient_age` int(255) NOT NULL,
  `state_blob` mediumblob NOT NULL,
  `created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for table_permission
-- ----------------------------
DROP TABLE IF EXISTS `table_permission`;
CREATE TABLE `table_permission` (
  `perm_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'permission唯一id',
  `perm_value` varchar(255) NOT NULL DEFAULT '' COMMENT 'shiro权限值',
  `perm_desc` varchar(255) NOT NULL DEFAULT '' COMMENT '权限描述',
  `created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`perm_id`,`perm_value`),
  UNIQUE KEY `perm_value` (`perm_value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_role
-- ----------------------------
DROP TABLE IF EXISTS `table_role`;
CREATE TABLE `table_role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_value` varchar(255) NOT NULL,
  `role_desc` varchar(255) NOT NULL,
  `created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`,`role_value`),
  UNIQUE KEY `role_value` (`role_value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `table_role_permission`;
CREATE TABLE `table_role_permission` (
  `role_id` int(11) DEFAULT NULL,
  `perm_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_user
-- ----------------------------
DROP TABLE IF EXISTS `table_user`;
CREATE TABLE `table_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `password` longtext NOT NULL,
  `salt` longtext CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`account`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for table_user_role
-- ----------------------------
DROP TABLE IF EXISTS `table_user_role`;
CREATE TABLE `table_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
