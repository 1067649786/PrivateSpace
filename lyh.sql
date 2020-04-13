/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : lyh

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 13/04/2020 16:03:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '发表用户',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容html格式',
  `contentMd` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容Markdown格式',
  `newstime` datetime(0) DEFAULT NULL COMMENT '发布时间',
  `status` int(11) DEFAULT NULL COMMENT '文章状态 0已发布1草稿2回收站',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章摘要',
  `thumbnail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '略缩图',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `type` int(255) DEFAULT NULL COMMENT '文章类型0原创1转载',
  `post` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'post文章 page页面',
  `comment` int(11) DEFAULT NULL COMMENT '是否开启评论 0开启1不开启',
  `updatetime` datetime(0) DEFAULT NULL COMMENT '文章最后修改时间',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章路径',
  `views` bigint(20) DEFAULT 0 COMMENT '访问量统计',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `MAYDAY_ARTICLE_URL`(`url`) USING BTREE,
  INDEX `MAYDAY_ARTICLE_USERID`(`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES (1, 0, '漫展结束，\r\n\r\n闺蜜说等下我们去吃膨膨冰吧\r\n\r\n刚好男友和他哥们在附近，让他们来接\r\n\r\n就这样我和闺蜜穿着cos服装站在路边\r\n\r\n等\r\n\r\n今天注定是与众不同的一天。\r\n\r\n和闺蜜参加了大型漫展\r\n\r\n和许多很棒的coser合照\r\n\r\n被人夸赞很美\r\n\r\n心情超棒\r\n\r\n但这些开心都不及遇见了他\r\n\r\n车来了，我和闺蜜坐在后座\r\n\r\n他从副驾驶探过来个脑袋\r\n\r\n“你好，小神乐”说完就回过了头\r\n\r\n我一向很淡定的啊\r\n\r\n刚才的心跳加速怎么回事\r\n\r\n好久没见过这样的男生了\r\n\r\n气质干净，笑容很温柔\r\n\r\n路上一直都是闺蜜和男友撒娇的声音\r\n\r\n我却忍不住将眼光飘向他\r\n\r\n后来吃的膨膨冰是什么味道\r\n\r\n我不记得\r\n\r\n只记得，他对着我笑了好多次\r\n\r\n今天很完美啊\r\n\r\n除了没有他的联系方式\r\n\r\n以后，还会遇见吗？', '# 心动', '2020-02-27 16:10:31', 0, '一见钟情是什么感觉', '/img/rand/11.jpg', '心动', 0, 'post', 0, '2020-03-27 16:10:31', 'hello-mayday', 0);
