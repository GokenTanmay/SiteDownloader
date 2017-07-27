-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sitedownloader_schema
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `idTasks` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`idTasks`),
  UNIQUE KEY `idTasks_UNIQUE` (`idTasks`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'2017-07-27 11:08:00','2017-07-27 11:08:01'),(2,'2017-07-27 11:08:02','2017-07-27 13:18:23'),(3,'2017-07-27 13:19:10','2017-07-27 13:19:10'),(4,'2017-07-27 13:34:16','2017-07-27 13:34:16'),(5,'2017-07-27 13:34:29','2017-07-27 13:51:17'),(6,'2017-07-27 13:51:22','2017-07-27 13:51:22'),(7,'2017-07-27 13:51:32',NULL);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmpscanurls`
--

DROP TABLE IF EXISTS `tmpscanurls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmpscanurls` (
  `url` text NOT NULL,
  `scaned` tinyint(1) DEFAULT '0',
  `deeplevel` int(11) DEFAULT '0',
  `worker` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmpscanurls`
--

LOCK TABLES `tmpscanurls` WRITE;
/*!40000 ALTER TABLE `tmpscanurls` DISABLE KEYS */;
INSERT INTO `tmpscanurls` VALUES ('http://test1.url',0,0,'wrk1'),('http://test2.url',0,0,'wrk1'),('http://test3.url',0,5,NULL),('http://test4.url',0,4,NULL);
/*!40000 ALTER TABLE `tmpscanurls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sitedownloader_schema'
--

--
-- Dumping routines for database 'sitedownloader_schema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-27 16:49:19
