/*
 Navicat Premium Data Transfer

 Source Server         : 团购小程序
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39-log)
 Source Host           : rm-2ze09g9o0bb02q5r54o.mysql.rds.aliyuncs.com:3306
 Source Schema         : mall-member

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39-log)
 File Encoding         : 65001

 Date: 07/06/2023 00:11:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mm_member
-- ----------------------------
DROP TABLE IF EXISTS `mm_member`;
CREATE TABLE `mm_member`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `member_level_id` bigint(20) UNSIGNED NOT NULL COMMENT '会员等级表',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别 1 男 2 女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `personalized_signature` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `is_enable` int(11) NOT NULL COMMENT '是否启用 1 是 0 否',
  `register_source` int(11) NOT NULL COMMENT '注册来源 1.Web端 2.Android端 3.IOS端 4.PC端',
  `register_data_time` datetime(6) NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_name`(`user_name`) USING BTREE COMMENT '用户名称唯一索引',
  UNIQUE INDEX `idx_phone_number`(`phone_number`) USING BTREE COMMENT '手机号码唯一索引',
  INDEX `fk_member_level_id`(`member_level_id`) USING BTREE COMMENT '会员等级id索引',
  CONSTRAINT `mm_member_ibfk_1` FOREIGN KEY (`member_level_id`) REFERENCES `mm_member_level` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员管理服务-会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mm_member
-- ----------------------------

-- ----------------------------
-- Table structure for mm_member_level
-- ----------------------------
DROP TABLE IF EXISTS `mm_member_level`;
CREATE TABLE `mm_member_level`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `growth_point` int(11) UNSIGNED NOT NULL COMMENT '增长点',
  `comment_growth_point` int(11) UNSIGNED NOT NULL COMMENT '每次评价获取的成长值',
  `is_default_level` int(11) NOT NULL,
  `is_priviledge_free_freight` tinyint(1) UNSIGNED NOT NULL COMMENT '是否有免邮特权',
  `is_priviledge_sign_in` tinyint(1) UNSIGNED NOT NULL COMMENT '是否有签到特权',
  `is_priviledge_comment` tinyint(1) UNSIGNED NOT NULL COMMENT '是否有评论获奖励特权',
  `is_priviledge_promotion` tinyint(1) UNSIGNED NOT NULL COMMENT '是否有专享活动特权',
  `is_priviledge_member_price` tinyint(1) UNSIGNED NOT NULL COMMENT '是否有会员价格特权',
  `is_priviledge_birthday` tinyint(1) UNSIGNED NOT NULL COMMENT '是否有生日特权',
  `free_freight_point` decimal(15, 2) UNSIGNED NOT NULL COMMENT '免运费标准',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员管理服务-会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mm_member_level
-- ----------------------------
INSERT INTO `mm_member_level` VALUES (1, '普通会员', 1, 20, 1, 0, 0, 0, 0, 0, 0, 199.00, '');

-- ----------------------------
-- Table structure for mm_member_login_log
-- ----------------------------
DROP TABLE IF EXISTS `mm_member_login_log`;
CREATE TABLE `mm_member_login_log`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `member_id` bigint(20) UNSIGNED NOT NULL COMMENT '会员id',
  `member_user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员用户名称',
  `ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录所在城市',
  `source` int(11) NULL DEFAULT NULL,
  `create_data_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_member_id`(`member_id`) USING BTREE COMMENT '会员id索引',
  CONSTRAINT `mm_member_login_log_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `mm_member` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员管理服务-会员登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mm_member_login_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
