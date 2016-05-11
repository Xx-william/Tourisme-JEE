-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: tourism
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(45) NOT NULL,
  `country_region` varchar(45) NOT NULL,
  `country_hckey` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'France','Europe','fr'),(2,'Espagne','Europe','es'),(3,'Italie','Europe','it'),(4,'Etas-Unis','Amérique','us'),(6,'Chine','Asie et Pacifique','cn'),(7,'Turquie','Moyen-Orient','tr'),(8,'Allemagne','Europe','de'),(9,'Royaume-Uni','Europe','gb'),(10,'Russie','Asie et Pacifique','ru'),(11,'Malaisie','Asie et Pacifique','my'),(12,'Autriche','Europe','at'),(13,'Hong Kong','Asie et Pacifique','hk'),(14,'Mexique','Amérique','mx'),(15,'Ukraine','Europe','ua'),(16,'Thaïlande','Asie et Pacifique','th'),(17,'Canada','Amerique','ca'),(18,'Grèce','Europe','gr'),(19,'Pologne','Europe','pl'),(20,'Arabie saoudite','Moyen-Orient','sa'),(21,'Macao','Asie et Pacifique','mc'),(22,'Australie','Asie et Pacifique','au'),(23,'Singapour','Asie et Pacifique','sg'),(24,'Inde','Asie et Pacifique','in'),(25,'Suisse','Europe','ch'),(26,'Suède','Europe','se'),(27,'Japon','Asie et Pacifique','jp');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-11 14:29:44