INSERT INTO `tb_article` VALUES (2, 13, '好开心！加了他的微信！\r\n\r\n一直没想好怎样跟闺蜜开口要他的联系方式\r\n\r\n不想被笑，也不想显得很主动\r\n\r\n啊啊啊，\r\n\r\n就是这样表面平静内心翻滚\r\n\r\n这不是真的喜欢吧\r\n\r\n可是为什么念念不忘呢\r\n\r\n我竟然因为一个见过一面的人烦恼\r\n\r\n原来爱情会让人变傻\r\n\r\n在我翻来覆去懊恼的时候\r\n\r\n闺蜜突然拉了个游戏群\r\n\r\n哈哈哈哈我一眼就认出来他了\r\n\r\n竟然用自己的照片当头像\r\n\r\n一起玩了几把游戏\r\n\r\n拼命发挥最好状态\r\n\r\n没丢脸还被夸了一波\r\n\r\n果然他觉得我这么棒加我微信了\r\n\r\n看来男生还是喜欢会打游戏的女生\r\n\r\n通过好友验证\r\n\r\n他说，还记得我不\r\n\r\n我回忆了三遍他的脸\r\n\r\n偷偷乐了半天\r\n\r\n回复“你是？”\r\n\r\n\r\n#Boy:\r\n\r\n6月12日\r\n\r\n听说她也玩游戏\r\n\r\n赶紧拜托朋友拉了群\r\n\r\n小傻瓜果然上钩了\r\n\r\n哈哈哈哈', '# Hello Mayday!\n欢迎使用Mayday进行创作，删除这篇文章后赶紧开。', '2020-03-28 16:10:31', 0, '这不是真的喜欢吧', '/img/rand/1.jpg', 'Hello 加微信', 0, 'post', 0, '2020-03-27 16:10:31', 'hello-mayd', 0);
INSERT INTO `tb_article` VALUES (3, 2, '除了玩游戏，我们之间的话题好少\r\n\r\n翻遍了他的朋友圈\r\n\r\n也不知道说点什么\r\n\r\n突然问我在做什么\r\n\r\n我说，你猜\r\n\r\n他说，想我？\r\n\r\n我的天 = =！\r\n\r\n被猜中心思的感觉好慌张\r\n\r\n他是怎么知道的，\r\n\r\n好烦好烦好烦\r\n\r\n我就这么容易被看穿吗\r\n\r\n没有很明显吧\r\n\r\n不管了，\r\n\r\n我要隐身', '# Hello Mayday!\n欢迎使用Mayday进行创作，删除这篇文章后赶紧开。', '2020-03-29 16:10:31', 0, '翻遍了他的朋友圈', '/img/rand/2.jpg', '忐忑', 0, 'post', 0, '2020-03-27 16:10:31', 'hello-mayd2', 0);
INSERT INTO `tb_article` VALUES (4, 3, '<h1>Hello Mayday!</h1>\n<p>欢迎使用Mayday进行创作，删除这篇文章后赶紧开始吧。</p>', '# Hello Mayday!\n欢迎使用Mayday进行创作，删除这篇文章后赶紧开。', '2020-03-30 16:10:31', 0, '欢迎使用Mayday进行创作，删除这篇文章后赶紧开始吧。', '/img/rand/3.jpg', 'Hello Mayday!', 0, 'post', 0, '2020-03-27 16:10:31', 'hello-mayd5', 0);
INSERT INTO `tb_article` VALUES (5, 2, '<p>vbzxcfgdsafsd</p>\r\n', 'vbzxcfgdsafsd', '2020-04-07 16:33:51', 0, 'vbzxcfgdsafsd', '/img/rand/5.jpg', 'ghdrfghfg', NULL, 'post', NULL, '2020-04-07 16:33:51', '1586248431', NULL);
INSERT INTO `tb_article` VALUES (6, 2, '<p>hgfdhgsdfhfdsgfsdg</p>\r\n', 'hgfdhgsdfhfdsgfsdg', '2020-04-07 16:35:30', 0, 'fdgdfsgdfsg', '/img/rand/6.jpg', 'fgdfgjfghjfgd', NULL, 'post', NULL, '2020-04-07 16:35:30', '1586248530', NULL);
INSERT INTO `tb_article` VALUES (7, 2, '<p>gdfshfgjukgfyhgdfsLUHKGMFNB</p>\r\n', 'gdfshfgjukgfyhgdfsLUHKGMFNB', '2020-04-07 16:35:38', 0, 'gfhjdfgj', '/img/rand/8.jpg', 'njghjkuykufg', NULL, 'post', NULL, '2020-04-07 16:35:38', '1586248537', NULL);
INSERT INTO `tb_article` VALUES (8, 2, '<p>jklhmgdfvsci9olukghnfvb cx78ityjghfbc</p>\r\n', 'jklhmgdfvsci9olukghnfvb cx78ityjghfbc', '2020-04-07 16:35:45', 0, 'jklhmgdfvsci9olukghnfvbcx78ityjghfbc', '/img/rand/2.jpg', 'lk,hjgfsduilkjhdfvsc', NULL, 'post', NULL, '2020-04-07 16:35:45', '1586248544', NULL);
INSERT INTO `tb_article` VALUES (9, 2, '<p>kuyfgdvc sx4trfg mtyujhnfgcx</p>\r\n', 'kuyfgdvc sx4trfg mtyujhnfgcx', '2020-04-07 16:35:51', 0, 'kuyfgdvcsx4trfgmtyujhnfgcx', '/img/rand/2.jpg', 'ikjhgfdvciolujkmghnfbd', NULL, 'post', NULL, '2020-04-07 16:35:51', '1586248551', NULL);
INSERT INTO `tb_article` VALUES (10, 2, '<p>ujigbyh fvcxuikjm bghncvxiuj8kyhn gbcv</p>\r\n', 'ujigbyh fvcxuikjm bghncvxiuj8kyhn gbcv', '2020-04-07 16:35:58', 0, 'ujigbyhfvcxuikjmbghncvxiuj8kyhngbcv', '/img/rand/12.jpg', 'ikyhujfgd9o8ujiky fgbvc', NULL, 'post', NULL, '2020-04-07 16:35:58', '1586248558', NULL);
INSERT INTO `tb_article` VALUES (11, 2, '<p>nmkjbvhcgkljhvgcf,.mnbvcmknbvc</p>\r\n', 'nmkjbvhcgkljhvgcf,.mnbvcmknbvc', '2020-04-07 16:36:08', 0, 'nmkjbvhcgkljhvgcf,.mnbvcmknbvc', '/img/rand/3.jpg', 'khunfvgbc  nmbvcgyfiokjhugfd', NULL, 'post', NULL, '2020-04-07 16:36:08', '1586248567', NULL);
INSERT INTO `tb_article` VALUES (12, 2, '<p>uighvcklnjmbhvcxlkjhgfdkjhgfdbvcd</p>\r\n', 'uighvcklnjmbhvcxlkjhgfdkjhgfdbvcd', '2020-04-07 16:36:48', 0, 'uighvcklnjmbhvcxlkjhgfdkjhgfdbvcd', '/img/rand/15.jpg', ' knjhgkljhgfdjmk,nhgbvf', NULL, 'post', NULL, '2020-04-07 16:36:48', '1586248608', NULL);
INSERT INTO `tb_article` VALUES (13, 2, '<p>jhbvgcx mnvbcxnmbvcxhbvgcxf</p>\r\n', 'jhbvgcx mnvbcxnmbvcxhbvgcxf', '2020-04-07 16:36:59', 0, 'jhbvgcxmnvbcxnmbvcxhbvgcxf', '/img/rand/16.jpg', 'njbvcxjnbhvcxkjhvgbc', NULL, 'post', NULL, '2020-04-07 16:36:59', '1586248618', NULL);
INSERT INTO `tb_article` VALUES (14, 2, '<p>ujythgbfdvc m7ythfgvdscjkhgfxdckjhgfds</p>\r\n', 'ujythgbfdvc m7ythfgvdscjkhgfxdckjhgfds', '2020-04-07 16:37:10', 0, 'ujythgbfdvcm7ythfgvdscjkhgfxdckjhgfds', '/img/rand/3.jpg', 'kghjgn vb8jtyugbhfv', NULL, 'post', NULL, '2020-04-07 16:37:10', '1586248629', NULL);
INSERT INTO `tb_article` VALUES (15, 2, '<p>i9kuj gbhnvc8i9okyjum ghbncv9o0p uikljm vbghnc</p>\r\n', 'i9kuj gbhnvc8i9okyjum ghbncv9o0p uikljm vbghnc', '2020-04-07 16:37:30', 0, 'i9kujgbhnvc8i9okyjumghbncv9o0puikljmvbghnc', '/img/rand/18.jpg', 'kmjh bnvc rt 8utyhjgf', NULL, 'post', NULL, '2020-04-07 16:37:30', '1586248650', NULL);
INSERT INTO `tb_article` VALUES (16, 2, '<p>ikuyjhn fvbgcfxu8ikjyhn fbgvcuj8ihny bgv</p>\r\n', 'ikuyjhn fvbgcfxu8ikjyhn fbgvcuj8ihny bgv', '2020-04-07 16:37:37', 0, 'ikuyjhnfvbgcfxu8ikjyhnfbgvcuj8ihnybgv', '/img/rand/17.jpg', 'uhgn fvbfc78iukjyhn fvbgcikuj8hn vgb', NULL, 'post', NULL, '2020-04-07 16:37:37', '1586248656', NULL);
INSERT INTO `tb_article` VALUES (17, 2, '<p>jtyghjtydjhdrftydfd</p>\r\n', 'jtyghjtydjhdrftydfd', '2020-04-07 23:41:00', 0, 'jtyghjtydjhdrftydfd', '/img/rand/16.jpg', 'fsdafasd', NULL, 'post', NULL, '2020-04-07 23:41:00', '1586274059', NULL);
INSERT INTO `tb_article` VALUES (19, 2, '<p>hfgdhfdhsfdgsdfgfd<br><img src=\"C:\\Users\\10676\\mayday\\upload\\2020\\4\\WIN_20200114_21_35_56_Pro20200407231941392.jpg\" alt=\"111\"></p>\r\n', 'hfgdhfdhsfdgsdfgfd\r\n![111](C:\\Users\\10676\\mayday\\upload\\2020\\4\\WIN_20200114_21_35_56_Pro20200407231941392.jpg)', '2020-04-08 11:39:19', 0, 'hfgdhfdhsfdgsdfgfd', '/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392.jpg', 'ytjrytjrtdj', NULL, 'post', NULL, '2020-04-08 11:39:19', '1586317158', NULL);
INSERT INTO `tb_article` VALUES (20, 2, '<p><img src=\"/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392.jpg\" alt=\"\"></p>\r\n<p>呦呦呦</p>\r\n', '![](/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392.jpg)\r\n\r\n呦呦呦', '2020-04-08 11:40:57', 0, '111', '/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392.jpg', 'tryrteyh', NULL, 'post', NULL, '2020-04-08 13:08:52', '1586317257', NULL);
INSERT INTO `tb_article` VALUES (22, 2, '<p>ghjkkghfjkfghjcfghjdfgh</p>\r\n', 'ghjkkghfjkfghjcfghjdfgh', '2020-04-08 14:39:43', 0, 'ghjkkghfjkfghjcfghjdfgh', '/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392.jpg', 'yjktyukufty', NULL, 'post', NULL, '2020-04-08 14:39:43', '1586327983', NULL);
INSERT INTO `tb_article` VALUES (27, 2, '<p>jhhjdfghdfgghsdf</p>\r\n', 'jhhjdfghdfgghsdf', '2020-04-08 17:28:53', 0, NULL, '/img/rand/18.jpg', 'lyh', NULL, 'page', NULL, '2020-04-08 17:30:42', 'lyh', NULL);

