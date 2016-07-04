/*
SQLyog Community v11.52 (64 bit)
MySQL - 5.6.28-log : Database - prosoft
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prosoft` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `prosoft`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `ptt` bigint(20) NOT NULL,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`ptt`,`naziv`) values (11000,'Beograd'),(11550,'Lazarevac'),(16000,'Leskovac'),(37230,'Aleksandrovac');

/*Table structure for table `pravnolice` */

DROP TABLE IF EXISTS `pravnolice`;

CREATE TABLE `pravnolice` (
  `maticni_broj` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pib` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datum_osnivanja` date DEFAULT NULL,
  `ptt_mesto_osnivanja` bigint(20) DEFAULT NULL,
  `opstina_sediste` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ulica_sediste` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `broj_sediste` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`maticni_broj`),
  KEY `ptt_mesto` (`ptt_mesto_osnivanja`),
  CONSTRAINT `pravnolice_ibfk_1` FOREIGN KEY (`ptt_mesto_osnivanja`) REFERENCES `mesto` (`ptt`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pravnolice` */

insert  into `pravnolice`(`maticni_broj`,`naziv`,`pib`,`datum_osnivanja`,`ptt_mesto_osnivanja`,`opstina_sediste`,`ulica_sediste`,`broj_sediste`) values ('e','e','e','2016-01-01',11000,'ee','e','e'),('m1','n1','p1','2016-03-31',11000,'z1','ub1',NULL),('m2','naziv','p','2002-02-02',37230,'zr','ulbr',NULL),('m3','s','p3','2001-02-02',11550,'s','ul',NULL),('m4','n','pp','1993-01-02',16000,'z','dd',NULL);

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `sifra` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cena` double DEFAULT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `proizvod` */

insert  into `proizvod`(`sifra`,`naziv`,`cena`) values (1,'Bananica',20),(2,'Keks',50),(3,'Sok od jabuke',130);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `brojracuna` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `datumracuna` date DEFAULT NULL,
  `poslovnipartnerid` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ukupaniznos` double DEFAULT NULL,
  PRIMARY KEY (`brojracuna`),
  KEY `poslovnipartner_fk` (`poslovnipartnerid`),
  CONSTRAINT `poslovnipartner_fk` FOREIGN KEY (`poslovnipartnerid`) REFERENCES `pravnolice` (`maticni_broj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `racun` */

insert  into `racun`(`brojracuna`,`datumracuna`,`poslovnipartnerid`,`ukupaniznos`) values ('1','2001-01-01','m4',NULL),('2','2002-02-02','m4',NULL);

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `racunid` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `rb` int(11) NOT NULL,
  `proizvodid` int(11) DEFAULT NULL,
  `kolicina` double DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `iznos` double DEFAULT NULL,
  PRIMARY KEY (`racunid`,`rb`),
  KEY `proizvod_fk` (`proizvodid`),
  CONSTRAINT `proizvod_fk` FOREIGN KEY (`proizvodid`) REFERENCES `proizvod` (`sifra`),
  CONSTRAINT `racun_fk` FOREIGN KEY (`racunid`) REFERENCES `racun` (`brojracuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`racunid`,`rb`,`proizvodid`,`kolicina`,`cena`,`iznos`) values ('1',1,1,1,20,20),('1',2,2,2,50,100),('2',1,1,1,20,20),('2',2,3,2,130,260);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
