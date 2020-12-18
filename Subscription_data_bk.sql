-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: subscription
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
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupon` (
  `coupon_id` int NOT NULL AUTO_INCREMENT,
  `coupon_type` varchar(50) DEFAULT NULL,
  `coupon_detail` varchar(50) DEFAULT NULL,
  `coupon_start_code` int DEFAULT NULL,
  `coupon_partner` varchar(200) DEFAULT NULL,
  `no_of_coupons` int DEFAULT NULL,
  `coupon_validity` varchar(200) DEFAULT NULL,
  `coupon_discount` varchar(200) DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--

LOCK TABLES `coupon` WRITE;
/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `discount_id` int NOT NULL AUTO_INCREMENT,
  `discount` varchar(100) DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_type`
--

DROP TABLE IF EXISTS `plan_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_type` (
  `plan_type_id` int NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(200) DEFAULT NULL,
  `plan_type` varchar(200) DEFAULT NULL,
  `plan_active` char(1) DEFAULT NULL,
  `discount_id` int DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`plan_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_type`
--

LOCK TABLES `plan_type` WRITE;
/*!40000 ALTER TABLE `plan_type` DISABLE KEYS */;
INSERT INTO `plan_type` VALUES (6,'OneTime_Plan','Permanent','Y',0,'2020-12-15 11:00:14','2020-12-15 11:00:14'),(7,'Prime_Plan','Permanent','Y',0,'2020-12-16 10:07:17','2020-12-16 10:07:17');
/*!40000 ALTER TABLE `plan_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(200) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `level_id` int DEFAULT NULL,
  `payment_freq_id` int DEFAULT NULL,
  `exam_flag` char(1) DEFAULT NULL,
  `exam_day` varchar(50) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `exam_quantity` int DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK5cypb0k23bovo3rn1a5jqs6j4` (`category_id`),
  KEY `FKay4n9iiytriynf8q5r5gywaiu` (`level_id`),
  CONSTRAINT `FK5cypb0k23bovo3rn1a5jqs6j4` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`category_id`),
  CONSTRAINT `FKay4n9iiytriynf8q5r5gywaiu` FOREIGN KEY (`level_id`) REFERENCES `product_level` (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Study Gear For Kanken',6,7,NULL,'Y','Sunday',200.34,2,'2020-12-15 12:46:40','2020-12-15 12:46:40'),(2,'Study Gear For Suken',7,8,NULL,'Y','Monday',354.23,4,'2020-12-15 17:58:16','2020-12-15 17:58:16'),(3,'Study Gear For Maths',8,9,NULL,'Y','Monday',354.23,4,'2020-12-17 07:46:48','2020-12-17 07:46:48');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (2,'Exam','2020-12-15 06:35:03','2020-12-15 06:35:03'),(3,'Study','2020-12-15 06:35:03','2020-12-15 06:35:03'),(4,'Exam','2020-12-15 10:57:41','2020-12-15 10:57:41'),(5,'Study','2020-12-15 10:57:41','2020-12-15 10:57:41'),(6,'Exam2','2020-12-15 12:46:40','2020-12-15 12:46:40'),(7,'StudyAndExam','2020-12-15 17:58:16','2020-12-15 17:58:16'),(8,'StudyAndExam','2020-12-17 07:46:48','2020-12-17 07:46:48');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_level`
--

DROP TABLE IF EXISTS `product_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_level` (
  `level_id` int NOT NULL AUTO_INCREMENT,
  `level_name` varchar(50) DEFAULT NULL,
  `Product_name` varchar(200) DEFAULT NULL,
  `level_no` double(10,2) DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_level`
--

LOCK TABLES `product_level` WRITE;
/*!40000 ALTER TABLE `product_level` DISABLE KEYS */;
INSERT INTO `product_level` VALUES (3,'Level 1.5','Study Gear For Eiken',1.50,'2020-12-15 06:52:38','2020-12-15 06:52:38'),(4,'Level 2','Study Gear For Eiken',2.00,'2020-12-15 06:52:38','2020-12-15 06:52:38'),(5,'Level 1.5','Study Gear For Eiken',1.50,'2020-12-15 10:57:41','2020-12-15 10:57:41'),(6,'Level 2','Study Gear For Eiken',2.00,'2020-12-15 10:57:41','2020-12-15 10:57:41'),(7,'Level 1','Study Gear For Kanken',1.00,'2020-12-15 12:46:40','2020-12-15 12:46:40'),(8,'Level 4','Study Gear For Suken',4.00,'2020-12-15 17:58:16','2020-12-15 17:58:16'),(9,'Level 4','Study Gear For Suken',4.00,'2020-12-17 07:46:48','2020-12-17 07:46:48');
/*!40000 ALTER TABLE `product_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_services`
--

DROP TABLE IF EXISTS `product_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_services` (
  `product_service_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `service_id` int NOT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`product_service_id`),
  KEY `FKm5u3dxw3unj9jnliv9pe3ubrj` (`product_id`),
  KEY `FKo04q01prge596s846et1hq39u` (`service_id`),
  CONSTRAINT `FKm5u3dxw3unj9jnliv9pe3ubrj` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKo04q01prge596s846et1hq39u` FOREIGN KEY (`service_id`) REFERENCES `service_master` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_services`
--

LOCK TABLES `product_services` WRITE;
/*!40000 ALTER TABLE `product_services` DISABLE KEYS */;
INSERT INTO `product_services` VALUES (1,2,1,NULL,NULL),(2,1,2,NULL,NULL),(3,3,3,NULL,NULL),(4,1,1,NULL,NULL),(5,1,3,NULL,NULL),(6,2,2,NULL,NULL),(7,2,3,NULL,NULL),(8,3,1,NULL,NULL),(9,3,2,NULL,NULL);
/*!40000 ALTER TABLE `product_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_master`
--

DROP TABLE IF EXISTS `service_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_master` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `service_name` varchar(100) DEFAULT NULL,
  `service_desc` varchar(500) DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_master`
--

LOCK TABLES `service_master` WRITE;
/*!40000 ALTER TABLE `service_master` DISABLE KEYS */;
INSERT INTO `service_master` VALUES (1,'Partial','Partial_Access','2020-12-15 17:58:16','2020-12-15 17:58:16'),(2,'Full','Full_Access',NULL,NULL),(3,'Half','Half_Access','2020-12-17 07:46:48','2020-12-17 07:46:48');
/*!40000 ALTER TABLE `service_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription_plan`
--

DROP TABLE IF EXISTS `subscription_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription_plan` (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `plan_type_id` int DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `price_mode` varchar(50) DEFAULT NULL,
  `credit` int DEFAULT NULL,
  `credit_mode` varchar(50) DEFAULT NULL,
  `free_period` varchar(50) DEFAULT NULL,
  `discount` double(10,2) DEFAULT NULL,
  `plan_start_date` timestamp NULL DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`plan_id`),
  KEY `FK7vq0esh2viudqxuammpvmajl1` (`plan_type_id`),
  CONSTRAINT `FK7vq0esh2viudqxuammpvmajl1` FOREIGN KEY (`plan_type_id`) REFERENCES `plan_type` (`plan_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription_plan`
--

LOCK TABLES `subscription_plan` WRITE;
/*!40000 ALTER TABLE `subscription_plan` DISABLE KEYS */;
INSERT INTO `subscription_plan` VALUES (4,6,100.23,'Credit_Card_Payment',10,'Online_Buying','100 Days',10.34,'2020-12-15 11:00:14','2020-12-15 11:00:14','2020-12-15 11:00:14'),(5,7,500.50,'NetBanking_Payment',10,'Online_Mode_Only','14 Days',3.50,'2020-12-16 10:07:17','2020-12-16 10:07:17','2020-12-16 10:07:17');
/*!40000 ALTER TABLE `subscription_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription_plan_prod`
--

DROP TABLE IF EXISTS `subscription_plan_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription_plan_prod` (
  `subs_plan_prod_id` int NOT NULL AUTO_INCREMENT,
  `plan_id` int NOT NULL,
  `product_id` int NOT NULL,
  `product_service_id` int DEFAULT NULL,
  `sys_created_date` timestamp NULL DEFAULT NULL,
  `sys_updated_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`subs_plan_prod_id`),
  KEY `FKtbes8h5ecf1b3qlbmr7upq4yo` (`product_id`),
  KEY `FKbycaqy7wmcy73t3aauqo1kifx` (`plan_id`),
  CONSTRAINT `FKbycaqy7wmcy73t3aauqo1kifx` FOREIGN KEY (`plan_id`) REFERENCES `subscription_plan` (`plan_id`),
  CONSTRAINT `FKtbes8h5ecf1b3qlbmr7upq4yo` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription_plan_prod`
--

LOCK TABLES `subscription_plan_prod` WRITE;
/*!40000 ALTER TABLE `subscription_plan_prod` DISABLE KEYS */;
INSERT INTO `subscription_plan_prod` VALUES (1,4,2,1,NULL,NULL),(2,5,1,4,NULL,NULL),(3,5,2,1,NULL,NULL),(4,5,3,8,NULL,NULL);
/*!40000 ALTER TABLE `subscription_plan_prod` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-18 15:27:41
