-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: app_exam
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id_address` bigint NOT NULL,
  `house_number` bigint DEFAULT NULL,
  `is_primary` bit(1) NOT NULL,
  `id_personal_information` bigint DEFAULT NULL,
  `postal_code` bigint DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `street` varchar(50) DEFAULT NULL,
  `town` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_address`),
  KEY `FK4dst2h3lon0pq6wveqdbr2gxa` (`id_personal_information`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,197,_binary '',1,1112,'NCR','New Manila','Quezon City'),(206,4455,_binary '\0',9,1290,'Rizal','Sta Rosa','Antipolo'),(207,32131,_binary '',9,1940,'Rizal','Bella','Binangoan'),(175,9888,_binary '',8,1940,'Rizal','Calumpang','Binangonan'),(166,466,_binary '',2,1940,'Rizal','Palangoy','Binangonan'),(167,20,_binary '\0',2,1920,'NCR','Twin Oks East Tower','Mandaluyong'),(174,333344,_binary '\0',8,1900,'Rizal','Rose','Mambog'),(210,0,_binary '\0',NULL,0,NULL,NULL,NULL),(204,231,_binary '\0',3,1288,'Batangas','Rizal','Batangas'),(205,777,_binary '',3,1990,'Rizal','Luna','May Bangkal'),(211,0,_binary '',NULL,0,NULL,NULL,NULL),(212,0,_binary '\0',NULL,0,NULL,NULL,NULL),(213,12321,_binary '',NULL,345,'RER','2342','SDFS'),(214,0,_binary '\0',NULL,0,NULL,NULL,NULL),(215,12321,_binary '',NULL,345,'RER','AAD','SDFS');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_gen`
--

DROP TABLE IF EXISTS `address_gen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_gen`
--

LOCK TABLES `address_gen` WRITE;
/*!40000 ALTER TABLE `address_gen` DISABLE KEYS */;
INSERT INTO `address_gen` VALUES (301);
/*!40000 ALTER TABLE `address_gen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id_contact` bigint NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `is_primary` bit(1) NOT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `id_personal_information` bigint DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_contact`),
  KEY `FKdjg89qb7phty7774qeb658o4p` (`id_personal_information`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (1,'jpm@gmail.com',_binary '','09109876543',1,'12345678'),(207,'jade@gmail.com',_binary '\0','09187723157',9,'9876676'),(175,'cgar@yahoo.com',_binary '\0','782421',8,'345345345'),(166,'pons.peter@gmail.com',_binary '','09088854427',2,'6521234'),(167,'char@gmail.com',_binary '\0','09989882131',2,'09081212312'),(206,'karenjade@yahoo.com',_binary '','980806786',9,'1288634'),(174,'aron@gmail.com',_binary '','09823832732',8,'127866636'),(204,'villaranda@yahoo.com',_binary '','09261422367',3,'091234567812'),(205,'emmantvilla@yahoo.com',_binary '\0','3345623434',3,'0977123');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_gen`
--

DROP TABLE IF EXISTS `contact_gen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_gen`
--

LOCK TABLES `contact_gen` WRITE;
/*!40000 ALTER TABLE `contact_gen` DISABLE KEYS */;
INSERT INTO `contact_gen` VALUES (301);
/*!40000 ALTER TABLE `contact_gen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id_employee` bigint NOT NULL,
  `date_hired` date NOT NULL,
  `position` varchar(250) NOT NULL,
  `status` int NOT NULL,
  `years_in_service` int NOT NULL,
  `id_personal_information` bigint DEFAULT NULL,
  PRIMARY KEY (`id_employee`),
  KEY `FKg56t7pgyh715d0vf5umm8prbx` (`id_personal_information`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'1992-01-01','Director',1,28,1),(2,'2011-12-31','Java Dev',1,8,2),(3,'2019-04-24','Sewer',1,1,3),(8,'2015-12-31','CFO',1,4,8),(9,'2016-02-08','Teacher',1,4,9);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_seq`
--

DROP TABLE IF EXISTS `employee_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_seq`
--

LOCK TABLES `employee_seq` WRITE;
/*!40000 ALTER TABLE `employee_seq` DISABLE KEYS */;
INSERT INTO `employee_seq` VALUES (11);
/*!40000 ALTER TABLE `employee_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_information`
--

DROP TABLE IF EXISTS `personal_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_information` (
  `id_personal_information` bigint NOT NULL,
  `age` int NOT NULL,
  `birth_date` date NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `marital_status` varchar(10) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_personal_information`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_information`
--

LOCK TABLES `personal_information` WRITE;
/*!40000 ALTER TABLE `personal_information` DISABLE KEYS */;
INSERT INTO `personal_information` VALUES (1,54,'1966-02-12','Jose','MALE','Manalo','MARRIED','P'),(2,39,'1981-07-26','Peter','MALE','Pons','SINGLE','S'),(3,27,'1993-01-11','Emman','MALE','Villaranda','SINGLE','T'),(8,28,'1992-01-02','Aron','MALE','Agonos','SINGLE','R'),(9,27,'1993-07-28','Karen','FEMALE','Lirio','SINGLE','C');
/*!40000 ALTER TABLE `personal_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_information_seq`
--

DROP TABLE IF EXISTS `personal_information_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_information_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_information_seq`
--

LOCK TABLES `personal_information_seq` WRITE;
/*!40000 ALTER TABLE `personal_information_seq` DISABLE KEYS */;
INSERT INTO `personal_information_seq` VALUES (11);
/*!40000 ALTER TABLE `personal_information_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` bigint NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `id_personal_information` bigint DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FK9gu33kfkmq9sp8e8dko658p0k` (`id_personal_information`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'$2a$10$Hktlt4yyx2ODZGNkEOuSk.t3F4DjNBhqnXHkdKu5SEJibpiivXxCu','ROLE_ADMIN','ACTIVE','MANALO_JOSE',1),(2,'$2a$10$xf7DBzz1lB6DfuupTi5W/eqPaDyk30s0k3Lz/rUe9WqlH9NXMrgdK','ROLE_STANDARD_USER','ACTIVE','PONS_PETER',2),(3,'$2a$10$dvtIz/R/Ft1FzxaVDYs2w.TlSxjUBYbCrLkVRqQWMIOpdoRuVltLu','ROLE_STANDARD_USER','ACTIVE','VILLARANDA_EMMAN',3),(8,'$2a$10$iuaosITJYWXR2GbsHWBhi.8lHb8z2wJ/jDw22/IIGXeQWW/Y0axCy','ROLE_STANDARD_USER','ACTIVE','AGONOS_ARON',8),(9,'$2a$10$8pUTVMV6pjk6OVD1i.nQfODaMYIUB/VPDnjFaxAUQcbsksfGnHYA6','ROLE_STANDARD_USER','ACTIVE','LIRIO_KAREN',9);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (11);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'app_exam'
--

--
-- Dumping routines for database 'app_exam'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-29 16:23:54
