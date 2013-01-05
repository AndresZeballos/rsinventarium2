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


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-09-11 16:41:08
