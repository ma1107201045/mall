/*
 Navicat Premium Data Transfer

 Source Server         : 团购小程序
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39-log)
 Source Host           : rm-2ze09g9o0bb02q5r54o.mysql.rds.aliyuncs.com:3306
 Source Schema         : mall-product

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39-log)
 File Encoding         : 65001

 Date: 07/06/2023 00:11:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mp_attribute
-- ----------------------------
DROP TABLE IF EXISTS `mp_attribute`;
CREATE TABLE `mp_attribute`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-属性表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for mp_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `mp_attribute_value`;
CREATE TABLE `mp_attribute_value`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-属性值表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_attribute_value
-- ----------------------------

-- ----------------------------
-- Table structure for mp_brand
-- ----------------------------
DROP TABLE IF EXISTS `mp_brand`;
CREATE TABLE `mp_brand`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_brand
-- ----------------------------

-- ----------------------------
-- Table structure for mp_category
-- ----------------------------
DROP TABLE IF EXISTS `mp_category`;
CREATE TABLE `mp_category`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_category
-- ----------------------------

-- ----------------------------
-- Table structure for mp_category_attribute
-- ----------------------------
DROP TABLE IF EXISTS `mp_category_attribute`;
CREATE TABLE `mp_category_attribute`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-分类属性中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_category_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for mp_sku
-- ----------------------------
DROP TABLE IF EXISTS `mp_sku`;
CREATE TABLE `mp_sku`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-SKU表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_sku
-- ----------------------------

-- ----------------------------
-- Table structure for mp_spu
-- ----------------------------
DROP TABLE IF EXISTS `mp_spu`;
CREATE TABLE `mp_spu`  (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `business_id` bigint(20) NULL DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品管理服务-SPU表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mp_spu
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
