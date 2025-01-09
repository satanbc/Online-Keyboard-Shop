-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `ordered_items`
--

DROP TABLE IF EXISTS `ordered_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordered_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `ordered_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `ordered_items_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_items`
--

LOCK TABLES `ordered_items` WRITE;
/*!40000 ALTER TABLE `ordered_items` DISABLE KEYS */;
INSERT INTO `ordered_items` VALUES (1,1,4,1,179.00),(2,1,1,1,159.00),(3,2,1,1,159.00),(4,2,2,1,169.00),(5,3,1,1,159.00),(6,4,1,1,159.00),(7,5,1,1,159.00),(8,7,1,1,159.00),(9,8,2,1,169.00),(10,9,2,1,169.00),(11,10,1,1,159.00),(12,11,1,1,159.00),(13,12,1,1,159.00),(14,13,2,1,169.00),(15,14,2,1,169.00),(16,14,2,1,169.00),(17,15,1,1,159.00),(18,16,2,1,169.00),(19,17,1,1,159.00),(20,19,2,1,169.00),(21,20,1,1,159.00),(22,21,1,1,159.00),(23,22,1,1,159.00),(24,23,1,1,159.00),(25,24,1,1,159.00),(26,25,1,1,159.00),(27,26,1,1,159.00),(28,27,1,1,159.00),(29,28,1,1,159.00),(30,29,3,1,230.00),(31,29,1,1,159.00),(32,30,1,1,159.00),(33,30,1,1,159.00);
/*!40000 ALTER TABLE `ordered_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Матвей Сергеевич Володовский','matrundelpro@gmail.com','ул. Стадионная 6А',338.00,'2023-05-07'),(2,'Матвей Сергеевич Володовский','matrundelpro@gmail.com','ул. Стадионная 6А',328.00,'2023-05-07'),(3,'Матвей Сергеевич Володовский','matrundelpro@gmail.com','ул. Стадионная 6А',159.00,'2023-05-07'),(4,'Матвей Сергеевич Володовский','matrundelpro@gmail.com','ул. Стадионная 6А',159.00,'2023-05-13'),(5,'Матвей Сергеевич Володовский','matrundelpro@gmail.com','ул. Стадионная 6А',159.00,'2023-05-13'),(6,'Матвей Сергеевич Володовский','matrundelpro@gmail.com','ул. Стадионная 6А',0.00,'2023-05-13'),(7,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-13'),(8,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',169.00,'2023-05-13'),(9,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',169.00,'2023-05-13'),(10,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-13'),(11,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-13'),(12,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-13'),(13,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',169.00,'2023-05-13'),(14,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',338.00,'2023-05-13'),(15,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-13'),(16,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',169.00,'2023-05-14'),(17,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(18,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',0.00,'2023-05-14'),(19,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',169.00,'2023-05-14'),(20,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(21,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(22,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(23,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(24,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(25,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(26,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(27,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(28,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',159.00,'2023-05-14'),(29,'Matvii Volodovskyi','satanbbc@gmail.com','27 Merry Lane NP000424285',389.00,'2023-05-14'),(30,'Матвей Сергеевич Володовский','matrundelpro@gmail.com','ул. Стадионная 6А',318.00,'2023-05-14');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(10,2) NOT NULL,
  `stock` int NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Wuque Zoom 65','65% gasket mount hot-swappable keyboard',159.00,100,'https://storage.googleapis.com/mkeu-store-media/cache/3d/f7/3df71051ac9caa0c1a3c3d32e7506101.jpg'),(2,'Glorious GMMK Pro','75% gasket mount hot-swappable keyboard',169.00,50,'https://m.media-amazon.com/images/I/71ljl2uUEHL.jpg'),(3,'KBDFans KBD75','75% gasket mount hot-swappable keyboard',230.00,50,'https://cdn.shopify.com/s/files/1/0583/7163/7380/products/kbd75v2_f08359e9-bae6-478c-a370-4516bbf36c71_1000x.jpg?v=1658752938'),(4,'Keychron Q1','75% gasket mount hot-swappable keyboard',179.00,50,'https://ae01.alicdn.com/kf/S561ff4bb397b471fa48869b5e6089494A/Keychron-Q1-V2-QMK-Fully-Assembled-Custom-Mechanical-Keyboard-75-Layout-Type-C-Wired-Keyboards-for.png_.webp');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-15  0:35:13
