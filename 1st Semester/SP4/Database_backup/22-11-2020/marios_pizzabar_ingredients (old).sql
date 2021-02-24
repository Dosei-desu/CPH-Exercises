-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: marios_pizzabar
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
-- Table structure for table `ingredients (old)`
--

DROP TABLE IF EXISTS `ingredients (old)`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredients (old)` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients (old)`
--

LOCK TABLES `ingredients (old)` WRITE;
/*!40000 ALTER TABLE `ingredients (old)` DISABLE KEYS */;
INSERT INTO `ingredients (old)` VALUES (1,'Tomato'),(2,'Cheese'),(3,'Pepperoni'),(4,'Shawarma'),(5,'Creme Fraiche'),(6,'Chili'),(7,'Minced Beef'),(8,'Onion'),(9,'Ham'),(10,'Mushroom'),(11,'Paprika'),(12,'Pineapple'),(13,'Bacon'),(14,'Meat Sauce'),(15,'Egg'),(16,'Cocktail Shrimp'),(18,'Beef Sauce'),(19,'Sliced Tomato'),(20,'Gorgonzola'),(21,'Meat Strips'),(22,'Garlic'),(23,'Prosciutto'),(24,'Artichoke'),(25,'Chicken'),(26,'Jalapeno'),(27,'Curry Powder'),(28,'Bearnaise Sauce'),(29,'Gouda'),(30,'Camembert'),(31,'Emmentaler'),(32,'Cream Cheese'),(33,'Blue Cheese'),(34,'Glitter'),(35,'Orphan Tears'),(36,'Fairy Dust'),(37,'Skittles'),(38,'Pumpkin'),(39,'A Stephen King Novel'),(40,'The Ring DVD'),(41,'Lit Candles'),(42,'Canned Farts'),(43,'Beef');
/*!40000 ALTER TABLE `ingredients (old)` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-22 23:19:02
