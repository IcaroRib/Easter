CREATE DATABASE  IF NOT EXISTS `easter` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `easter`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: easter
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `idComment` int(11) NOT NULL AUTO_INCREMENT,
  `text` longtext NOT NULL,
  `date` date NOT NULL,
  `qtyLikes` int(11) NOT NULL DEFAULT '0',
  `idAuthor` int(11) NOT NULL,
  `qtyDislikes` int(11) NOT NULL DEFAULT '0',
  `idEasterEgg` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`idComment`),
  KEY `fk_Comentario_EasterEgg1_idx` (`idEasterEgg`),
  KEY `fk_idUser_idx` (`idAuthor`),
  CONSTRAINT `fk_Comentario_EasterEgg1` FOREIGN KEY (`idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idUser` FOREIGN KEY (`idAuthor`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'nunca iria imaginar LOL ','2016-04-06',0,8,0,5,'2016-05-15 20:46:13');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `easteregg`
--

DROP TABLE IF EXISTS `easteregg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `easteregg` (
  `idEasterEgg` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext NOT NULL,
  `imageUrl` varchar(45) DEFAULT NULL,
  `idMedia` int(11) NOT NULL,
  `idWritter` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`idEasterEgg`),
  KEY `fk_EasterEgg_Obra1_idx` (`idMedia`),
  KEY `fk_EasterEgg_Usuario1_idx` (`idWritter`),
  CONSTRAINT `fk_EasterEgg_Obra1` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EasterEgg_Usuario1` FOREIGN KEY (`idWritter`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `easteregg`
--

LOCK TABLES `easteregg` WRITE;
/*!40000 ALTER TABLE `easteregg` DISABLE KEYS */;
INSERT INTO `easteregg` VALUES (1,'finalAeon',NULL,3,1,'2016-05-01 00:00:00'),(2,'professor xavier',NULL,1,1,'2016-05-01 00:00:00'),(3,'x-men kk',NULL,1,8,'2016-05-01 00:00:00'),(4,'teste',NULL,6,8,'2016-05-01 00:00:00'),(5,'vencendo  o homem formiga',NULL,6,11,'2016-05-01 00:00:00');
/*!40000 ALTER TABLE `easteregg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluatedcomment`
--

DROP TABLE IF EXISTS `evaluatedcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluatedcomment` (
  `Comment_idComment` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `evaluate` tinyint(1) NOT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`Comment_idComment`,`User_idUser`),
  KEY `fk_Comentario_has_Usuario_Usuario1_idx` (`User_idUser`),
  KEY `fk_Comentario_has_Usuario_Comentario1_idx` (`Comment_idComment`),
  CONSTRAINT `fk_Comentario_has_Usuario_Comentario1` FOREIGN KEY (`Comment_idComment`) REFERENCES `comment` (`idComment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_has_Usuario_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluatedcomment`
--

LOCK TABLES `evaluatedcomment` WRITE;
/*!40000 ALTER TABLE `evaluatedcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluatedcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluatedeasteregg`
--

DROP TABLE IF EXISTS `evaluatedeasteregg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluatedeasteregg` (
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `score` float NOT NULL,
  `createdAt` datetime DEFAULT NULL,
  PRIMARY KEY (`EasterEgg_idEasterEgg`,`User_idUser`),
  KEY `fk_EasterEgg_has_Usuario_Usuario1_idx` (`User_idUser`),
  KEY `fk_EasterEgg_has_Usuario_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  CONSTRAINT `fk_EasterEgg_has_Usuario_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EasterEgg_has_Usuario_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluatedeasteregg`
--

LOCK TABLES `evaluatedeasteregg` WRITE;
/*!40000 ALTER TABLE `evaluatedeasteregg` DISABLE KEYS */;
INSERT INTO `evaluatedeasteregg` VALUES (1,1,4,'2016-05-01 22:34:39'),(1,8,4,'2016-05-01 22:35:43'),(1,11,3,'2016-05-21 21:46:09'),(2,1,2,'2016-05-01 22:34:56'),(2,8,3,'2016-05-01 22:35:37'),(2,11,4,'2016-05-21 21:46:05'),(3,1,1,'2016-05-21 21:53:42'),(3,8,2,'2016-05-21 21:55:02'),(3,11,1,'2016-05-21 21:52:21'),(4,1,2,'2016-05-21 21:53:19'),(4,8,4,'2016-05-21 21:55:24'),(4,11,4,'2016-05-21 21:52:38'),(5,1,3,'2016-05-21 21:43:43'),(5,8,1,'2016-05-21 21:45:40'),(5,11,3,'2016-05-21 21:45:58');
/*!40000 ALTER TABLE `evaluatedeasteregg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fallowedeasteregg`
--

DROP TABLE IF EXISTS `fallowedeasteregg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fallowedeasteregg` (
  `User_idUser` int(11) NOT NULL,
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `status` float NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`User_idUser`,`EasterEgg_idEasterEgg`),
  KEY `fk_Usuario_has_EasterEgg_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  KEY `fk_Usuario_has_EasterEgg_Usuario1_idx` (`User_idUser`),
  CONSTRAINT `fk_Usuario_has_EasterEgg_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_EasterEgg_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fallowedeasteregg`
--

LOCK TABLES `fallowedeasteregg` WRITE;
/*!40000 ALTER TABLE `fallowedeasteregg` DISABLE KEYS */;
INSERT INTO `fallowedeasteregg` VALUES (8,1,0,'2016-05-02 00:17:42'),(8,2,0,'2016-05-02 00:08:06');
/*!40000 ALTER TABLE `fallowedeasteregg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fallowedmedia`
--

DROP TABLE IF EXISTS `fallowedmedia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fallowedmedia` (
  `User_idUser` int(11) NOT NULL,
  `Media_idMedia` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`User_idUser`,`Media_idMedia`),
  KEY `fk_Usuario_has_Obra_Obra1_idx` (`Media_idMedia`),
  KEY `fk_Usuario_has_Obra_Usuario_idx` (`User_idUser`),
  CONSTRAINT `fk_Usuario_has_Obra_Obra1` FOREIGN KEY (`Media_idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Obra_Usuario` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fallowedmedia`
--

LOCK TABLES `fallowedmedia` WRITE;
/*!40000 ALTER TABLE `fallowedmedia` DISABLE KEYS */;
INSERT INTO `fallowedmedia` VALUES (8,1,'2016-05-02 00:05:59'),(8,2,'2016-05-02 00:16:28'),(8,3,'2016-05-02 00:17:42');
/*!40000 ALTER TABLE `fallowedmedia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fallowedtask`
--

DROP TABLE IF EXISTS `fallowedtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fallowedtask` (
  `idTask` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `status` double NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`idTask`,`idUser`),
  KEY `fk_Usuario_has_Task_User_idx` (`idUser`),
  CONSTRAINT `fk_Usuario_has_Task_Task` FOREIGN KEY (`idTask`) REFERENCES `task` (`idTask`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Task_User` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fallowedtask`
--

LOCK TABLES `fallowedtask` WRITE;
/*!40000 ALTER TABLE `fallowedtask` DISABLE KEYS */;
INSERT INTO `fallowedtask` VALUES (4,8,0,'2016-05-02 00:25:40'),(5,8,0,'2016-05-02 00:25:40'),(6,8,0,'2016-05-02 00:25:40');
/*!40000 ALTER TABLE `fallowedtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media`
--

DROP TABLE IF EXISTS `media`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media` (
  `idMedia` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(105) NOT NULL,
  `category` varchar(45) NOT NULL,
  `image` varchar(250) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`idMedia`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
INSERT INTO `media` VALUES (1,'deadpool','filme',NULL,'0000-00-00 00:00:00'),(2,'x-men 3','filme',NULL,'0000-00-00 00:00:00'),(3,'final fantasy','jogo',NULL,'0000-00-00 00:00:00'),(4,'harry potter','livro',NULL,'0000-00-00 00:00:00'),(5,'gintama','anime',NULL,'0000-00-00 00:00:00'),(6,'guerra civil','filme',NULL,'0000-00-00 00:00:00'),(7,'o império contra ataca','filme',NULL,'0000-00-00 00:00:00');
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reference`
--

DROP TABLE IF EXISTS `reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reference` (
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `Media_idMedia` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  `title` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`EasterEgg_idEasterEgg`,`Media_idMedia`),
  KEY `fk_EasterEgg_has_Obra_Obra1_idx` (`Media_idMedia`),
  KEY `fk_EasterEgg_has_Obra_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  CONSTRAINT `fk_EasterEgg_has_Obra_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EasterEgg_has_Obra_Obra1` FOREIGN KEY (`Media_idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
INSERT INTO `reference` VALUES (2,2,'2016-05-01 18:41:42',NULL),(5,7,'2016-05-15 17:15:01','Pernas do robô');
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `idTask` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`idTask`),
  KEY `fk_Task_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  CONSTRAINT `fk_Task_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (4,'paco 1',1,'2016-05-01 18:41:42'),(5,'paco 2',1,'2016-05-01 18:41:42'),(6,'paco 3',1,'2016-05-01 18:41:42');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `acessTokenFacebook` varchar(100) DEFAULT NULL,
  `userName` varchar(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `imageUrl` varchar(250) DEFAULT NULL,
  `email` varchar(55) NOT NULL,
  `profileName` varchar(250) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `acessTokenFacebook_UNIQUE` (`acessTokenFacebook`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'icaroribeiro',20,'Male','','icaro_felipe@hotmail.com','Icaro Ribeiro','123','2016-05-01 00:00:00'),(8,NULL,'icarofelipe',20,'Male','abcde','icarofeliperibeiro@gmail.com','Icaro Ribeiro','123','2016-05-01 00:00:00'),(11,'abcde','icaro.ribeiro13',20,'Male','','icarofeliperibeiro@gmail.com','Icaro Ribeiro',NULL,'2016-05-15 15:59:57');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'easter'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-22 15:09:47