-- ----------------------------
-- Table structure for tb_attachment
-- ----------------------------
DROP TABLE IF EXISTS `tb_attachment`;
CREATE TABLE `tb_attachment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `pictureName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片名称',
  `picturePath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片路径',
  `pictureSmallPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '略缩图',
  `pictureType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片类型',
  `pictureCreateDate` datetime(0) DEFAULT NULL COMMENT '上传时间',
  `pictureSize` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件大小',
  `pictureSuffix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '后缀',
  `pictureWH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '尺寸',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_attachment
-- ----------------------------
INSERT INTO `tb_attachment` VALUES (5, 2, 'WIN_20200114_21_35_56_Pro20200407231941392.jpg', '/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392.jpg', '/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392_small.jpg', 'image/jpeg', '2020-04-07 23:19:41', '163KB', '.jpg', '1280x720');
INSERT INTO `tb_attachment` VALUES (6, 2, 'WIN_20200324_22_19_50_Pro20200407231941456.jpg', '/upload/2020/4/WIN_20200324_22_19_50_Pro20200407231941456.jpg', '/upload/2020/4/WIN_20200324_22_19_50_Pro20200407231941456_small.jpg', 'image/jpeg', '2020-04-07 23:19:41', '184KB', '.jpg', '1280x720');
INSERT INTO `tb_attachment` VALUES (7, 2, 'WIN_20200324_22_18_29_Pro20200407231941700.jpg', '/upload/2020/4/WIN_20200324_22_18_29_Pro20200407231941700.jpg', '/upload/2020/4/WIN_20200324_22_18_29_Pro20200407231941700_small.jpg', 'image/jpeg', '2020-04-07 23:19:41', '184KB', '.jpg', '1280x720');
INSERT INTO `tb_attachment` VALUES (8, 2, 'WIN_20200313_15_18_29_Pro20200407234803903.jpg', '/upload/2020/4/WIN_20200313_15_18_29_Pro20200407234803903.jpg', '/upload/2020/4/WIN_20200313_15_18_29_Pro20200407234803903_small.jpg', 'image/jpeg', '2020-04-07 23:48:04', '164KB', '.jpg', '1280x720');
INSERT INTO `tb_attachment` VALUES (9, 2, '120200408141850300.jpg', '/upload/2020/4/120200408141850300.jpg', '/upload/2020/4/120200408141850300_small.jpg', 'image/jpeg', '2020-04-08 14:18:51', '10KB', '.jpg', '90x116');
INSERT INTO `tb_attachment` VALUES (10, 2, 'WIN_20200313_15_44_43_Pro20200408144022184.jpg', '/upload/2020/4/WIN_20200313_15_44_43_Pro20200408144022184.jpg', '/upload/2020/4/WIN_20200313_15_44_43_Pro20200408144022184_small.jpg', 'image/jpeg', '2020-04-08 14:40:23', '143KB', '.jpg', '1280x720');
INSERT INTO `tb_attachment` VALUES (11, 2, 'WIN_20200313_15_19_17_Pro2020040814402293.jpg', '/upload/2020/4/WIN_20200313_15_19_17_Pro2020040814402293.jpg', '/upload/2020/4/WIN_20200313_15_19_17_Pro2020040814402293_small.jpg', 'image/jpeg', '2020-04-08 14:40:23', '162KB', '.jpg', '1280x720');

-- ----------------------------
-- Table structure for tb_bind
-- ----------------------------
DROP TABLE IF EXISTS `tb_bind`;
CREATE TABLE `tb_bind`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid1` int(11) NOT NULL,
  `uid2` int(11) NOT NULL,
  `relationid` int(11) NOT NULL,
  `date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bind
-- ----------------------------
INSERT INTO `tb_bind` VALUES ('d7dd7ff1352d4f5093be85dad978bea7', 13, 2, 1, '2020-03-27 12:46:27');

-- ----------------------------
-- Table structure for tb_comments
-- ----------------------------
DROP TABLE IF EXISTS `tb_comments`;
CREATE TABLE `tb_comments`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `topId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isDelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created` datetime(0) DEFAULT NULL,
  `replayUserId` int(11) DEFAULT NULL,
  `lastId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_gallery
