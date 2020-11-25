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
-- Table structure for table `order_history`
--

DROP TABLE IF EXISTS `order_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_history` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `unique_id` varchar(4) NOT NULL,
  `delivered` tinyint(1) NOT NULL,
  `remote` tinyint(1) NOT NULL,
  `pizza_id` varchar(4) NOT NULL,
  `name` varchar(50) NOT NULL,
  `ingredients` varchar(85) NOT NULL,
  `price` varchar(8) NOT NULL,
  `customer` varchar(50) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_history`
--

LOCK TABLES `order_history` WRITE;
/*!40000 ALTER TABLE `order_history` DISABLE KEYS */;
INSERT INTO `order_history` VALUES (1,'2020-11-22 18:04:13','01',1,1,'29','Margherita','Tomato,Cheese','53.0','Kris','666'),(2,'2020-11-22 18:41:34','99',1,1,'35','The Kirby','Cheese,Gouda,Gorgonzola,Camembert,Emmentaler,Cream Cheese,Blue Cheese','69.0','Kirby','6969'),(3,'2020-11-22 18:41:34','99',1,1,'35','The Kirby','Cheese,Gouda,Gorgonzola,Camembert,Emmentaler,Cream Cheese,Blue Cheese','69.0','Kirby','6969'),(4,'2020-11-22 18:41:34','99',1,1,'29','Margherita','Tomato,Cheese','53.0','Kirby','6969'),(6,'2020-11-22 19:07:20','33',0,0,'29','Margherita','Tomato,Cheese','53.0','Definitely not Kris','221'),(8,'2020-11-22 21:42:55','58',0,0,'9','Bacone','Tomato,Cheese,Ham,Pepperoni,Bacon','72.0','Not kirby','321312'),(9,'2020-11-22 21:42:55','58',0,0,'37','Jack o\' lantern','Pumpkin,A stephen king novel,The ring dvd, Lit candles,Canned farts','66.0','Not kirby','321312'),(10,'2020-11-22 21:44:46','47',1,1,'0','Custom pizza','Tiny little helper musk,Snowflakes,Elf tears','85.0','Santi klaus','80085'),(11,'2020-11-22 21:46:42','18',1,0,'0','Custom pizza','Pool boy juice,Elf testies,Three lines of coke','85.0','Ms. klaus','83218'),(12,'2020-11-22 21:46:42','18',1,0,'36','Unicorn','Glitter,Orphan tears,Fairy dust,Skittles','77.0','Ms. klaus','83218'),(13,'2020-11-23 02:41:40','69',1,1,'0','Custom pizza','You','85.0','Mariah carey','1337'),(14,'2020-11-23 02:46:40','82',1,0,'23','Mafioso','Tomato,Cheese,Prosciutto,Artichoke,Garlic','69.0','Alexis','911'),(15,'2020-11-23 02:46:40','82',1,0,'0','Custom pizza','Chicken hearts,Chikuwa,Kaman furai,Takoyaki,Tako tamago','85.0','Alexis','911'),(20,'2020-11-23 14:50:00','79',0,0,'0','Custom pizza','Garlic,Surströmning,Cazu matzu,Literal putrification','85.0','Tester bob','32312312'),(21,'2020-11-23 19:43:17','19',1,1,'0','Custom pizza','Garrlicker,Snuff','85.0','Gurble','3421312'),(22,'2020-11-23 19:51:56','81',0,0,'18','Roma','Tomato,Cheese,Meat strips,Mushroom,Paprika,Garlic','72.0','Smurfufu','2312312'),(23,'2020-11-23 19:51:56','81',0,0,'2','Mario','Tomato,Cheese,Shawarma,Creme fraiche,Chili','64.0','Smurfufu','2312312'),(24,'2020-11-23 19:53:08','49',0,0,'3','Alfonso special','Tomato,Cheese,Minced beef,Onion,Chili','64.0','Skurlulu','321321'),(25,'2020-11-23 20:23:34','66',1,1,'21','Gorgonzola','Tomato,Cheese,Gorgonzola,Mushroom,Onion','67.0','Gorg on zola','444'),(26,'2020-11-23 20:23:35','66',1,1,'21','Gorgonzola','Tomato,Cheese,Gorgonzola,Mushroom,Onion','67.0','Gorg on zola','444'),(27,'2020-11-25 16:15:04','18',1,1,'9','Bacone','Tomato,Cheese,Ham,Pepperoni,Bacon','72.0','Timmy','242412'),(28,'2020-11-25 16:15:05','18',1,1,'0','Custom pizza','Cables,Wires,Electricity','85.0','Timmy','242412'),(29,'2020-11-25 20:28:49','14',0,0,'28','Pollo','Tomato,Cheese,Chicken,Mushroom,Paprika','69.0','Torvalt','99999');
/*!40000 ALTER TABLE `order_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-25 21:50:20
