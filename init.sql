/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.26-log : Database - lyb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lyb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lyb`;

/*Table structure for table `ban` */

DROP TABLE IF EXISTS `ban`;

CREATE TABLE `ban` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `btext` varchar(60) DEFAULT NULL,
  `btype` int(11) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `ban` */

insert  into `ban`(`bid`,`btext`,`btype`) values 
(1,'192.168.1.1',2),
(2,'1',1),
(4,'127.0.0.1',2);

/*Table structure for table `loginss` */

DROP TABLE IF EXISTS `loginss`;

CREATE TABLE `loginss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) NOT NULL,
  `lastlogin` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `loginss` */

insert  into `loginss`(`id`,`name`,`password`,`role`,`lastlogin`) values 
(1,'11','1',0,'2019-08-31'),
(2,'1','22',0,'2019-08-31'),
(3,'12','1',0,NULL),
(7,'test','testtest',0,'2019-08-31');

/*Table structure for table `messagess` */

DROP TABLE IF EXISTS `messagess`;

CREATE TABLE `messagess` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `time` datetime NOT NULL,
  `title` varchar(20) NOT NULL,
  `message` varchar(50) NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `messagess` */

insert  into `messagess`(`id`,`name`,`time`,`title`,`message`) values 
(2,'1','2019-08-29 00:00:00','23','23'),
(3,'1','2019-08-29 00:00:00','232323','232323'),
(4,'1','2019-08-29 00:00:00','华发电话','发生的回复'),
(5,'1','2019-08-29 00:00:00','暗室逢灯核发的','发送到'),
(6,'1','2019-08-29 00:00:00','23','23'),
(7,'1','2019-08-29 00:00:00','哈达哈','发送到'),
(8,'22','2019-08-30 00:00:00','222','222'),
(9,'22','2019-08-30 00:00:00','333','333'),
(20,'testroot','2019-08-31 00:00:00','发送到','阿萨德'),
(21,'test','2019-08-31 00:00:00','测试留言','案发生大发大声道'),
(22,'test','2019-08-31 00:00:00','asdf','asdf');

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `replymessage` varchar(500) DEFAULT NULL,
  `replytime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

insert  into `reply`(`rid`,`mid`,`replymessage`,`replytime`) values 
(1,2,'你好，这个是接','2019-08-29 01:33:53'),
(2,2,'是吗','2019-08-29 01:34:13'),
(3,2,'测试回复','2019-08-31 01:56:01');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