-- ----------------------------
DROP TABLE IF EXISTS `tb_gallery`;
CREATE TABLE `tb_gallery`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filesize` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `format` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `imageHeight` int(11) DEFAULT NULL,
  `imageWidth` int(11) DEFAULT NULL,
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `uploadDate` datetime(0) DEFAULT NULL,
  `fileName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `topId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_lovetext
-- ----------------------------
DROP TABLE IF EXISTS `tb_lovetext`;
CREATE TABLE `tb_lovetext`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` datetime(0) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `menuIcon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单图标',
  `menuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单名称',
  `menuSort` int(11) DEFAULT NULL COMMENT '排序',
  `menuTarget` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '打开方式',
  `menuUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES (1, 0, NULL, '首页', 1, '_self', '/user/index');
INSERT INTO `tb_menu` VALUES (2, 0, NULL, '归档', 2, '_self', '/user/archives');
INSERT INTO `tb_menu` VALUES (6, 2, '', 'lyh', 3, '_self', '/user/lyh');

-- ----------------------------
-- Table structure for tb_note
-- ----------------------------
DROP TABLE IF EXISTS `tb_note`;
CREATE TABLE `tb_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `context` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` datetime(0) DEFAULT NULL,
  `isDelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isComplete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_relation
-- ----------------------------
DROP TABLE IF EXISTS `tb_relation`;
CREATE TABLE `tb_relation`  (
  `id` int(11) NOT NULL,
  `relation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_relation
-- ----------------------------
INSERT INTO `tb_relation` VALUES (1, '情侣');
INSERT INTO `tb_relation` VALUES (2, '亲子');
INSERT INTO `tb_relation` VALUES (3, '朋友');

-- ----------------------------
-- Table structure for tb_tops
-- ----------------------------
DROP TABLE IF EXISTS `tb_tops`;
CREATE TABLE `tb_tops`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createTime` datetime(0) DEFAULT NULL,
  `zan` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `isDelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created` datetime(0) DEFAULT NULL,
  `updated` datetime(0) DEFAULT NULL,
  `onlieTime` datetime(0) DEFAULT NULL,
  `isDelete` int(4) DEFAULT NULL,
  `bindCode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `isBind` int(4) DEFAULT NULL,
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', 'admin', '123456', 'admin', 'admin', '2020-03-08 14:53:30', NULL, '2020-03-13 20:43:00', 0, NULL, 0, NULL);
INSERT INTO `tb_user` VALUES (2, 'lyh', '乖女儿刘艳慧111', '123', '', '106764@qq.com', '2020-03-13 21:09:52', '2020-03-27 14:48:41', '2020-04-09 10:54:55', NULL, '52585b6', 1, '/upload/2020/4/WIN_20200114_21_35_56_Pro20200407231941392.jpg');
INSERT INTO `tb_user` VALUES (13, 'ygy', '', 'lyh1121', '', '', '2020-03-24 23:12:43', '2020-03-26 14:59:26', '2020-04-08 14:42:21', NULL, '1fa0acb', 1, '/upload/2020/4/120200408141850300.jpg');

SET FOREIGN_KEY_CHECKS = 1;
