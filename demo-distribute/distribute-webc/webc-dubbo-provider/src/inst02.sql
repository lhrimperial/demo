/*
Navicat MySQL Data Transfer

Source Server         : 10.112.3.201
Source Server Version : 50616
Source Host           : 10.112.3.201:3306
Source Database       : inst02

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2017-09-13 21:06:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_account_two
-- ----------------------------
DROP TABLE IF EXISTS `tb_account_two`;
CREATE TABLE `tb_account_two` (
  `acct_id` varchar(16) NOT NULL DEFAULT '',
  `amount` double(10,2) DEFAULT NULL,
  `frozen` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`acct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_account_two
-- ----------------------------
INSERT INTO `tb_account_two` VALUES ('2001', '10050.00', '0.00');
