/*
Navicat MySQL Data Transfer

Source Server         : wocao
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : cookbook

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-11-23 00:13:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `user_id` int(11) NOT NULL,
  `cookbook_id` int(11) NOT NULL,
  `comment_inf` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`,`cookbook_id`),
  KEY `cookbook_id` (`cookbook_id`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`cookbook_id`) REFERENCES `cookbook` (`cookbook_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('9', '31', '有意见？');

-- ----------------------------
-- Table structure for `cookbook`
-- ----------------------------
DROP TABLE IF EXISTS `cookbook`;
CREATE TABLE `cookbook` (
  `cookbook_id` int(11) NOT NULL AUTO_INCREMENT,
  `cookbook_likenum` int(11) NOT NULL,
  `cookbook_visitnum` int(11) NOT NULL,
  `cookbook_tip` varchar(500) NOT NULL,
  `cookbook_nutrition` varchar(500) NOT NULL,
  `cookbook_photo` varchar(100) NOT NULL,
  `cookbook_name` varchar(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `cookbook_taste` int(11) NOT NULL,
  `cookbook_cuisine` int(11) NOT NULL,
  `cookbook_occasion` int(11) NOT NULL,
  PRIMARY KEY (`cookbook_id`),
  KEY `user_id` (`user_id`),
  KEY `cookbook_taste` (`cookbook_taste`),
  KEY `cookbook_cuisine` (`cookbook_cuisine`),
  KEY `cookbook_occasion` (`cookbook_occasion`),
  CONSTRAINT `cookbook_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cookbook_ibfk_2` FOREIGN KEY (`cookbook_taste`) REFERENCES `taste` (`taste_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cookbook_ibfk_3` FOREIGN KEY (`cookbook_cuisine`) REFERENCES `cuisine` (`cuisine_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cookbook_ibfk_4` FOREIGN KEY (`cookbook_occasion`) REFERENCES `occasion` (`occasion_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cookbook
-- ----------------------------
INSERT INTO `cookbook` VALUES ('31', '1', '1', '精神科', 'MM', '测试2019-10-25-16-10-44.png', '测试', '9', '3', '8', '3');
INSERT INTO `cookbook` VALUES ('32', '0', '1', '爸爸爸', '失敬失敬', '测试22019-10-25-16-12-07.png', '测试2', '9', '2', '1', '2');
INSERT INTO `cookbook` VALUES ('33', '0', '1', '就是计算机', '手机啥叫', '测试32019-10-25-16-12-44.png', '测试3', '9', '2', '4', '2');
INSERT INTO `cookbook` VALUES ('34', '0', '0', '今生今世', '是那你说你是', '测试42019-10-25-16-13-20.png', '测试4', '9', '3', '7', '2');
INSERT INTO `cookbook` VALUES ('35', '0', '1', '就是就是计算机', '男是男是女', '测试52019-10-25-16-14-11.png', '测试5', '9', '1', '2', '1');

-- ----------------------------
-- Table structure for `cuisine`
-- ----------------------------
DROP TABLE IF EXISTS `cuisine`;
CREATE TABLE `cuisine` (
  `cuisine_id` int(11) NOT NULL AUTO_INCREMENT,
  `cuisine_name` varchar(20) NOT NULL,
  PRIMARY KEY (`cuisine_id`,`cuisine_name`),
  KEY `cuisine_id` (`cuisine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cuisine
-- ----------------------------
INSERT INTO `cuisine` VALUES ('1', '浙菜');
INSERT INTO `cuisine` VALUES ('2', '湘菜');
INSERT INTO `cuisine` VALUES ('3', '粤菜');
INSERT INTO `cuisine` VALUES ('4', '闽菜');
INSERT INTO `cuisine` VALUES ('5', '鲁菜');
INSERT INTO `cuisine` VALUES ('6', '徽菜');
INSERT INTO `cuisine` VALUES ('7', '淮扬菜');
INSERT INTO `cuisine` VALUES ('8', '川菜');

-- ----------------------------
-- Table structure for `ingredint`
-- ----------------------------
DROP TABLE IF EXISTS `ingredint`;
CREATE TABLE `ingredint` (
  `cookbook_id` int(11) NOT NULL,
  `ingredint_name` varchar(20) NOT NULL,
  `ingredint_num` varchar(20) NOT NULL,
  KEY `cookbook_id` (`cookbook_id`),
  CONSTRAINT `ingredint_ibfk_1` FOREIGN KEY (`cookbook_id`) REFERENCES `cookbook` (`cookbook_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ingredint
-- ----------------------------
INSERT INTO `ingredint` VALUES ('31', '安娜', '100g');
INSERT INTO `ingredint` VALUES ('31', '是那你说', '100g');
INSERT INTO `ingredint` VALUES ('32', '安娜', '100g');
INSERT INTO `ingredint` VALUES ('32', '是男是女', '200g');
INSERT INTO `ingredint` VALUES ('33', '啊哈哈', '1000g');
INSERT INTO `ingredint` VALUES ('34', '没什么事', '200g');
INSERT INTO `ingredint` VALUES ('35', '计算机', '1000g');

-- ----------------------------
-- Table structure for `likes`
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `user_id` int(11) NOT NULL,
  `cookbook_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`cookbook_id`),
  KEY `cookbook_id` (`cookbook_id`),
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`cookbook_id`) REFERENCES `cookbook` (`cookbook_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `likes_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES ('9', '31');

-- ----------------------------
-- Table structure for `occasion`
-- ----------------------------
DROP TABLE IF EXISTS `occasion`;
CREATE TABLE `occasion` (
  `occasion_id` int(11) NOT NULL AUTO_INCREMENT,
  `occasion_name` varchar(20) NOT NULL,
  PRIMARY KEY (`occasion_id`,`occasion_name`),
  KEY `occasion_id` (`occasion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of occasion
-- ----------------------------
INSERT INTO `occasion` VALUES ('1', '快餐店');
INSERT INTO `occasion` VALUES ('2', '饭店');
INSERT INTO `occasion` VALUES ('3', '家');

-- ----------------------------
-- Table structure for `step`
-- ----------------------------
DROP TABLE IF EXISTS `step`;
CREATE TABLE `step` (
  `cookbook_id` int(11) NOT NULL,
  `step_inf` varchar(500) NOT NULL,
  KEY `cookbook_id` (`cookbook_id`),
  CONSTRAINT `step_ibfk_1` FOREIGN KEY (`cookbook_id`) REFERENCES `cookbook` (`cookbook_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of step
-- ----------------------------
INSERT INTO `step` VALUES ('31', '设计师');
INSERT INTO `step` VALUES ('32', '你是男');
INSERT INTO `step` VALUES ('32', '不是男是女');
INSERT INTO `step` VALUES ('33', '你自己');
INSERT INTO `step` VALUES ('34', '数据集市');
INSERT INTO `step` VALUES ('35', '不是说你的');

-- ----------------------------
-- Table structure for `taste`
-- ----------------------------
DROP TABLE IF EXISTS `taste`;
CREATE TABLE `taste` (
  `taste_id` int(11) NOT NULL AUTO_INCREMENT,
  `taste_name` varchar(20) NOT NULL,
  PRIMARY KEY (`taste_id`,`taste_name`),
  KEY `taste_id` (`taste_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taste
-- ----------------------------
INSERT INTO `taste` VALUES ('1', '酸');
INSERT INTO `taste` VALUES ('2', '辣');
INSERT INTO `taste` VALUES ('3', '清淡');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(30) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_taste` int(11) NOT NULL,
  `user_cuisine` int(11) NOT NULL,
  `user_occasion` int(11) NOT NULL,
  `user_photo` varchar(100) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_address` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_cuisine` (`user_cuisine`),
  KEY `user_taste` (`user_taste`),
  KEY `user_occasion` (`user_occasion`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`user_cuisine`) REFERENCES `cuisine` (`cuisine_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_ibfk_3` FOREIGN KEY (`user_taste`) REFERENCES `taste` (`taste_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_ibfk_4` FOREIGN KEY (`user_occasion`) REFERENCES `occasion` (`occasion_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('9', '15920136076', '433524091682000a1c1278823ab3b857', '2', '8', '3', '15920136076.png', '智轩', '广东 清远');

-- ----------------------------
-- Table structure for `visit`
-- ----------------------------
DROP TABLE IF EXISTS `visit`;
CREATE TABLE `visit` (
  `user_id` int(11) NOT NULL,
  `cookbook_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`cookbook_id`),
  KEY `cookbook_id` (`cookbook_id`),
  CONSTRAINT `visit_ibfk_2` FOREIGN KEY (`cookbook_id`) REFERENCES `cookbook` (`cookbook_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `visit_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visit
-- ----------------------------
INSERT INTO `visit` VALUES ('9', '31');
INSERT INTO `visit` VALUES ('9', '32');
INSERT INTO `visit` VALUES ('9', '33');
INSERT INTO `visit` VALUES ('9', '35');
