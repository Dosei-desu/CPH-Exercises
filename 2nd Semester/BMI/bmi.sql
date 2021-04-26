CREATE DATABASE  IF NOT EXISTS `bmi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bmi`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bmi
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bmi_entry`
--

DROP TABLE IF EXISTS `bmi_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bmi_entry` (
  `bmi_entry_id` int NOT NULL AUTO_INCREMENT,
  `height` int NOT NULL,
  `weight` int NOT NULL,
  `category` varchar(20) NOT NULL,
  `bmi` float NOT NULL,
  `gender` varchar(20) NOT NULL,
  `sport_id` int NOT NULL,
  `user_id` int NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bmi_entry_id`),
  KEY `fk_bmi_entry_users_idx` (`user_id`),
  KEY `fk_bmi_entry_sport1_idx` (`sport_id`),
  CONSTRAINT `fk_bmi_entry_sport1` FOREIGN KEY (`sport_id`) REFERENCES `sport` (`sport_id`),
  CONSTRAINT `fk_bmi_entry_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bmi_entry`
--

LOCK TABLES `bmi_entry` WRITE;
/*!40000 ALTER TABLE `bmi_entry` DISABLE KEYS */;
INSERT INTO `bmi_entry` VALUES (1,180,80,'Normal',24.6914,'Nonconformist',4,5,'2021-04-20 20:38:49'),(7,190,86,'Normal',23.8227,'Male',2,5,'2021-04-20 21:11:44'),(10,192,86,'Normal',23.329,'Male',2,6,'2021-04-20 21:33:44'),(11,140,60,'Obese',30.6122,'Male',3,1,'2021-04-20 21:50:59'),(12,190,82,'Normal',22.7147,'Male',2,6,'2021-04-20 23:06:01'),(13,150,25,'Underweight',11.1111,'Nonconformist',2,1,'2021-04-20 23:17:27'),(14,200,95,'Normal',23.75,'Nonconformist',3,4,'2021-04-21 19:12:21'),(15,200,105,'Overweight',26.25,'Nonconformist',3,4,'2021-04-21 19:12:30'),(16,200,69,'Underweight',17.25,'Nonconformist',3,4,'2021-04-21 19:12:41'),(17,12,6,'Obese',416.667,'Nonconformist',1,5,'2021-04-21 20:18:54'),(18,12,3,'Obese',208.333,'Nonconformist',1,5,'2021-04-21 20:20:39'),(19,123,32,'Normal',21.1514,'Male',3,1,'2021-04-21 20:22:32'),(20,192,85,'Normal',23.0577,'Nonconformist',2,1,'2021-04-21 20:41:58'),(21,192,85,'Normal',23.0577,'Nonconformist',2,1,'2021-04-21 20:42:10'),(22,192,85,'Normal',23.0577,'Nonconformist',2,1,'2021-04-21 20:42:38'),(23,192,85,'Normal',23.0577,'Nonconformist',2,1,'2021-04-21 20:43:03'),(24,192,85,'Normal',23.0577,'Nonconformist',2,1,'2021-04-21 20:45:32'),(25,192,85,'Normal',23.0577,'Nonconformist',2,1,'2021-04-21 20:45:49'),(26,1,1,'Obese',10000,'Male',1,1,'2021-04-21 20:54:18'),(27,1,1,'Obese',10000,'Male',3,1,'2021-04-21 20:54:31'),(28,1,1,'Obese',10000,'Female',3,1,'2021-04-21 21:03:59');
/*!40000 ALTER TABLE `bmi_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hobby`
--

DROP TABLE IF EXISTS `hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hobby` (
  `hobby_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`hobby_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hobby`
--

LOCK TABLES `hobby` WRITE;
/*!40000 ALTER TABLE `hobby` DISABLE KEYS */;
INSERT INTO `hobby` VALUES (1,'Avalanche Sledding'),(2,'Playing with my 18 cats'),(3,'Bungee-jumping while knitting'),(4,'Wondering where my life went so wrong'),(5,'Building model trains (I\'m not a serial killer... yet)'),(6,'Disassociating in the shower');
/*!40000 ALTER TABLE `hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `link_bmi_hobby`
--

DROP TABLE IF EXISTS `link_bmi_hobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `link_bmi_hobby` (
  `hobby_id` int NOT NULL,
  `bmi_entry_id` int NOT NULL,
  PRIMARY KEY (`hobby_id`,`bmi_entry_id`),
  KEY `fk_link_bmi_hobby_bmi_entry1_idx` (`bmi_entry_id`),
  CONSTRAINT `fk_link_bmi_hobby_bmi_entry1` FOREIGN KEY (`bmi_entry_id`) REFERENCES `bmi_entry` (`bmi_entry_id`),
  CONSTRAINT `fk_link_bmi_hobby_hobby1` FOREIGN KEY (`hobby_id`) REFERENCES `hobby` (`hobby_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `link_bmi_hobby`
--

LOCK TABLES `link_bmi_hobby` WRITE;
/*!40000 ALTER TABLE `link_bmi_hobby` DISABLE KEYS */;
INSERT INTO `link_bmi_hobby` VALUES (1,1),(2,1),(4,1),(6,1),(3,7),(6,7),(1,10),(5,10),(6,10),(1,11),(2,11),(1,12),(2,12),(3,12),(2,13),(3,13),(2,14),(2,15),(2,16),(3,17),(4,17),(3,18),(1,19),(1,20),(2,20),(6,20),(1,21),(2,21),(6,21),(1,22),(2,22),(6,22),(1,23),(2,23),(6,23),(1,24),(2,24),(6,24),(1,25),(2,25),(6,25),(1,26),(1,27),(2,28),(3,28);
/*!40000 ALTER TABLE `link_bmi_hobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sport`
--

DROP TABLE IF EXISTS `sport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sport` (
  `sport_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`sport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sport`
--

LOCK TABLES `sport` WRITE;
/*!40000 ALTER TABLE `sport` DISABLE KEYS */;
INSERT INTO `sport` VALUES (1,'Free-diving'),(2,'Extreme Fishing'),(3,'Golf (really!?)'),(4,'4D Chess');
/*!40000 ALTER TABLE `sport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'guest','guest','guest'),(2,'ken@world.com','jensen','customer'),(3,'robin@gotham.com','batman','employee'),(4,'tester','test','employee'),(5,'rootie','root','employee'),(6,'ryan@ryan.us','freedoom','customer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-24 23:42:30
