/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : frame

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-09-08 17:39:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `pass_word` varchar(100) NOT NULL,
  `mobile_no` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('1', 'andy', '123456', '12340599896', 'lhr9563215@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('2', 'hello_0', '123456', '13640590000', '136000@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('3', 'hello_1', '123456', '13640590001', '136001@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('4', 'hello_2', '123456', '13640590002', '136002@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('5', 'hello_3', '123456', '13640590003', '136003@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('6', 'hello_4', '123456', '13640590004', '136004@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('7', 'hello_5', '123456', '13640590005', '136005@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('8', 'hello_6', '123456', '13640590006', '136006@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('9', 'hello_7', '123456', '13640590007', '136007@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('10', 'hello_8', '123456', '13640590008', '136008@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('11', 'hello_9', '123456', '13640590009', '136009@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('12', 'hello_10', '123456', '13640590010', '136010@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('13', 'hello_11', '123456', '13640590011', '136011@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('14', 'hello_12', '123456', '13640590012', '136012@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('15', 'hello_13', '123456', '13640590013', '136013@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('16', 'hello_14', '123456', '13640590014', '136014@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('17', 'hello_15', '123456', '13640590015', '136015@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('18', 'hello_16', '123456', '13640590016', '136016@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('19', 'hello_17', '123456', '13640590017', '136017@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('20', 'hello_18', '123456', '13640590018', '136018@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('21', 'hello_19', '123456', '13640590019', '136019@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('22', 'hello_20', '123456', '13640590020', '136020@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('23', 'hello_21', '123456', '13640590021', '136021@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('24', 'hello_22', '123456', '13640590022', '136022@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('25', 'hello_23', '123456', '13640590023', '136023@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('26', 'hello_24', '123456', '13640590024', '136024@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('27', 'hello_25', '123456', '13640590025', '136025@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('28', 'hello_26', '123456', '13640590026', '136026@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('29', 'hello_27', '123456', '13640590027', '136027@163.com', 'female');
INSERT INTO `t_user_info` VALUES ('30', 'hello_28', '123456', '13640590028', '136028@163.com', 'male');
INSERT INTO `t_user_info` VALUES ('31', 'hello_29', '123456', '13640590029', '136029@163.com', 'female');
