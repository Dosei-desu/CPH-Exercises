/* 
-- sql init code

CREATE DATABASE  IF NOT EXISTS `bmi`;
USE `bmi`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES 
(1,'barbie@world.dk','jensen','customer'),
(2,'ken@world.com','jensen','customer'),
(3,'robin@gotham.com','batman','employee');
UNLOCK TABLES;
*/

SELECT bmi_entry_id, users.email, users.id, users.`role`, bmi_entry.bmi, bmi_entry.category FROM bmi.bmi_entry, bmi.users WHERE bmi_entry.user_id = users.id;