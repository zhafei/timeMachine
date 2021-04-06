/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1 by root
 Source Server Type    : MySQL
 Source Server Version : 50645
 Source Host           : 127.0.0.1:3306
 Source Schema         : time-machine

 Target Server Type    : MySQL
 Target Server Version : 50645
 File Encoding         : 65001

 Date: 06/04/2021 10:41:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ums_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_sys_menu`;
CREATE TABLE `ums_sys_menu`  (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `css` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_menu` int(11) NULL DEFAULT NULL COMMENT '是否菜单 1 是 2 不是',
  `hidden` int(11) NULL DEFAULT NULL COMMENT '是否隐藏,0 false 1 true',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_sys_menu
-- ----------------------------
INSERT INTO `ums_sys_menu` VALUES (1305129588359168, 0, '系统管理', '#;', '/', '/', 0, '2021-04-04 14:26:07', '2021-04-04 14:26:07', 0, 0);
INSERT INTO `ums_sys_menu` VALUES (1305914338443264, 0, '系统管理', '#;', '/', '/', 0, '2021-04-04 14:29:14', '2021-04-04 14:29:14', 0, 0);
INSERT INTO `ums_sys_menu` VALUES (1306039924293632, 0, '系统管理', '#;', '/', '/', 0, '2021-04-04 14:29:44', '2021-04-04 14:29:44', 0, 0);
INSERT INTO `ums_sys_menu` VALUES (1306513213751296, 0, '系统管理', '#;', '/', '/', 0, '2021-04-04 14:31:37', '2021-04-04 14:31:37', 0, 0);

-- ----------------------------
-- Table structure for ums_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `ums_sys_permission`;
CREATE TABLE `ums_sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `permission`(`permission`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for ums_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_sys_role`;
CREATE TABLE `ums_sys_role`  (
  `id` bigint(20) NOT NULL,
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_role_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for ums_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `ums_sys_role_menu`;
CREATE TABLE `ums_sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for ums_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `ums_sys_role_user`;
CREATE TABLE `ums_sys_role_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_sys_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for ums_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `ums_sys_user`;
CREATE TABLE `ums_sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `head_img_url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否激活',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ums_sys_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
