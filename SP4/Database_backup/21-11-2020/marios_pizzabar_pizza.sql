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
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pizza` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `ingredients` varchar(85) NOT NULL,
  `price` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (1,'Pepe','Tomato,Cheese,Pepperoni','61.0'),(2,'Mario','Tomato,Cheese,Shawarma,Creme Fraiche,Chili','64.0'),(3,'Alfonso Special','Tomato,Cheese,Minced Beef,Onion,Chili','64.0'),(4,'Vesuvio','Tomato,Cheese,Ham','61.0'),(5,'Capricciosa','Tomato,Cheese,Ham,Mushroom','65.0'),(6,'Quatro','Tomato,Cheese,Ham,Pepperoni','67.0'),(7,'Delizia','Tomato,Cheese,Pepperoni,Paprika,Onion','67.0'),(8,'Hawaii','Tomato,Cheese,Ham,Pineapple','65.0'),(9,'Bacone','Tomato,Cheese,Ham,Pepperoni,Bacon','72.0'),(10,'Milano','Tomato,Cheese,Ham,Meat Sauce','70.0'),(11,'Balkoni','Tomato,Cheese,Ham,Bacon,Egg','61.0'),(12,'O Solo Mio','Tomato,Cheese,Ham,Bacon,Cocktail Shrimp','72.0'),(13,'Bari','Tomato,Cheese,Beef Sauce,Mushroom,Sliced Tomato','67.0'),(14,'Vegetariana','Tomato,Cheese,Mushroom,Onion,Paprika,Pineapple','72.0'),(15,'Torino','Tomato,Cheese,Shawarma,Mushroom,Onion','70.0'),(16,'Venicia','Tomato,Cheese,Shawarma,Mushroom,Gorgonzola','70.0'),(17,'Samos','Tomato,Cheese,Minced Beef,Mushroom,Chili','70.0'),(18,'Roma','Tomato,Cheese,Meat Strips,Mushroom,Paprika,Garlic','72.0'),(19,'Prince','Tomato,Cheese,Minced Beef,Pepperoni,Bacon,Onion','69.0'),(20,'Italiano','Tomato,Cheese,Meat Sauce,Onion','65.0'),(21,'Gorgonzola','Tomato,Cheese,Gorgonzola,Mushroom,Onion','67.0'),(22,'Parma','Tomato,Cheese,Prosciutto,Mushroom,Gorgonzola','72.0'),(23,'Mafioso','Tomato,Cheese,Prosciutto,Artichoke,Garlic','69.0'),(24,'Speciale','Tomato,Cheese,Shawarma,Chicken,Paprika,Jalapeno,Garlic','70.0'),(25,'Siciliana','Tomato,Cheese,Shawarma,Bacon,Pepperoni,Paprika','72.0'),(26,'Messi','Tomato,Cheese,Chicken,Bacon,Curry Powder','67.0'),(27,'Juventus','Tomato,Cheese,Chicken,Bacon,Egg','69.0'),(28,'Pollo','Tomato,Cheese,Chicken,Mushroom,Paprika','69.0'),(29,'Margherita','Tomato,Cheese','53.0'),(30,'Opera','Tomato,Cheese,Pepperoni,Mushroom','67.0'),(31,'Baron','Tomato,Cheese,Meat Strips,Pepperoni,Garlic','70.0'),(32,'Forza','Tomato,Cheese,Shawarma,Onion,Bearnaise Sauce','69.0'),(33,'Maldini','Tomato,Cheese,Shawarma,Chicken,Pepperoni,Onion','72.0'),(34,'Matador','Tomato,Cheese,Beef,Mushroom,Onion,Bearnaise Sauce','73.0'),(35,'The Kirby','Cheese,Gouda,Gorgonzola,Camembert,Emmentaler,Cream Cheese,Blue Cheese','69.0'),(36,'Unicorn','Glitter,Orphan Tears,Fairy Dust,Skittles','77.0'),(37,'Jack O\' Lantern','Pumpkin,A Stephen King Novel,The Ring DVD,Lit Candles,Canned Farts','66.0');
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-21 16:37:44
