/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.62 : Database - basketdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`basketdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `basketdb`;

/*Table structure for table `matches` */

DROP TABLE IF EXISTS `matches`;

CREATE TABLE `matches` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `idTeamLocal` bigint(20) DEFAULT NULL,
  `idTeamAway` bigint(20) DEFAULT NULL,
  `resultLocal` varchar(5) DEFAULT NULL,
  `resultAway` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `matches` */

LOCK TABLES `matches` WRITE;

insert  into `matches`(`id`,`date`,`idTeamLocal`,`idTeamAway`,`resultLocal`,`resultAway`) values (1,'2019-10-16',1,2,'63','80'),(2,'2019-10-17',1,2,'55','92'),(3,'2019-10-16',1,1,'77','79'),(4,'2019-10-15',1,1,'88','63');

UNLOCK TABLES;

/*Table structure for table `players` */

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `dayBirth` date DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `registrationNumber` varchar(50) DEFAULT NULL,
  `defaultImg` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

/*Data for the table `players` */

LOCK TABLES `players` WRITE;

insert  into `players`(`id`,`name`,`dayBirth`,`position`,`registrationNumber`,`defaultImg`) values (2,'juan','2019-06-11','Pivot','23','Hure.jpg'),(34,'fdff','2019-10-02','Pivot',NULL,'Hure.jpg'),(39,'gbc','2019-10-16','Pivot',NULL,'Acosta.jpg'),(40,'xx gfbc','2019-10-16','Alero',NULL,'Acosta.jpg'),(41,'ff','2019-10-17','Alero',NULL,'Acosta.jpg'),(42,'f','2019-10-10','Alero',NULL,'Gauna.jpg'),(50,'gbccc','2019-10-12','Base',NULL,'Gauna.jpg'),(52,'Franco Gauna','2019-10-13','Base',NULL,'Gauna.jpg'),(53,'Nicolas Acosta','2019-10-13','Alero',NULL,'Acosta.jpg'),(54,'Daniel Hure','2019-10-13','Pivot',NULL,'Hure.jpg'),(55,'Jhon Snow','2019-10-19','Pivot',NULL,'IMG-20190804-WA0067.jpg');

UNLOCK TABLES;

/*Table structure for table `projects` */

DROP TABLE IF EXISTS `projects`;

CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectidentifier` bigint(20) DEFAULT NULL,
  `projectname` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `projects` */

LOCK TABLES `projects` WRITE;

insert  into `projects`(`id`,`projectidentifier`,`projectname`,`description`,`startDate`) values (1,1,'cobol','volver a coboll',NULL),(4,4,'junit','aprender testing','2019-09-17'),(5,5,'seguridad','testear seguridad 1',NULL),(8,7,'rrrrr','rrr',NULL),(9,1,'cobol','volver a cobol',NULL),(10,3,'spring boot','leer sobre spring',NULL),(11,3,'spring','leer sobre springf',NULL),(12,12,'react','aprender react',NULL),(13,13,'react','aprender react',NULL);

UNLOCK TABLES;

/*Table structure for table `teams` */

DROP TABLE IF EXISTS `teams`;

CREATE TABLE `teams` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `thumb` varchar(100) DEFAULT NULL,
  `stadium` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `teams` */

LOCK TABLES `teams` WRITE;

insert  into `teams`(`id`,`name`,`thumb`,`stadium`) values (1,'Boca','adasdasdasda','Bombonerita'),(2,'Obras','asdff','Pepsi Obras');

UNLOCK TABLES;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` datetime DEFAULT NULL,
  `fullname` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `update_at` datetime DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`,`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

LOCK TABLES `users` WRITE;

insert  into `users`(`id`,`create_at`,`fullname`,`password`,`update_at`,`username`) values (1,'2019-09-17 16:47:49','gbert','$2a$10$hH/1vE.lLeN9x05UkdVB/eLUl/dIUf4gEMHmH4IC0ZfAXYwL.yrvS','2019-09-17 16:48:02','gbert@gmail.com'),(2,'2019-09-17 21:34:19','guido b','$2a$10$oY1KDvy4/7eXyXhtwWYbvu.WlafVBkuHVoJhKgqH1SW2DMxs0lZxS',NULL,'gberti@gmail.com'),(6,'2019-09-18 18:16:09','ff','$2a$10$CIDHoe7ikzTRvlBX8rdan.R37z7rZ/xSkqdWg8XmL4qcPJCgaSts.',NULL,'222@2a.com');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
