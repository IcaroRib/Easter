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
  `qtyDislikes` int(11) NOT NULL DEFAULT '0',
  `idEasterEgg` int(11) NOT NULL,
  PRIMARY KEY (`idComment`),
  KEY `fk_Comentario_EasterEgg1_idx` (`idEasterEgg`),
  CONSTRAINT `fk_Comentario_EasterEgg1` FOREIGN KEY (`idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
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
  PRIMARY KEY (`idEasterEgg`),
  KEY `fk_EasterEgg_Obra1_idx` (`idMedia`),
  KEY `fk_EasterEgg_Usuario1_idx` (`idWritter`),
  CONSTRAINT `fk_EasterEgg_Obra1` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EasterEgg_Usuario1` FOREIGN KEY (`idWritter`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `easteregg`
--

LOCK TABLES `easteregg` WRITE;
/*!40000 ALTER TABLE `easteregg` DISABLE KEYS */;
/*!40000 ALTER TABLE `easteregg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eastereggfavorited`
--

DROP TABLE IF EXISTS `eastereggfavorited`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eastereggfavorited` (
  `User_idUser` int(11) NOT NULL,
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `status` float DEFAULT NULL,
  PRIMARY KEY (`User_idUser`,`EasterEgg_idEasterEgg`),
  KEY `fk_Usuario_has_EasterEgg_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  KEY `fk_Usuario_has_EasterEgg_Usuario1_idx` (`User_idUser`),
  CONSTRAINT `fk_Usuario_has_EasterEgg_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_EasterEgg_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eastereggfavorited`
--

LOCK TABLES `eastereggfavorited` WRITE;
/*!40000 ALTER TABLE `eastereggfavorited` DISABLE KEYS */;
/*!40000 ALTER TABLE `eastereggfavorited` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluatecomment`
--

DROP TABLE IF EXISTS `evaluatecomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluatecomment` (
  `Comment_idComment` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `evaluate` tinyint(1) NOT NULL,
  PRIMARY KEY (`Comment_idComment`,`User_idUser`),
  KEY `fk_Comentario_has_Usuario_Usuario1_idx` (`User_idUser`),
  KEY `fk_Comentario_has_Usuario_Comentario1_idx` (`Comment_idComment`),
  CONSTRAINT `fk_Comentario_has_Usuario_Comentario1` FOREIGN KEY (`Comment_idComment`) REFERENCES `comment` (`idComment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_has_Usuario_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluatecomment`
--

LOCK TABLES `evaluatecomment` WRITE;
/*!40000 ALTER TABLE `evaluatecomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluatecomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluateeasteregg`
--

DROP TABLE IF EXISTS `evaluateeasteregg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluateeasteregg` (
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`EasterEgg_idEasterEgg`,`User_idUser`),
  KEY `fk_EasterEgg_has_Usuario_Usuario1_idx` (`User_idUser`),
  KEY `fk_EasterEgg_has_Usuario_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  CONSTRAINT `fk_EasterEgg_has_Usuario_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_EasterEgg_has_Usuario_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluateeasteregg`
--

LOCK TABLES `evaluateeasteregg` WRITE;
/*!40000 ALTER TABLE `evaluateeasteregg` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluateeasteregg` ENABLE KEYS */;
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
  `image` varchar(250) NOT NULL,
  PRIMARY KEY (`idMedia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media`
--

LOCK TABLES `media` WRITE;
/*!40000 ALTER TABLE `media` DISABLE KEYS */;
/*!40000 ALTER TABLE `media` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mediafavorited`
--

DROP TABLE IF EXISTS `mediafavorited`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mediafavorited` (
  `User_idUser` int(11) NOT NULL,
  `Media_idMedia` int(11) NOT NULL,
  PRIMARY KEY (`User_idUser`,`Media_idMedia`),
  KEY `fk_Usuario_has_Obra_Obra1_idx` (`Media_idMedia`),
  KEY `fk_Usuario_has_Obra_Usuario_idx` (`User_idUser`),
  CONSTRAINT `fk_Usuario_has_Obra_Usuario` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Obra_Obra1` FOREIGN KEY (`Media_idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mediafavorited`
--

LOCK TABLES `mediafavorited` WRITE;
/*!40000 ALTER TABLE `mediafavorited` DISABLE KEYS */;
/*!40000 ALTER TABLE `mediafavorited` ENABLE KEYS */;
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
  PRIMARY KEY (`idTask`),
  KEY `fk_Task_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  CONSTRAINT `fk_Task_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
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
  `userName` varchar(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `imageUrl` varchar(250) DEFAULT NULL,
  `email` varchar(55) NOT NULL,
  `profileName` varchar(250) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  UNIQUE KEY `profileName_UNIQUE` (`profileName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'icaroribeiro',20,'Male','','icaro_felipe@hotmail.com','Icaro Ribeiro','123');
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

-- Dump completed on 2016-04-30 18:47:51
