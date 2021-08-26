/*
 Navicat Premium Data Transfer

 Source Server         : Nay
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : data_tzs_bx

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 25/08/2021 18:40:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_menu
-- ----------------------------
DROP TABLE IF EXISTS `my_menu`;
CREATE TABLE `my_menu`  (
  `menu_id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `parent_id` int(32) NOT NULL COMMENT '父级菜单id',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `sort` int(12) NULL DEFAULT NULL COMMENT '排序',
  `type` tinyint(1) NOT NULL COMMENT '类型',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 152 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of my_menu
-- ----------------------------
INSERT INTO `my_menu` VALUES (3, 0, '系统管理', 'layui-icon layui-icon-set-fill', '', 'system:user', 3, 0, '2021-08-23 23:15:46', '2020-07-12 21:03:22');
INSERT INTO `my_menu` VALUES (4, 3, '人员列表', 'layui-icon layui-icon layui-icon layui-icon layui-icon-username', 'pc/user/index', 'user:list', 1, 1, '2021-08-23 23:15:46', '2021-03-15 10:32:05');
INSERT INTO `my_menu` VALUES (6, 3, '菜单管理', 'layui-icon layui-icon-vercode', 'pc/menu/index', 'menu:list', 6, 1, '2021-08-23 23:15:46', '2020-07-10 09:34:53');
INSERT INTO `my_menu` VALUES (92, 0, '报装中心', 'layui-icon layui-icon layui-icon layui-icon-component', '', '', 1, 0, '2021-08-23 23:15:46', '2021-05-11 18:18:13');
INSERT INTO `my_menu` VALUES (96, 92, '报装列表', 'layui-icon layui-icon layui-icon layui-icon-cellphone', 'pc/verify/index', '', 1, 1, '2021-08-23 23:15:46', '2021-05-11 18:09:54');

-- ----------------------------
-- Table structure for my_role
-- ----------------------------
DROP TABLE IF EXISTS `my_role`;
CREATE TABLE `my_role`  (
  `role_id` int(32) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of my_role
-- ----------------------------
INSERT INTO `my_role` VALUES (1, '管理员', '拥有所有权限', '2021-08-23 09:40:35', '2021-08-23 09:40:35', '1');
INSERT INTO `my_role` VALUES (2, '用户', '审核', '2021-08-23 14:32:04', '2021-08-23 14:32:04', '4');

-- ----------------------------
-- Table structure for my_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `my_role_menu`;
CREATE TABLE `my_role_menu`  (
  `role_id` int(32) NOT NULL COMMENT '角色id',
  `menu_id` int(32) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of my_role_menu
-- ----------------------------
INSERT INTO `my_role_menu` VALUES (1, 3);
INSERT INTO `my_role_menu` VALUES (1, 4);
INSERT INTO `my_role_menu` VALUES (1, 6);
INSERT INTO `my_role_menu` VALUES (1, 92);
INSERT INTO `my_role_menu` VALUES (1, 96);
INSERT INTO `my_role_menu` VALUES (2, 92);
INSERT INTO `my_role_menu` VALUES (2, 96);

-- ----------------------------
-- Table structure for my_role_user
-- ----------------------------
DROP TABLE IF EXISTS `my_role_user`;
CREATE TABLE `my_role_user`  (
  `user_id` int(32) NOT NULL COMMENT '用户id',
  `role_id` int(32) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of my_role_user
-- ----------------------------
INSERT INTO `my_role_user` VALUES (1, 1);
INSERT INTO `my_role_user` VALUES (419, 2);

-- ----------------------------
-- Table structure for my_user
-- ----------------------------
DROP TABLE IF EXISTS `my_user`;
CREATE TABLE `my_user`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id值',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `status` tinyint(1) NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录IP',
  `login_times` bigint(11) NULL DEFAULT NULL COMMENT '登录次数',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `is_del` int(1) NULL DEFAULT NULL COMMENT '是否删除 0 否 1 是',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 422 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of my_user
-- ----------------------------
INSERT INTO `my_user` VALUES (1, 'admin', '$2a$10$DKnVhm/T4CrJTyb.K18HeeLHEC.7uvEpwAuFOxJNUNgZUeOo0QsRy', 'admin', '18173516309', 1, '2021-08-23 09:42:03', '2021-08-25 18:19:18', NULL, '10.43.1.1', 296, '暂无地址', 0);
INSERT INTO `my_user` VALUES (153, '周璐', '$2a$10$DKnVhm/T4CrJTyb.K18HeeLHEC.7uvEpwAuFOxJNUNgZUeOo0QsRy', '周璐', '18565852266', 1, '2021-08-22 10:42:31', '2021-08-25 18:14:24', '2021-04-25 20:31:06', '42.49.174.51', 1610, '五岭阁', 0);
INSERT INTO `my_user` VALUES (154, '林光亮', '$2a$10$0mR8uLyas9bC8F15sH/WtuZQxq6MJjjvLgnFQEHAZHZvC.15CVjra', '林光亮', '13047223392', 1, '2021-08-22 10:44:15', '2021-08-25 17:16:16', '2021-04-25 20:43:30', '8.129.184.128', 970, '高亭司高冲村19组', 0);

-- ----------------------------
-- Table structure for newspaper
-- ----------------------------
DROP TABLE IF EXISTS `newspaper`;
CREATE TABLE `newspaper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_time` datetime(0) NULL DEFAULT NULL,
  `project_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `contact_person` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `contact_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `detailed_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '联系地址',
  `applicant` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '申请单位',
  `newspaper_type` int(11) NULL DEFAULT NULL COMMENT '报装类型 0个人或生产经营单位客户新装 1新建住宅小区新装 2一户一表改造 3水表迁移工程 4临时水安装工程',
  `type_of_water` int(11) NULL DEFAULT NULL COMMENT '用水类型 1居民 0非居民',
  `number_of_water_users` int(11) NULL DEFAULT NULL COMMENT '用水户数',
  `estimated_amount_of_water` decimal(11, 0) NULL DEFAULT NULL COMMENT '估计水量',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `material` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '资料地址',
  `verification` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '状态 0 已提交 1受理中 2已完结 3已退回',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newspaper
-- ----------------------------
INSERT INTO `newspaper` VALUES (10, '2021-08-23 00:00:00', 'test', 'rr', '18173516309', '长沙雨花区', '四时生生', 1, 1, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '1', '3');
INSERT INTO `newspaper` VALUES (11, '2021-08-23 00:00:00', 'test', 'lsl', '123', '长沙雨花区', '四时生生', 1, 1, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '2', '2');
INSERT INTO `newspaper` VALUES (12, '2021-08-23 00:00:00', 'test', 'hh', '18173516309', '长沙雨花区', '四时生生', 1, 1, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '3', '1');
INSERT INTO `newspaper` VALUES (13, '2021-08-23 00:00:00', 'test', 'lsl', '18173516309', '长沙雨花区', '四时生生', 1, 1, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '4', '2');

SET FOREIGN_KEY_CHECKS = 1;
