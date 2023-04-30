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

 Date: 30/04/2023 15:38:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mbs_menu
-- ----------------------------
DROP TABLE IF EXISTS `mbs_menu`;
CREATE TABLE `mbs_menu`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `type` tinyint(4) NOT NULL COMMENT '菜单类型 1目录 2 菜单 3 按钮',
  `parent_id` bigint(20) UNSIGNED NOT NULL COMMENT '父级菜单id',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单图标',
  `sort` int(11) UNSIGNED NOT NULL COMMENT '菜单顺序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '组件路径',
  `component_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '组件名称',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '权限标识',
  `create_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1 是 0 否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbs_menu
-- ----------------------------

-- ----------------------------
-- Table structure for mbs_role
-- ----------------------------
DROP TABLE IF EXISTS `mbs_role`;
CREATE TABLE `mbs_role`  (
  `id` bigint(11) UNSIGNED NOT NULL COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '角色名称',
  `is_enable` tinyint(4) UNSIGNED NOT NULL COMMENT '是否启用 1 是 0 否',
  `sort` int(11) UNSIGNED NOT NULL COMMENT '顺序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '创建人',
  `create_date_time` datetime NOT NULL COMMENT '创建时间',
  `last_modify_by` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '最后修改人',
  `last_modify_date_time` datetime NOT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) UNSIGNED NOT NULL COMMENT '是否删除 1是 0 否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbs_role
-- ----------------------------

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
  UNIQUE INDEX `uk_role_id_menu_id`(`role_id`, `menu_id`) USING BTREE COMMENT '角色id和菜单id唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-角色菜单中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbs_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for mbs_user
-- ----------------------------
DROP TABLE IF EXISTS `mbs_user`;
CREATE TABLE `mbs_user`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键id',
  `user_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名称',
  `real_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '昵称',
  `sex` tinyint(4) UNSIGNED NULL DEFAULT 3 COMMENT '性别 1 男 2 女',
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbs_user
-- ----------------------------

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
  UNIQUE INDEX `uk_user_id_role_id`(`user_id`, `role_id`) USING BTREE COMMENT '用户id和角色id唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统管理-用户角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mbs_user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
