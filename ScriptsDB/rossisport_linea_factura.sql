CREATE DATABASE  IF NOT EXISTS `rossisport` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rossisport`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: rossisport
-- ------------------------------------------------------
-- Server version	5.5.25a

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
-- Table structure for table `linea_factura`
--

DROP TABLE IF EXISTS `linea_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linea_factura` (
  `factura` int(11) NOT NULL,
  `linea` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `codigo` varchar(500) NOT NULL,
  `talle` varchar(10) NOT NULL,
  `color` varchar(100) NOT NULL,
  `precio` varchar(100) NOT NULL,
  PRIMARY KEY (`factura`,`linea`),
  KEY `factura_a_idx` (`factura`),
  KEY `codigo_e_idx` (`codigo`),
  KEY `talle_e_idx` (`talle`),
  KEY `color_idx` (`color`),
  CONSTRAINT `codigo_e` FOREIGN KEY (`codigo`) REFERENCES `descripciones` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `color_e` FOREIGN KEY (`color`) REFERENCES `colores` (`Color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `factura_a` FOREIGN KEY (`factura`) REFERENCES `facturas` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `talle_e` FOREIGN KEY (`talle`) REFERENCES `talles` (`talle`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-05 20:13:39
