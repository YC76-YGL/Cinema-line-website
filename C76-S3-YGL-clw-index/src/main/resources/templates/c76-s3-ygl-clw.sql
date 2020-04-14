/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50018
Source Host           : 127.0.0.1:3306
Source Database       : c76-s3-ygl-clw

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-04-14 19:30:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clw_actor
-- ----------------------------
DROP TABLE IF EXISTS `clw_actor`;
CREATE TABLE `clw_actor` (
  `id` int(10) NOT NULL,
  `name` varchar(255) default NULL,
  `age` int(11) default NULL,
  `addr` varchar(255) default NULL,
  `birth` varchar(255) default NULL,
  `looks` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clw_actor
-- ----------------------------
INSERT INTO `clw_actor` VALUES ('1', 'Alexander Skarsgård', '44', '瑞典,斯德哥尔摩', '1976-08-25', 'image/Alexander Skarsgård.png');

-- ----------------------------
-- Table structure for clw_commentary
-- ----------------------------
DROP TABLE IF EXISTS `clw_commentary`;
CREATE TABLE `clw_commentary` (
  `id` int(10) NOT NULL,
  `commentary` varchar(255) default NULL,
  `user` int(10) default NULL,
  `movielist` int(10) default NULL,
  `createtime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clw_commentary
-- ----------------------------

-- ----------------------------
-- Table structure for clw_country
-- ----------------------------
DROP TABLE IF EXISTS `clw_country`;
CREATE TABLE `clw_country` (
  `id` int(10) NOT NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clw_country
-- ----------------------------
INSERT INTO `clw_country` VALUES ('1', '亚洲');
INSERT INTO `clw_country` VALUES ('2', '欧洲');
INSERT INTO `clw_country` VALUES ('3', '法国');
INSERT INTO `clw_country` VALUES ('4', '德国');
INSERT INTO `clw_country` VALUES ('5', '美国');
INSERT INTO `clw_country` VALUES ('6', '中国');
INSERT INTO `clw_country` VALUES ('7', '日本');
INSERT INTO `clw_country` VALUES ('8', '泰国');
INSERT INTO `clw_country` VALUES ('9', '俄罗斯');
INSERT INTO `clw_country` VALUES ('10', '印度');
INSERT INTO `clw_country` VALUES ('11', '韩国');
INSERT INTO `clw_country` VALUES ('12', '英国');

-- ----------------------------
-- Table structure for clw_geners
-- ----------------------------
DROP TABLE IF EXISTS `clw_geners`;
CREATE TABLE `clw_geners` (
  `id` int(10) NOT NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clw_geners
-- ----------------------------
INSERT INTO `clw_geners` VALUES ('1', '动作');
INSERT INTO `clw_geners` VALUES ('2', '传记');
INSERT INTO `clw_geners` VALUES ('3', '犯罪');
INSERT INTO `clw_geners` VALUES ('4', '家庭');
INSERT INTO `clw_geners` VALUES ('5', '恐怖');
INSERT INTO `clw_geners` VALUES ('6', '爱情');
INSERT INTO `clw_geners` VALUES ('7', '体育');
INSERT INTO `clw_geners` VALUES ('8', '战争');
INSERT INTO `clw_geners` VALUES ('9', '冒险');
INSERT INTO `clw_geners` VALUES ('10', '喜剧');
INSERT INTO `clw_geners` VALUES ('11', '记录');
INSERT INTO `clw_geners` VALUES ('12', '科幻');
INSERT INTO `clw_geners` VALUES ('13', '惊悚');
INSERT INTO `clw_geners` VALUES ('14', '动画');
INSERT INTO `clw_geners` VALUES ('15', '情景');
INSERT INTO `clw_geners` VALUES ('16', '戏剧');
INSERT INTO `clw_geners` VALUES ('17', '历史');
INSERT INTO `clw_geners` VALUES ('18', '音乐');
INSERT INTO `clw_geners` VALUES ('19', '心理');

-- ----------------------------
-- Table structure for clw_movielist
-- ----------------------------
DROP TABLE IF EXISTS `clw_movielist`;
CREATE TABLE `clw_movielist` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `createtime` datetime default NULL,
  `is_hot` varchar(255) default NULL,
  `geners` int(255) default NULL,
  `actor` int(255) default NULL,
  `actor1` int(255) default NULL,
  `director` varchar(255) default NULL,
  `country` int(255) default NULL,
  `score` int(255) default NULL,
  `geners1` int(255) default NULL,
  `image` varchar(255) default NULL,
  `other` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clw_movielist
-- ----------------------------
INSERT INTO `clw_movielist` VALUES ('1', '泰山归来：险战丛林', '故事发生在十九世纪八十年代，自小生长在丛林之中的泰山（亚历山大·斯卡斯加德 Alexander Skarsgård 饰）早已经离开了刚果，回归了人类社会。他同心爱的珍（玛歌特·罗比 Margot Robbie 饰）结婚成家，在英国伦敦过着幸福美满的生活', '2016-07-19 22:18:42', '1', '1', null, null, 'David Yates', '5', null, '9', null, '');
INSERT INTO `clw_movielist` VALUES ('2', '疾速天使', '六个孩子被实验室运用羊膜穿孔技术进行了残酷的基因改造，变成了长有翅膀拥有超能力的鸟孩，并且被用来做惨无人道的实验。他们逃离、反叛，在残酷的试炼中发现他们的力量正是为了这个世界而存在。故事极像快速推进的大片，充满悬疑的故事、环环相扣的谜团、匪夷所思的超能力。不断切换的场景，第一人称的叙述方式，带读者迅速进入故事情境。让读者与六个孩子一起遭遇挫折、触摸感动，踏上探索生命真谛与未来命运的旅程', '2016-08-30 14:59:43', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `clw_movielist` VALUES ('3', '独立日2：卷土重来', '经历过外星人大举入侵地球后，人类知道，这些入侵者有一天一定会再回来。人类运用先前外星人所遗留下来的科技文明，发展出一套强大的地球防御系统以抵御外星人的再度入侵。然而，20年后，这些外星人却带着人类前所未见、更先进强大的武力再次入侵地球，带来更大的全球灾难，几位勇敢的年轻人，他们挺身而出，将再一次为人类生存而战斗……', '2016-06-24 15:02:47', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `clw_movielist` VALUES ('4', '乌龙特工', '会计师卡尔文（凯文·哈特 Kevin Hart 饰）在高中时代曾是学校的体育明星，他热心张罗高中同学聚会，于是在Facebook上联系到了老同学鲍勃（道恩·强森 Dwayne Johnson 饰），他没想到这个在高中时常受欺负的老同学现在已经是CIA的职业杀手，而他也万万没想到自己将被卷入制止军事秘密泄露的任务中。', '2016-06-17 15:04:22', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `clw_movielist` VALUES ('5', '冰川时代5：星际碰撞 ', '松鼠奎特为了追松果，偶然引发了宇宙事件，改变并威胁着冰川时代的世界。为了拯救自己，话唠树懒希德，猛犸象曼尼，剑齿虎迪亚哥，以及别的动物群族必须离开家园，踏上了他们充满喜剧色彩的冒险旅程，他们来到了充满异国情调的新大陆，并遇到了许多形形色色的新角色', '2016-08-23 15:05:41', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `clw_movielist` VALUES ('6', 'X战警：天启', 'X战警：天启》是由美国二十世纪福克斯电影公司出品的科幻动作片，由布莱恩·辛格执导，詹姆斯·麦卡沃伊、迈克尔·法斯宾德、詹妮弗·劳伦斯、尼古拉斯·霍尔特、奥斯卡·伊萨克等联合主演。该片故事以20世纪80年代为背景，讲述了古老强大的第一个变种人天启在埃及醒来，他想统治并改变这个世界，而引发一系列变种人大战的故事。', '2016-06-03 15:07:22', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `clw_movielist` VALUES ('7', '公民士兵', '本片从士兵的角度讲述了俄克拉荷马州陆军国民警卫队第45旅级战斗群，在派遣到阿富汗的96天里的经历。通过大量录像，战地记录从另一个角度让我们审视阿富汗战争。', '2016-08-30 15:10:02', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `clw_movielist` VALUES ('8', 'Greater', '中国的古代，以人类为饵食的怪兽——，每六十年便会集结到人类的领地觅食，捍卫领土的人类军团铸造长城的目的也是为了抵御怪兽的入侵。来到中国寻觅黑火药发财的外国威廉·加林与佩罗· 托瓦尔，因为一次偶然的机会误打误撞进入了长城，认识了对抗饕餮的中国无影禁军，也见证了无影禁军的精锐和勇敢，并被这群战士之间的信任和牺牲所感动，威廉·加林义无反顾地加入到了共同守护人类的战斗当中。然而，在对抗的过程中，他们却发现饕餮大军不断进化，到最后已经能够从长城打进皇宫，一场大战也由此拉开', '2016-07-13 15:14:09', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for clw_news
-- ----------------------------
DROP TABLE IF EXISTS `clw_news`;
CREATE TABLE `clw_news` (
  `id` int(11) NOT NULL,
  `title` varchar(255) default NULL,
  `content` varchar(255) default NULL,
  `other` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clw_news
-- ----------------------------

-- ----------------------------
-- Table structure for clw_user
-- ----------------------------
DROP TABLE IF EXISTS `clw_user`;
CREATE TABLE `clw_user` (
  `id` int(10) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `sex` int(10) default NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(255) default NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clw_user
-- ----------------------------
