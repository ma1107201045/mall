/*
 Navicat Premium Data Transfer

 Source Server         : rm-2ze09g9o0bb02q5r54o.mysql.rds.aliyuncs.com
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39-log)
 Source Host           : rm-2ze09g9o0bb02q5r54o.mysql.rds.aliyuncs.com:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39-log)
 File Encoding         : 65001

 Date: 24/05/2023 15:23:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mbm_member
-- ----------------------------
DROP TABLE IF EXISTS `mbm_member`;
CREATE TABLE `mbm_member`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `member_level_id` bigint(20) UNSIGNED NOT NULL COMMENT '会员等级表',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '性别：1 男；2 女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `personalized_signature` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `register_source` tinyint(4) UNSIGNED NOT NULL COMMENT '注册来源 1.Web端 2.Android端 3.IOS端 4.PC端',
  `register_data_time` datetime NOT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员管理服务-会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbm_member
-- ----------------------------

-- ----------------------------
-- Table structure for mbm_member_level
-- ----------------------------
DROP TABLE IF EXISTS `mbm_member_level`;
CREATE TABLE `mbm_member_level`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `growth_point` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '增长点',
  `is_default_level` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '是否为默认等级：0->不是；1->是',
  `free_freight_point` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '免运费标准',
  `comment_growth_point` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '每次评价获取的成长值',
  `priviledge_free_freight` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否有免邮特权',
  `priviledge_sign_in` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否有签到特权',
  `priviledge_comment` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否有评论获奖励特权',
  `priviledge_promotion` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否有专享活动特权',
  `priviledge_member_price` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否有会员价格特权',
  `priviledge_birthday` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否有生日特权',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员管理服务-会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbm_member_level
-- ----------------------------

-- ----------------------------
-- Table structure for mbm_member_login_log
-- ----------------------------
DROP TABLE IF EXISTS `mbm_member_login_log`;
CREATE TABLE `mbm_member_login_log`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员id',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录所在城市',
  `source` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '登录来源',
  `create_data_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员管理服务-会员登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbm_member_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for mbp_attribute
-- ----------------------------
DROP TABLE IF EXISTS `mbp_attribute`;
CREATE TABLE `mbp_attribute`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-属性表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbp_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for mbp_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `mbp_attribute_value`;
CREATE TABLE `mbp_attribute_value`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbp_attribute_value
-- ----------------------------

-- ----------------------------
-- Table structure for mbp_brand
-- ----------------------------
DROP TABLE IF EXISTS `mbp_brand`;
CREATE TABLE `mbp_brand`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbp_brand
-- ----------------------------

-- ----------------------------
-- Table structure for mbp_category
-- ----------------------------
DROP TABLE IF EXISTS `mbp_category`;
CREATE TABLE `mbp_category`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbp_category
-- ----------------------------

-- ----------------------------
-- Table structure for mbp_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `mbp_category_attribute`;
CREATE TABLE `mbp_category_attribute`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-分类属性中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbp_category_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for mbp_sku
-- ----------------------------
DROP TABLE IF EXISTS `mbp_sku`;
CREATE TABLE `mbp_sku`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-SKU表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbp_sku
-- ----------------------------

-- ----------------------------
-- Table structure for mbp_spu
-- ----------------------------
DROP TABLE IF EXISTS `mbp_spu`;
CREATE TABLE `mbp_spu`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-SPU表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbp_spu
-- ----------------------------

-- ----------------------------
-- Table structure for mbs_menu
-- ----------------------------
DROP TABLE IF EXISTS `mbs_menu`;
CREATE TABLE `mbs_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `type` tinyint(4) NOT NULL COMMENT '菜单类型 1目录 2 菜单 3 按钮',
  `parent_id` bigint(20) UNSIGNED NOT NULL COMMENT '父级菜单id',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单图标',
  `sort` int(11) UNSIGNED NOT NULL COMMENT '菜单顺序',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '组件路径',
  `component_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '组件名称',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '权限标识',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1 是 0 否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mbs_menu
-- ----------------------------
INSERT INTO `mbs_menu` VALUES (1, '', 3, 0, '', 0, 1, '', '', '', 'mbs:user:save', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', 0);
INSERT INTO `mbs_menu` VALUES (2, '', 3, 0, '', 0, 1, '', '', '', 'mbs:user:remove', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', 0);
INSERT INTO `mbs_menu` VALUES (3, '', 3, 0, '', 0, 1, '', '', '', 'mbs:user:update', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', 0);
INSERT INTO `mbs_menu` VALUES (4, '', 3, 0, '', 0, 1, '', '', '', 'mbs:user:get', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', 0);
INSERT INTO `mbs_menu` VALUES (5, '', 3, 0, '', 0, 1, '', '', '', 'mbs:user:getList', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', 0);

-- ----------------------------
-- Table structure for mbs_role
-- ----------------------------
DROP TABLE IF EXISTS `mbs_role`;
CREATE TABLE `mbs_role`  (
  `id` bigint(11) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `sort` int(11) UNSIGNED NOT NULL COMMENT '顺序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1是 0 否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mbs_role
-- ----------------------------
INSERT INTO `mbs_role` VALUES (1, '', 0, 0, NULL, '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', 0);

-- ----------------------------
-- Table structure for mbs_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `mbs_role_menu`;
CREATE TABLE `mbs_role_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) UNSIGNED NOT NULL COMMENT '菜单id',
  `create_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_menu_id`(`menu_id`) USING BTREE COMMENT '外键按钮id索引',
  INDEX `fk_role_id2`(`role_id`) USING BTREE COMMENT '外键角色id索引',
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `mbs_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_role_id2` FOREIGN KEY (`role_id`) REFERENCES `mbs_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-角色菜单中间表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mbs_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for mbs_user
-- ----------------------------
DROP TABLE IF EXISTS `mbs_user`;
CREATE TABLE `mbs_user`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名称',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '昵称',
  `sex` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '性别 1 男 2 女',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `head_portrait` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `phone_number` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `last_login_ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后登录IP',
  `last_login_date_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1 是 0 否',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_name`(`user_name`) USING BTREE COMMENT '用户名称唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mbs_user
-- ----------------------------
INSERT INTO `mbs_user` VALUES (2434570888750079, 'admin', '', '', NULL, '$2a$10$JrI0QTwZbG5Ijah8fHzVtOStNqpeX88sNX.3T0cKgymqhI7SMk93C', '123', NULL, NULL, NULL, NULL, 1, NULL, 'admin', '2023-05-07 16:13:03', 'admin', '2023-05-20 04:16:55', 0);
INSERT INTO `mbs_user` VALUES (6943878900950016, 'zs', '', '', NULL, '$2a$10$z/e9COEGndIxnhkwUmhiSOdMr8qvAva9nX95nszHodQIawRMCEsjW', NULL, NULL, NULL, NULL, NULL, 1, NULL, 'admin', '2023-05-20 03:52:30', 'admin', '2023-05-20 03:52:30', 0);
INSERT INTO `mbs_user` VALUES (6946154164069376, 'z1s1', '', '', NULL, '$2a$10$OgRyMMcw8UYpgYJhOMg9cey212AbWUgXsVJRN.TaC9p3OPpsJlHJi', '', '', '', NULL, NULL, 1, '', 'admin', '2023-05-20 04:01:28', 'admin', '2023-05-20 04:01:28', 0);
INSERT INTO `mbs_user` VALUES (6946592389145600, 'z1s11', '', '', NULL, '$2a$10$/OUZIqJV2HjZfd3Dt3Agd.6pWH2p4xOVdD3jwzcCNsCqvPNBf6Eqq', '', '', '', NULL, NULL, 1, '', 'admin', '2023-05-20 04:03:17', 'admin', '2023-05-20 04:03:17', 0);
INSERT INTO `mbs_user` VALUES (6948303019254784, '111', '', '', NULL, '$2a$10$T8pAifn4ve1kF0jSBG1mm.CxcK1lqpv/hF74Z4ToKPP.gnlPV5i3W', '', '', '', NULL, NULL, 1, '', 'admin', '2023-05-20 04:10:00', 'admin', '2023-05-20 04:10:00', 0);
INSERT INTO `mbs_user` VALUES (6949309643826176, '11111', '', '', NULL, '$2a$10$rfd9oROKrJ57PEBPCCu5MOkop.eToalFVTwO3DHvYSm6mOrwEzf2a', '', '', '', NULL, NULL, 1, '', 'admin', '2023-05-20 04:14:05', 'admin', '2023-05-20 04:14:05', 0);

-- ----------------------------
-- Table structure for mbs_user_role
-- ----------------------------
DROP TABLE IF EXISTS `mbs_user_role`;
CREATE TABLE `mbs_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  `create_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_id`(`user_id`) USING BTREE COMMENT '外键用户id索引',
  INDEX `fk_role_id`(`role_id`) USING BTREE COMMENT '外键角色id索引',
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `mbs_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `mbs_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-用户角色中间表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mbs_user_role
-- ----------------------------
INSERT INTO `mbs_user_role` VALUES (6943878947087360, 6943878900950016, 1, 'admin', '2023-05-20 03:52:30', 'admin', '2023-05-20 03:52:30');
INSERT INTO `mbs_user_role` VALUES (6946154264732672, 6946154164069376, 1, 'admin', '2023-05-20 04:01:32', 'admin', '2023-05-20 04:01:32');
INSERT INTO `mbs_user_role` VALUES (6946592443671552, 6946592389145600, 1, 'admin', '2023-05-20 04:03:17', 'admin', '2023-05-20 04:03:17');
INSERT INTO `mbs_user_role` VALUES (6948316680102912, 6948303019254784, 1, 'admin', '2023-05-20 04:10:05', 'admin', '2023-05-20 04:10:05');
INSERT INTO `mbs_user_role` VALUES (6949309799015424, 6949309643826176, 1, 'admin', '2023-05-20 04:14:05', 'admin', '2023-05-20 04:14:05');
INSERT INTO `mbs_user_role` VALUES (6950025351472128, 2434570888750079, 1, 'admin', '2023-05-20 04:16:55', 'admin', '2023-05-20 04:16:55');

SET FOREIGN_KEY_CHECKS = 1;
