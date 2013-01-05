DROP DATABASE `rossisport`;
CREATE DATABASE  IF NOT EXISTS `rossisport` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rossisport`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: rossisport
-- ------------------------------------------------------
-- Server version	5.5.8

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
-- Table structure for table `estaciones`
--

DROP TABLE IF EXISTS `estaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estaciones` (
  `Estacion` varchar(45) NOT NULL,
  PRIMARY KEY (`Estacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estaciones`
--

LOCK TABLES `estaciones` WRITE;
/*!40000 ALTER TABLE `estaciones` DISABLE KEYS */;
INSERT INTO `estaciones` VALUES ('Invierno'),('Verano');
/*!40000 ALTER TABLE `estaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes`
--

DROP TABLE IF EXISTS `componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componentes` (
  `Componente` varchar(45) NOT NULL,
  PRIMARY KEY (`Componente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes`
--

LOCK TABLES `componentes` WRITE;
/*!40000 ALTER TABLE `componentes` DISABLE KEYS */;
INSERT INTO `componentes` VALUES ('Algodón'),('Poliester');
/*!40000 ALTER TABLE `componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talles`
--

DROP TABLE IF EXISTS `talles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talles` (
  `talle` varchar(45) NOT NULL,
  PRIMARY KEY (`talle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talles`
--

LOCK TABLES `talles` WRITE;
/*!40000 ALTER TABLE `talles` DISABLE KEYS */;
INSERT INTO `talles` VALUES ('1 S'),('2 M'),('3 L'),('4 XL'),('5 XXL');
/*!40000 ALTER TABLE `talles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lisafantasia`
--

DROP TABLE IF EXISTS `lisafantasia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lisafantasia` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lisafantasia`
--

