/*
 Navicat Premium Data Transfer

 Source Server         : 团购小程序
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39-log)
 Source Host           : rm-2ze09g9o0bb02q5r54o.mysql.rds.aliyuncs.com:3306
 Source Schema         : mall-system

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39-log)
 File Encoding         : 65001

 Date: 07/06/2023 00:10:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ms_log
-- ----------------------------
DROP TABLE IF EXISTS `ms_log`;
CREATE TABLE `ms_log`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标题',
  `operation_type` tinyint(4) NULL DEFAULT NULL COMMENT '操作类型 1.创建 2.删除 3.更改 4.读取 5.其他',
  `call_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '调用类名',
  `call_method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '调用方法',
  `request_param` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `execute_duration` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '执行时长 单位ms',
  `execute_result` tinyint(4) NULL DEFAULT 1 COMMENT '执行结果 1 成功 0 失败',
  `response_param` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `fail_reason` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '失败原因',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime(6) NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime(6) NOT NULL COMMENT '最后修改时间',
  `client_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '客户端ip',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_log
-- ----------------------------
INSERT INTO `ms_log` VALUES (13007827396273152, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13008103138206720, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13008664394802176, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13009015298663424, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13009357054747648, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13009973281891328, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13010910704641024, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13011864803943424, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13013084151030784, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');
INSERT INTO `ms_log` VALUES (13013318201582592, '', NULL, '', '', '', NULL, 1, '', '', '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', '');

-- ----------------------------
-- Table structure for ms_menu
-- ----------------------------
DROP TABLE IF EXISTS `ms_menu`;
CREATE TABLE `ms_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) UNSIGNED NOT NULL COMMENT '父级菜单id',
  `type` tinyint(11) UNSIGNED NOT NULL COMMENT '菜单类型',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单图标',
  `sort` int(11) UNSIGNED NOT NULL COMMENT '菜单顺序',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '组件路径',
  `component_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '组件路径',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '按钮权限标识',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime(6) NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime(6) NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1是 0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_menu
-- ----------------------------
INSERT INTO `ms_menu` VALUES (1, '', 0, 0, '', 0, '', '', '', 'mbs:user:save', 0, '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', 0);
INSERT INTO `ms_menu` VALUES (2, '', 0, 0, '', 0, '', '', '', 'mbs:user:remove', 0, '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', 0);
INSERT INTO `ms_menu` VALUES (3, '', 0, 0, '', 0, '', '', '', 'mbs:user:update', 0, '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', 0);
INSERT INTO `ms_menu` VALUES (4, '', 0, 0, '', 0, '', '', '', 'mbs:user:get', 0, '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', 0);
INSERT INTO `ms_menu` VALUES (5, '', 0, 0, '', 0, '', '', '', 'mbs:user:getList', 0, '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', 0);

-- ----------------------------
-- Table structure for ms_role
-- ----------------------------
DROP TABLE IF EXISTS `ms_role`;
CREATE TABLE `ms_role`  (
  `id` bigint(11) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `sort` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '角色顺序',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime(6) NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime(6) NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1是 0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_role
-- ----------------------------
INSERT INTO `ms_role` VALUES (1, '', NULL, 0, '', '', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000', 0);

-- ----------------------------
-- Table structure for ms_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `ms_role_menu`;
CREATE TABLE `ms_role_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) UNSIGNED NOT NULL COMMENT '菜单id',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime(6) NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime(6) NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_menu_id`(`menu_id`) USING BTREE,
  INDEX `fk_role_id2`(`role_id`) USING BTREE,
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `ms_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_role_id2` FOREIGN KEY (`role_id`) REFERENCES `ms_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-角色菜单中间表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for ms_user
-- ----------------------------
DROP TABLE IF EXISTS `ms_user`;
CREATE TABLE `ms_user`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名称',
  `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `sex` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '性别 1 男 2 女',
  `head_portrait` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号',
  `last_login_ip` int(30) NULL DEFAULT NULL COMMENT '手机号',
  `is_enable` tinyint(4) NOT NULL COMMENT '是否启用 1 是 0 否',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime(6) NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime(6) NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1是 0否',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_user
-- ----------------------------
INSERT INTO `ms_user` VALUES (2434570888750079, 'admin', '', '', '$2a$10$JrI0QTwZbG5Ijah8fHzVtOStNqpeX88sNX.3T0cKgymqhI7SMk93C', NULL, '123', NULL, NULL, NULL, 0, NULL, 'admin', '2023-05-07 16:13:03.000000', 'admin', '2023-05-20 04:16:55.000000', 0);
INSERT INTO `ms_user` VALUES (6943878900950016, 'zs', '', '', '$2a$10$z/e9COEGndIxnhkwUmhiSOdMr8qvAva9nX95nszHodQIawRMCEsjW', NULL, NULL, NULL, NULL, NULL, 0, NULL, 'admin', '2023-05-20 03:52:30.000000', 'admin', '2023-05-20 03:52:30.000000', 0);
INSERT INTO `ms_user` VALUES (6946154164069376, 'z1s1', '', '', '$2a$10$OgRyMMcw8UYpgYJhOMg9cey212AbWUgXsVJRN.TaC9p3OPpsJlHJi', NULL, '', '', '', NULL, 0, '', 'admin', '2023-05-20 04:01:28.000000', 'admin', '2023-05-20 04:01:28.000000', 0);
INSERT INTO `ms_user` VALUES (6946592389145600, 'z1s11', '', '', '$2a$10$/OUZIqJV2HjZfd3Dt3Agd.6pWH2p4xOVdD3jwzcCNsCqvPNBf6Eqq', NULL, '', '', '', NULL, 0, '', 'admin', '2023-05-20 04:03:17.000000', 'admin', '2023-05-20 04:03:17.000000', 0);
INSERT INTO `ms_user` VALUES (6948303019254784, '111', '', '', '$2a$10$T8pAifn4ve1kF0jSBG1mm.CxcK1lqpv/hF74Z4ToKPP.gnlPV5i3W', NULL, '', '', '', NULL, 0, '', 'admin', '2023-05-20 04:10:00.000000', 'admin', '2023-05-20 04:10:00.000000', 0);
INSERT INTO `ms_user` VALUES (6949309643826176, '11111', '', '', '$2a$10$rfd9oROKrJ57PEBPCCu5MOkop.eToalFVTwO3DHvYSm6mOrwEzf2a', NULL, '', '', '', NULL, 0, '', 'admin', '2023-05-20 04:14:05.000000', 'admin', '2023-05-20 04:14:05.000000', 0);

-- ----------------------------
-- Table structure for ms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `ms_user_role`;
CREATE TABLE `ms_user_role`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime(6) NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime(6) NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_id`(`user_id`) USING BTREE,
  INDEX `fk_role_id`(`role_id`) USING BTREE,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `ms_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `ms_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理服务-用户角色中间表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_user_role
-- ----------------------------
INSERT INTO `ms_user_role` VALUES (6943878947087360, 6943878900950016, 1, 'admin', '2023-05-20 03:52:30.000000', 'admin', '2023-05-20 03:52:30.000000');
INSERT INTO `ms_user_role` VALUES (6946154264732672, 6946154164069376, 1, 'admin', '2023-05-20 04:01:32.000000', 'admin', '2023-05-20 04:01:32.000000');
INSERT INTO `ms_user_role` VALUES (6946592443671552, 6946592389145600, 1, 'admin', '2023-05-20 04:03:17.000000', 'admin', '2023-05-20 04:03:17.000000');
INSERT INTO `ms_user_role` VALUES (6948316680102912, 6948303019254784, 1, 'admin', '2023-05-20 04:10:05.000000', 'admin', '2023-05-20 04:10:05.000000');
INSERT INTO `ms_user_role` VALUES (6949309799015424, 6949309643826176, 1, 'admin', '2023-05-20 04:14:05.000000', 'admin', '2023-05-20 04:14:05.000000');
INSERT INTO `ms_user_role` VALUES (6950025351472128, 2434570888750079, 1, 'admin', '2023-05-20 04:16:55.000000', 'admin', '2023-05-20 04:16:55.000000');

SET FOREIGN_KEY_CHECKS = 1;
