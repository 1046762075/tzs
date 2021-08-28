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

 Date: 28/08/2021 17:35:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '客户名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '地址',
  `handler` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '办理人',
  `mobile_telephone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '移动电话',
  `fixed_telephone` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '固定电话',
  `id_card` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份证号',
  `tax_number` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '税号',
  `verification` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `application_coding` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '申请编码',
  `material_one` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '材料一',
  `material_two` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '材料二',
  `material_three` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '材料三',
  `status` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '状态 0 已提交 1 审核中 2 已完成  3 已驳回',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '开户时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '2', '2', '2', '2', '2', '2', '2', '18173516309', '2', 'https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', 'https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '1', '2021-08-27 19:50:14');
INSERT INTO `customer` VALUES (2, 'FILA 斐乐女鞋专柜正品2020秋季新款复古运动鞋老爹鞋F12W034120', '1', '1', '1', '1', '1', '1', '18173516309', '20210828458', 'https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', 'https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '1', '2021-08-28 11:17:19');
INSERT INTO `customer` VALUES (3, '11', '1', '1', '1', '1', '1', '1', '18173516309', '20210828534', 'https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', 'https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '1', '2021-08-28 12:11:30');
INSERT INTO `customer` VALUES (4, 'FILA 斐乐女鞋专柜正品2020秋季', '哇', '1da我', '哎喂d', '哎喂', '', '', '123', '20210828957', 'https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', 'https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825', '1', '2021-08-28 12:21:42');

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
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of my_menu
-- ----------------------------
INSERT INTO `my_menu` VALUES (1, 0, '业务办理', 'layui-icon layui-icon layui-icon layui-icon-component', '', '', 1, 0, '2021-08-23 23:15:46', '2021-05-11 18:18:13');
INSERT INTO `my_menu` VALUES (3, 0, '系统管理', 'layui-icon layui-icon-set-fill', '', 'system:user', 3, 0, '2021-08-23 23:15:46', '2020-07-12 21:03:22');
INSERT INTO `my_menu` VALUES (4, 3, '人员列表', 'layui-icon layui-icon layui-icon layui-icon layui-icon-username', 'pc/user/index', 'user:list', 1, 1, '2021-08-23 23:15:46', '2021-03-15 10:32:05');
INSERT INTO `my_menu` VALUES (5, 1, '报装列表', 'layui-icon layui-icon layui-icon layui-icon-cellphone', 'pc/verify/newspaper/index', '', 1, 1, '2021-08-23 23:15:46', '2021-05-11 18:09:54');
INSERT INTO `my_menu` VALUES (6, 3, '菜单管理', 'layui-icon layui-icon-vercode', 'pc/menu/index', 'menu:list', 6, 1, '2021-08-23 23:15:46', '2020-07-10 09:34:53');
INSERT INTO `my_menu` VALUES (7, 1, '开户列表', 'layui-icon layui-icon layui-icon layui-icon-cellphone', 'pc/verify/openAnAccount/index', '', 2, 1, '2021-08-23 23:15:46', '2021-05-11 18:09:54');

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

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
INSERT INTO `my_role_menu` VALUES (1, 1);
INSERT INTO `my_role_menu` VALUES (1, 3);
INSERT INTO `my_role_menu` VALUES (1, 4);
INSERT INTO `my_role_menu` VALUES (1, 5);
INSERT INTO `my_role_menu` VALUES (1, 6);
INSERT INTO `my_role_menu` VALUES (1, 7);
INSERT INTO `my_role_menu` VALUES (2, 1);
INSERT INTO `my_role_menu` VALUES (2, 5);

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
INSERT INTO `my_role_user` VALUES (2, 2);
INSERT INTO `my_role_user` VALUES (3, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of my_user
-- ----------------------------
INSERT INTO `my_user` VALUES (1, 'admin', '$2a$10$DKnVhm/T4CrJTyb.K18HeeLHEC.7uvEpwAuFOxJNUNgZUeOo0QsRy', 'admin', '18173516309', 1, '2021-08-23 09:42:03', '2021-08-25 18:19:18', NULL, '10.43.1.1', 296, '暂无地址', 0);
INSERT INTO `my_user` VALUES (2, '周璐', '$2a$10$DKnVhm/T4CrJTyb.K18HeeLHEC.7uvEpwAuFOxJNUNgZUeOo0QsRy', '周璐', '18565852266', 1, '2021-08-22 10:42:31', '2021-08-25 18:14:24', '2021-04-25 20:31:06', '42.49.174.51', 1610, '五岭阁', 0);
INSERT INTO `my_user` VALUES (3, '林光亮', '$2a$10$0mR8uLyas9bC8F15sH/WtuZQxq6MJjjvLgnFQEHAZHZvC.15CVjra', '林光亮', '13047223392', 1, '2021-08-22 10:44:15', '2021-08-25 17:16:16', '2021-04-25 20:43:30', '8.129.184.128', 970, '高亭司高冲村19组', 0);

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
  `material` varchar(1500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '资料地址',
  `verification` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '状态 0 已提交 1受理中 2已完结 3已退回',
  `application_coding` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '申请编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of newspaper
-- ----------------------------
INSERT INTO `newspaper` VALUES (10, '2021-08-23 00:00:00', 'test', 'rr', '18173516309', '长沙雨花区', '四时生生', 1, 1, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '1', '3', '2222');
INSERT INTO `newspaper` VALUES (11, '2021-08-23 00:00:00', 'test', 'lsl', '123', '长沙雨花区', '四时生生', 2, 1, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '2', '2', '1');
INSERT INTO `newspaper` VALUES (12, '2021-08-23 00:00:00', 'test', 'hh', '18173516309', '长沙雨花区', '四时生生', 4, 2, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '1', '1');
INSERT INTO `newspaper` VALUES (13, '2021-08-23 00:00:00', 'test', 'lsl', '18173516309', '长沙雨花区', '四时生生', 1, 1, 10, 54, NULL, 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '2', '1');
INSERT INTO `newspaper` VALUES (41, '2021-08-27 09:05:07', '1', '1', '1', '1', '1', 0, 2, 1, 1, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '0', '1');
INSERT INTO `newspaper` VALUES (51, '2021-08-27 17:15:36', '阿瓦达123', '2 ', '3 ', '3 ', '我', 4, 2, 111, 12, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '0', '2021082717153584');
INSERT INTO `newspaper` VALUES (52, '2021-08-27 17:16:09', '阿瓦达123', '我啊', '3 我', '3 我', '我我', 0, 1, 111, 12, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '0', '20210827171608158');
INSERT INTO `newspaper` VALUES (53, '2021-08-27 17:16:55', '阿瓦达123', '我啊', '3 我', '3 我', '我我', 2, 1, 111, 12, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '1', '20210827171655469');
INSERT INTO `newspaper` VALUES (54, '2021-08-27 17:17:30', '阿瓦达123', '我啊', '3 我', '3 我', '我我', 0, 2, 111, 12, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '0', '20210827171729634');
INSERT INTO `newspaper` VALUES (55, '2021-08-27 17:20:22', '阿瓦达', '123', '哎喂', '哇', '我', 3, 1, 11, 111, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '12', '0', '20210827172022911');
INSERT INTO `newspaper` VALUES (56, '2021-08-27 17:22:56', '有意思', '晋级赛', '1557334612', 'URH很费劲的', '就放假大家', 0, 1, 11, 1212, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '2', '20210827172255233');
INSERT INTO `newspaper` VALUES (57, '2021-08-28 11:32:21', '1', '1', '1', '1', '2', 0, 1, 2, 2, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '1', '20210828868');
INSERT INTO `newspaper` VALUES (58, '2021-08-28 16:58:48', '1', '1', '1', '1', '1', 2, 0, 1, 1, '', 'https://xiazai.sogou.com/comm/redir?softdown=1&u=5M778mNuk-IR5IpbEw6j9YpS1Wc4Ved3WXa85rh1XgyheSu4KSc873XX-0eLlV_4wScdwqbg5EVsipUd8ZPGCKrHmAlohI-ZdTnqogy02lfO1qgEiXFMzWYGOMRRI9VQniF5_tMpLpNKNrbuIcvX44SnDc4QRtSS8YpZz1ZUJWAtEqX99Vd8G_Y2oIxrJvgHLzBAvXfQq_mJU6guPZ3epw..&pcid=1882834511144817344&filename=QQMusic_Setup_1822.5311_QMgr.exe&source=tencent&w=1907&stamp=20210825??https://pm.myapp.com/invc/xfspeed/qqpcmgr/download/QQ_PCDownload1100109381.exe??https://d1.music.126.net/dmusic/cloudmusicsetup2.9.2.199163.exe', '18173516309', '1', '2021082859');

SET FOREIGN_KEY_CHECKS = 1;