LOCK TABLES `lisafantasia` WRITE;
/*!40000 ALTER TABLE `lisafantasia` DISABLE KEYS */;
INSERT INTO `lisafantasia` VALUES ('Fantasia'),('Lisa');
/*!40000 ALTER TABLE `lisafantasia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocampera`
--

DROP TABLE IF EXISTS `tipocampera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocampera` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocampera`
--

LOCK TABLES `tipocampera` WRITE;
/*!40000 ALTER TABLE `tipocampera` DISABLE KEYS */;
INSERT INTO `tipocampera` VALUES ('Hasta cintura'),('Hasta muslo');
/*!40000 ALTER TABLE `tipocampera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pinzas`
--

DROP TABLE IF EXISTS `pinzas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pinzas` (
  `Pinza` varchar(45) NOT NULL,
  PRIMARY KEY (`Pinza`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pinzas`
--

LOCK TABLES `pinzas` WRITE;
/*!40000 ALTER TABLE `pinzas` DISABLE KEYS */;
INSERT INTO `pinzas` VALUES ('0'),('1'),('2');
/*!40000 ALTER TABLE `pinzas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vbase`
--

DROP TABLE IF EXISTS `vbase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vbase` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vbase`
--

LOCK TABLES `vbase` WRITE;
/*!40000 ALTER TABLE `vbase` DISABLE KEYS */;
INSERT INTO `vbase` VALUES ('A la base'),('Escote V');
/*!40000 ALTER TABLE `vbase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopantalon`
--

DROP TABLE IF EXISTS `tipopantalon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopantalon` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopantalon`
--

LOCK TABLES `tipopantalon` WRITE;
/*!40000 ALTER TABLE `tipopantalon` DISABLE KEYS */;
INSERT INTO `tipopantalon` VALUES ('Sport'),('Vestir');
/*!40000 ALTER TABLE `tipopantalon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipotirador`
--

DROP TABLE IF EXISTS `tipotirador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipotirador` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipotirador`
--

LOCK TABLES `tipotirador` WRITE;
/*!40000 ALTER TABLE `tipotirador` DISABLE KEYS */;
INSERT INTO `tipotirador` VALUES ('Para botones'),('Pinzas');
/*!40000 ALTER TABLE `tipotirador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiporemera`
--

DROP TABLE IF EXISTS `tiporemera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiporemera` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiporemera`
--

LOCK TABLES `tiporemera` WRITE;
/*!40000 ALTER TABLE `tiporemera` DISABLE KEYS */;
INSERT INTO `tiporemera` VALUES ('Clasica'),('Polo'),('T-Shirt');
/*!40000 ALTER TABLE `tiporemera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mangas`
--

DROP TABLE IF EXISTS `mangas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mangas` (
  `Manga` varchar(45) NOT NULL,
  PRIMARY KEY (`Manga`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mangas`
--

LOCK TABLES `mangas` WRITE;
/*!40000 ALTER TABLE `mangas` DISABLE KEYS */;
INSERT INTO `mangas` VALUES ('Corta'),('Larga');
/*!40000 ALTER TABLE `mangas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locales`
--

DROP TABLE IF EXISTS `locales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locales` (
  `local` varchar(45) NOT NULL,
  PRIMARY KEY (`local`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locales`
--

LOCK TABLES `locales` WRITE;
/*!40000 ALTER TABLE `locales` DISABLE KEYS */;
INSERT INTO `locales` VALUES ('Deposito 1'),('Deposito 2');
/*!40000 ALTER TABLE `locales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuellos`
--

DROP TABLE IF EXISTS `cuellos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuellos` (
  `Cuello` varchar(45) NOT NULL,
  PRIMARY KEY (`Cuello`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuellos`
--

LOCK TABLES `cuellos` WRITE;
/*!40000 ALTER TABLE `cuellos` DISABLE KEYS */;
INSERT INTO `cuellos` VALUES ('Clasico'),('Combinado'),('Italiano');
/*!40000 ALTER TABLE `cuellos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `nombre` varchar(45) NOT NULL,
  `caracteristicas` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES ('Abrigo de paño',0),('Ambo',0),('Billetera',0),('Boxer',0),('Bufanda',0),('Buzo de punto',0),('Calzoncillo largo',0),('Camisa',0),('Camiseta',0),('Campera',0),('Campera de punto',0),('Chaleco de punto',0),('Cinturon',0),('Conjunto deportivo',0),('Corbata',0),('Gabardina',0),('Gemelos',0),('Guantes',0),('Medias',0),('Paño de cuello',0),('Pantalon',0),('Pañuelos en caja de 3',0),('Paraguas',0),('Piyama',0),('Remera',0),('Remera de punto',0),('Rutero',0),('Saco sport',0),('Sandalia',0),('Slip',0),('Sobretodo',0),('Tiradores',0),('Traje',0),('Zapatenis',0),('Zapato',0);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoestampado`
--

DROP TABLE IF EXISTS `tipoestampado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoestampado` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoestampado`
--

LOCK TABLES `tipoestampado` WRITE;
/*!40000 ALTER TABLE `tipoestampado` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoestampado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colores`
--

DROP TABLE IF EXISTS `colores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colores` (
  `Color` varchar(45) NOT NULL,
  PRIMARY KEY (`Color`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colores`
--

LOCK TABLES `colores` WRITE;
/*!40000 ALTER TABLE `colores` DISABLE KEYS */;
INSERT INTO `colores` VALUES ('Azul'),('Blanco'),('Negro');
/*!40000 ALTER TABLE `colores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lisorayado`
--

DROP TABLE IF EXISTS `lisorayado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lisorayado` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lisorayado`
--

LOCK TABLES `lisorayado` WRITE;
/*!40000 ALTER TABLE `lisorayado` DISABLE KEYS */;
INSERT INTO `lisorayado` VALUES ('Liso'),('Rayado');
/*!40000 ALTER TABLE `lisorayado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocinturon`
--

DROP TABLE IF EXISTS `tipocinturon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocinturon` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocinturon`
--

LOCK TABLES `tipocinturon` WRITE;
/*!40000 ALTER TABLE `tipocinturon` DISABLE KEYS */;
INSERT INTO `tipocinturon` VALUES ('Clasico'),('Cuerda'),('Reversible'),('Sport');
/*!40000 ALTER TABLE `tipocinturon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marcas` (
  `marca` varchar(45) NOT NULL,
  PRIMARY KEY (`marca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES ('Arrow');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vbotones`
--

DROP TABLE IF EXISTS `vbotones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vbotones` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vbotones`
--

LOCK TABLES `vbotones` WRITE;
/*!40000 ALTER TABLE `vbotones` DISABLE KEYS */;
INSERT INTO `vbotones` VALUES ('Con botones'),('Escote V');
/*!40000 ALTER TABLE `vbotones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cortolargo`
--

DROP TABLE IF EXISTS `cortolargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cortolargo` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cortolargo`
--

LOCK TABLES `cortolargo` WRITE;
/*!40000 ALTER TABLE `cortolargo` DISABLE KEYS */;
INSERT INTO `cortolargo` VALUES ('Corto'),('Largo');
/*!40000 ALTER TABLE `cortolargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telas`
--

DROP TABLE IF EXISTS `telas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telas` (
  `Tela` varchar(45) NOT NULL,
  PRIMARY KEY (`Tela`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telas`
--

LOCK TABLES `telas` WRITE;
/*!40000 ALTER TABLE `telas` DISABLE KEYS */;
/*!40000 ALTER TABLE `telas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipopack`
--

DROP TABLE IF EXISTS `tipopack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipopack` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipopack`
--

LOCK TABLES `tipopack` WRITE;
/*!40000 ALTER TABLE `tipopack` DISABLE KEYS */;
INSERT INTO `tipopack` VALUES ('Por 3'),('Unidad');
/*!40000 ALTER TABLE `tipopack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposuela`
--

DROP TABLE IF EXISTS `tiposuela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiposuela` (
  `Tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposuela`
--

LOCK TABLES `tiposuela` WRITE;
/*!40000 ALTER TABLE `tiposuela` DISABLE KEYS */;
INSERT INTO `tiposuela` VALUES ('Goma'),('Suela'),('Suela con ovalo');
/*!40000 ALTER TABLE `tiposuela` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `descripciones`
--

DROP TABLE IF EXISTS `descripciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descripciones` (
  `codigo` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `pinza` varchar(45) DEFAULT NULL,
  `tela` varchar(45) DEFAULT NULL,
  `estacion` varchar(45) DEFAULT NULL,
  `pantalon` varchar(45) DEFAULT NULL,
  `estampado` varchar(45) DEFAULT NULL,
  `cuello` varchar(45) DEFAULT NULL,
  `slim` binary(1) DEFAULT NULL,
  `manga` varchar(45) DEFAULT NULL,
  `bolsillo` binary(1) DEFAULT NULL,
  `remera` varchar(45) DEFAULT NULL,
  `lisorayado` varchar(45) DEFAULT NULL,
  `campera` varchar(45) DEFAULT NULL,
  `desmontable` binary(1) DEFAULT NULL,
  `pañuelo` binary(1) DEFAULT NULL,
  `lisafantasia` varchar(45) DEFAULT NULL,
  `suela` varchar(45) DEFAULT NULL,
  `cordones` binary(1) DEFAULT NULL,
  `puño` binary(1) DEFAULT NULL,
  `tirador` varchar(45) DEFAULT NULL,
  `trabacorbata` binary(1) DEFAULT NULL,
  `cinturon` varchar(45) DEFAULT NULL,
  `pack` varchar(45) DEFAULT NULL,
  `vbotones` varchar(45) DEFAULT NULL,
  `cardigan` binary(1) DEFAULT NULL,
  `vbase` varchar(45) DEFAULT NULL,
  `mediocierre` binary(1) DEFAULT NULL,
  `cortolargo` varchar(45) DEFAULT NULL,
  `deportivo` binary(1) DEFAULT NULL,
  `botones` binary(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `pinza_idx` (`pinza`),
  KEY `tela_idx` (`pinza`),
  KEY `estacion_idx` (`estacion`),
  KEY `pantalon_idx` (`pantalon`),
  KEY `estampado_idx` (`estampado`),
  KEY `cuello_idx` (`cuello`),
  KEY `manga_idx` (`manga`),
  KEY `remera_idx` (`remera`),
  KEY `lisorayado_idx` (`lisorayado`),
  KEY `campera_idx` (`campera`),
  KEY `lisafantasia_idx` (`lisafantasia`),
  KEY `suela_idx` (`suela`),
  KEY `tirador_idx` (`tirador`),
  KEY `cinturon_idx` (`cinturon`),
  KEY `pack_idx` (`pack`),
  KEY `v_idx` (`vbotones`),
  KEY `vbase_idx` (`vbase`),
  KEY `cortolargo_idx` (`cortolargo`),
  KEY `categoria_idx` (`categoria`),
  KEY `marca_idx` (`marca`),
  CONSTRAINT `campera` FOREIGN KEY (`campera`) REFERENCES `tipocampera` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `categoria` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cinturon` FOREIGN KEY (`cinturon`) REFERENCES `tipocinturon` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cortolargo` FOREIGN KEY (`cortolargo`) REFERENCES `cortolargo` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cuello` FOREIGN KEY (`cuello`) REFERENCES `cuellos` (`Cuello`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `estacion` FOREIGN KEY (`estacion`) REFERENCES `estaciones` (`Estacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `estampado` FOREIGN KEY (`estampado`) REFERENCES `tipoestampado` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lisafantasia` FOREIGN KEY (`lisafantasia`) REFERENCES `lisafantasia` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lisorayado` FOREIGN KEY (`lisorayado`) REFERENCES `lisorayado` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `manga` FOREIGN KEY (`manga`) REFERENCES `mangas` (`Manga`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `marca` FOREIGN KEY (`marca`) REFERENCES `marcas` (`marca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pack` FOREIGN KEY (`pack`) REFERENCES `tipopack` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pantalon` FOREIGN KEY (`pantalon`) REFERENCES `tipopantalon` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pinza` FOREIGN KEY (`pinza`) REFERENCES `pinzas` (`Pinza`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `remera` FOREIGN KEY (`remera`) REFERENCES `tiporemera` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `suela` FOREIGN KEY (`suela`) REFERENCES `tiposuela` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tela` FOREIGN KEY (`pinza`) REFERENCES `telas` (`Tela`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tirador` FOREIGN KEY (`tirador`) REFERENCES `tipotirador` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vbase` FOREIGN KEY (`vbase`) REFERENCES `vbase` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `vbotones` FOREIGN KEY (`vbotones`) REFERENCES `vbotones` (`Tipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descripciones`
--

LOCK TABLES `descripciones` WRITE;
/*!40000 ALTER TABLE `descripciones` DISABLE KEYS */;
INSERT INTO `descripciones` VALUES ('Final','Arrow','Pantalon','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Juan','Arrow','Pantalon','',NULL,NULL,NULL,NULL,NULL,NULL,'0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Otro','Arrow','Pantalon','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Pepe','Arrow','Pantalon','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `descripciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `composiciones`
--

DROP TABLE IF EXISTS `composiciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `composiciones` (
  `codigo` varchar(45) NOT NULL,
  `componente` varchar(45) NOT NULL,
  `porcentaje` int(11) NOT NULL,
  PRIMARY KEY (`codigo`,`componente`),
  KEY `codigo_idx` (`codigo`),
  KEY `composicion_idx` (`componente`),
  CONSTRAINT `codigo` FOREIGN KEY (`codigo`) REFERENCES `descripciones` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `componente` FOREIGN KEY (`componente`) REFERENCES `componentes` (`Componente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composiciones`
--

LOCK TABLES `composiciones` WRITE;
/*!40000 ALTER TABLE `composiciones` DISABLE KEYS */;
INSERT INTO `composiciones` VALUES ('Juan','Algodón',100),('Otro','Algodón',50),('Otro','Poliester',50),('Pepe','Poliester',100);
/*!40000 ALTER TABLE `composiciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulos` (
  `codigo` varchar(45) NOT NULL,
  `talle` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `local` varchar(45) NOT NULL,
  `stock` int(11) DEFAULT '0',
  PRIMARY KEY (`codigo`,`talle`,`color`,`local`),
  KEY `codigo_idx` (`codigo`),
  KEY `talle_idx` (`talle`),
  KEY `color_idx` (`color`),
  KEY `a_local_idx` (`local`),
  CONSTRAINT `a_talle` FOREIGN KEY (`talle`) REFERENCES `talles` (`talle`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `a_codigo` FOREIGN KEY (`codigo`) REFERENCES `descripciones` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `a_color` FOREIGN KEY (`color`) REFERENCES `colores` (`Color`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `a_local` FOREIGN KEY (`local`) REFERENCES `locales` (`local`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES ('Final','1 S','Azul','Deposito 1',10),('Final','2 M','Blanco','Deposito 2',30),('Juan','1 S','Negro','Deposito 1',10),('Juan','2 M','Negro','Deposito 1',8),('Juan','3 L','Negro','Deposito 1',5),('Otro','1 S','Azul','Deposito 1',80),('Pepe','1 S','Negro','Deposito 2',6),('Pepe','2 M','Negro','Deposito 2',3);
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-11 16:21:19
