CREATE  TABLE `rossisport`.`Categorias` (
  `nombre` VARCHAR(45) NOT NULL ,
  `caracteristicas` INT NOT NULL DEFAULT 0 ,
  PRIMARY KEY (`nombre`) );

CREATE  TABLE `rossisport`.`Talles` (
  `talle` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`talle`) );

CREATE  TABLE `rossisport`.`Colores` (
  `Color` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Color`) );

CREATE  TABLE `rossisport`.`Pinzas` (
  `Pinza` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Pinza`) );

CREATE  TABLE `rossisport`.`Telas` (
  `Tela` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tela`) );

CREATE  TABLE `rossisport`.`Estaciones` (
  `Estacion` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Estacion`) );

CREATE  TABLE `rossisport`.`TipoPantalon` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`TipoEstampado` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`Cuellos` (
  `Cuello` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Cuello`) );

CREATE  TABLE `rossisport`.`Mangas` (
  `Manga` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Manga`) );

CREATE  TABLE `rossisport`.`TipoRemera` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`LisoRayado` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`TipoCampera` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`LisaFantasia` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`TipoSuela` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`TipoTirador` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`TipoCinturon` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`TipoPack` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`VBase` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`CortoLargo` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`Componentes` (
  `Componente` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Componente`) );

CREATE  TABLE `rossisport`.`VBotones` (
  `Tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Tipo`) );

CREATE  TABLE `rossisport`.`Articulos` (
  `codigo` VARCHAR(45) NOT NULL ,
  `talle` VARCHAR(45) NOT NULL ,
  `color` VARCHAR(45) NOT NULL ,
  `marca` VARCHAR(45) NOT NULL ,
  `categoria` VARCHAR(45) NOT NULL ,
  `pinza` VARCHAR(45) NULL ,
  `tela` VARCHAR(45) NULL ,
  `estacion` VARCHAR(45) NULL ,
  `pantalon` VARCHAR(45) NULL ,
  `estampado` VARCHAR(45) NULL ,
  `cuello` VARCHAR(45) NULL ,
  `slim` BINARY NULL ,
  `manga` VARCHAR(45) NULL ,
  `bolsillo` BINARY NULL ,
  `remera` VARCHAR(45) NULL ,
  `lisorayado` VARCHAR(45) NULL ,
  `campera` VARCHAR(45) NULL ,
  `desmontable` BINARY NULL ,
  `pañuelo` BINARY NULL ,
  `lisafantasia` VARCHAR(45) NULL ,
  `suela` VARCHAR(45) NULL ,
  `cordones` BINARY NULL ,
  `puño` BINARY NULL ,
  `tirador` VARCHAR(45) NULL ,
  `trabacorbata` BINARY NULL ,
  `cinturon` VARCHAR(45) NULL ,
  `pack` VARCHAR(45) NULL ,
  `vbotones` VARCHAR(45) NULL ,
  `cardigan` BINARY NULL ,
  `vbase` VARCHAR(45) NULL ,
  `mediocierre` BINARY NULL ,
  `cortolargo` VARCHAR(45) NULL ,
  `deportivo` BINARY NULL ,
  `botones` BINARY NULL ,
  PRIMARY KEY (`codigo`, `talle`, `color`) ,
  INDEX `pinza_idx` (`pinza` ASC) ,
  INDEX `tela_idx` (`pinza` ASC) ,
  INDEX `estacion_idx` (`estacion` ASC) ,
  INDEX `pantalon_idx` (`pantalon` ASC) ,
  INDEX `estampado_idx` (`estampado` ASC) ,
  INDEX `cuello_idx` (`cuello` ASC) ,
  INDEX `manga_idx` (`manga` ASC) ,
  INDEX `remera_idx` (`remera` ASC) ,
  INDEX `lisorayado_idx` (`lisorayado` ASC) ,
  INDEX `campera_idx` (`campera` ASC) ,
  INDEX `lisafantasia_idx` (`lisafantasia` ASC) ,
  INDEX `suela_idx` (`suela` ASC) ,
  INDEX `tirador_idx` (`tirador` ASC) ,
  INDEX `cinturon_idx` (`cinturon` ASC) ,
  INDEX `pack_idx` (`pack` ASC) ,
  INDEX `v_idx` (`vbotones` ASC) ,
  INDEX `vbase_idx` (`vbase` ASC) ,
  INDEX `cortolargo_idx` (`cortolargo` ASC) ,
  CONSTRAINT `pinza`
    FOREIGN KEY (`pinza` )
    REFERENCES `rossisport`.`pinzas` (`Pinza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tela`
    FOREIGN KEY (`pinza` )
    REFERENCES `rossisport`.`telas` (`Tela` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `estacion`
    FOREIGN KEY (`estacion` )
    REFERENCES `rossisport`.`estaciones` (`Estacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pantalon`
    FOREIGN KEY (`pantalon` )
    REFERENCES `rossisport`.`tipopantalon` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `estampado`
    FOREIGN KEY (`estampado` )
    REFERENCES `rossisport`.`tipoestampado` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cuello`
    FOREIGN KEY (`cuello` )
    REFERENCES `rossisport`.`cuellos` (`Cuello` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `manga`
    FOREIGN KEY (`manga` )
    REFERENCES `rossisport`.`mangas` (`Manga` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `remera`
    FOREIGN KEY (`remera` )
    REFERENCES `rossisport`.`tiporemera` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lisorayado`
    FOREIGN KEY (`lisorayado` )
    REFERENCES `rossisport`.`lisorayado` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `campera`
    FOREIGN KEY (`campera` )
    REFERENCES `rossisport`.`tipocampera` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lisafantasia`
    FOREIGN KEY (`lisafantasia` )
    REFERENCES `rossisport`.`lisafantasia` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `suela`
    FOREIGN KEY (`suela` )
    REFERENCES `rossisport`.`tiposuela` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tirador`
    FOREIGN KEY (`tirador` )
    REFERENCES `rossisport`.`tipotirador` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cinturon`
    FOREIGN KEY (`cinturon` )
    REFERENCES `rossisport`.`tipocinturon` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pack`
    FOREIGN KEY (`pack` )
    REFERENCES `rossisport`.`tipopack` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `vbotones`
    FOREIGN KEY (`vbotones` )
    REFERENCES `rossisport`.`vbotones` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `vbase`
    FOREIGN KEY (`vbase` )
    REFERENCES `rossisport`.`vbase` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cortolargo`
    FOREIGN KEY (`cortolargo` )
    REFERENCES `rossisport`.`cortolargo` (`Tipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE  TABLE `rossisport`.`Composiciones` (
  `codigo` VARCHAR(45) NOT NULL ,
  `componente` VARCHAR(45) NOT NULL ,
  `porcentaje` INT NOT NULL ,
  PRIMARY KEY (`codigo`, `componente`) ,
  INDEX `codigo_idx` (`codigo` ASC) ,
  INDEX `composicion_idx` (`componente` ASC) ,
  CONSTRAINT `codigo`
    FOREIGN KEY (`codigo` )
    REFERENCES `rossisport`.`articulos` (`codigo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `componente`
    FOREIGN KEY (`componente` )
    REFERENCES `rossisport`.`componentes` (`Componente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Pantalon');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Camisa');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Remera');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Campera');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Gabardina');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Corbata');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Traje');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Saco sport');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Ambo');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Abrigo de paño');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Sobretodo');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Zapato');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Zapatenis');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Sandalia');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Rutero');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Medias');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Bufanda');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Chaleco de punto');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Buzo de punto');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Campera de punto');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Remera de punto');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Paño de cuello');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Tiradores');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Pañuelos en caja de 3');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Gemelos');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Billetera');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Calzoncillo largo');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Cinturon');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Camiseta');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Piyama');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Paraguas');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Guantes');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Boxer');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Slip');
INSERT INTO `rossisport`.`categorias` (`nombre`) VALUES ('Conjunto deportivo');

INSERT INTO `rossisport`.`cortolargo` (`Tipo`) VALUES ('Corto');
INSERT INTO `rossisport`.`cortolargo` (`Tipo`) VALUES ('Largo');

INSERT INTO `rossisport`.`cuellos` (`Cuello`) VALUES ('Clasico');
INSERT INTO `rossisport`.`cuellos` (`Cuello`) VALUES ('Combinado');
INSERT INTO `rossisport`.`cuellos` (`Cuello`) VALUES ('Italiano');



CREATE  TABLE `rossisport`.`Marcas` (
  `marca` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`marca`) );

ALTER TABLE `rossisport`.`articulos` 
  ADD CONSTRAINT `categoria`
  FOREIGN KEY (`categoria` )
  REFERENCES `rossisport`.`categorias` (`nombre` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION, 
  ADD CONSTRAINT `marca`
  FOREIGN KEY (`marca` )
  REFERENCES `rossisport`.`marcas` (`marca` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `categoria_idx` (`categoria` ASC) 
, ADD INDEX `marca_idx` (`marca` ASC) ;

ALTER TABLE `rossisport`.`articulos` ADD COLUMN `stock` INT NOT NULL  AFTER `color` ;

ALTER TABLE `rossisport`.`articulos` 
  ADD CONSTRAINT `talle`
  FOREIGN KEY (`talle` )
  REFERENCES `rossisport`.`talles` (`talle` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION, 
  ADD CONSTRAINT `color`
  FOREIGN KEY (`color` )
  REFERENCES `rossisport`.`colores` (`Color` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `talle_idx` (`talle` ASC) 
, ADD INDEX `color_idx` (`color` ASC) ;

ALTER TABLE `rossisport`.`articulos` DROP FOREIGN KEY `talle` , DROP FOREIGN KEY `color` ;
ALTER TABLE `rossisport`.`articulos` DROP COLUMN `stock` , DROP COLUMN `color` , DROP COLUMN `talle` 
, DROP PRIMARY KEY 
, ADD PRIMARY KEY (`codigo`) 
, DROP INDEX `color_idx` 
, DROP INDEX `talle_idx` ;

ALTER TABLE `rossisport`.`articulos` RENAME TO  `rossisport`.`descripciones` ;

INSERT INTO `rossisport`.`estaciones` (`Estacion`) VALUES ('Invierno');
INSERT INTO `rossisport`.`estaciones` (`Estacion`) VALUES ('Verano');

INSERT INTO `rossisport`.`lisafantasia` (`Tipo`) VALUES ('Fantasia');
INSERT INTO `rossisport`.`lisafantasia` (`Tipo`) VALUES ('Lisa');

INSERT INTO `rossisport`.`lisorayado` (`Tipo`) VALUES ('Liso');
INSERT INTO `rossisport`.`lisorayado` (`Tipo`) VALUES ('Rayado');

INSERT INTO `rossisport`.`mangas` (`Manga`) VALUES ('Corta');
INSERT INTO `rossisport`.`mangas` (`Manga`) VALUES ('Larga');

INSERT INTO `rossisport`.`pinzas` (`Pinza`) VALUES ('0');
INSERT INTO `rossisport`.`pinzas` (`Pinza`) VALUES ('1');
INSERT INTO `rossisport`.`pinzas` (`Pinza`) VALUES ('2');

INSERT INTO `rossisport`.`talles` (`talle`) VALUES ('S');
INSERT INTO `rossisport`.`talles` (`talle`) VALUES ('M');
INSERT INTO `rossisport`.`talles` (`talle`) VALUES ('L');
INSERT INTO `rossisport`.`talles` (`talle`) VALUES ('XL');

INSERT INTO `rossisport`.`tipocampera` (`Tipo`) VALUES ('Hasta cintura');
INSERT INTO `rossisport`.`tipocampera` (`Tipo`) VALUES ('Hasta muslo');

INSERT INTO `rossisport`.`tipocinturon` (`Tipo`) VALUES ('Reversible');
INSERT INTO `rossisport`.`tipocinturon` (`Tipo`) VALUES ('Clasico');
INSERT INTO `rossisport`.`tipocinturon` (`Tipo`) VALUES ('Cuerda');
INSERT INTO `rossisport`.`tipocinturon` (`Tipo`) VALUES ('Sport');

INSERT INTO `rossisport`.`tipopack` (`Tipo`) VALUES ('Unidad');
INSERT INTO `rossisport`.`tipopack` (`Tipo`) VALUES ('Por 3');

INSERT INTO `rossisport`.`tipopantalon` (`Tipo`) VALUES ('Vestir');
INSERT INTO `rossisport`.`tipopantalon` (`Tipo`) VALUES ('Sport');

INSERT INTO `rossisport`.`tiporemera` (`Tipo`) VALUES ('Clasica');
INSERT INTO `rossisport`.`tiporemera` (`Tipo`) VALUES ('Polo');
INSERT INTO `rossisport`.`tiporemera` (`Tipo`) VALUES ('T-Shirt');

INSERT INTO `rossisport`.`tiposuela` (`Tipo`) VALUES ('Suela');
INSERT INTO `rossisport`.`tiposuela` (`Tipo`) VALUES ('Suela con ovalo');
INSERT INTO `rossisport`.`tiposuela` (`Tipo`) VALUES ('Goma');

INSERT INTO `rossisport`.`tipotirador` (`Tipo`) VALUES ('Para botones');
INSERT INTO `rossisport`.`tipotirador` (`Tipo`) VALUES ('Pinzas');

INSERT INTO `rossisport`.`vbase` (`Tipo`) VALUES ('Escote V');
INSERT INTO `rossisport`.`vbase` (`Tipo`) VALUES ('A la base');

INSERT INTO `rossisport`.`vbotones` (`Tipo`) VALUES ('Escote V');
INSERT INTO `rossisport`.`vbotones` (`Tipo`) VALUES ('Con botones');

CREATE  TABLE `rossisport`.`articulos` (
  `codigo` VARCHAR(45) NOT NULL ,
  `talle` VARCHAR(45) NOT NULL ,
  `color` VARCHAR(45) NOT NULL ,
  `stock` INT NULL ,
  PRIMARY KEY (`codigo`, `talle`, `color`) ,
  INDEX `codigo_idx` (`codigo` ASC) ,
  INDEX `talle_idx` (`talle` ASC) ,
  INDEX `color_idx` (`color` ASC) ,
  CONSTRAINT `a_codigo`
    FOREIGN KEY (`codigo` )
    REFERENCES `rossisport`.`descripciones` (`codigo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `a_talle`
    FOREIGN KEY (`talle` )
    REFERENCES `rossisport`.`talles` (`talle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `a_color`
    FOREIGN KEY (`color` )
    REFERENCES `rossisport`.`colores` (`Color` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE  TABLE `rossisport`.`locales` (
  `local` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`local`) );

ALTER TABLE `rossisport`.`articulos` CHANGE COLUMN `stock` `stock` INT(11) NULL DEFAULT 0  , ADD COLUMN `local` VARCHAR(45) NOT NULL  AFTER `color` , 
  ADD CONSTRAINT `a_local`
  FOREIGN KEY (`local` )
  REFERENCES `rossisport`.`locales` (`local` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, DROP PRIMARY KEY 
, ADD PRIMARY KEY (`codigo`, `talle`, `color`, `local`) 
, ADD INDEX `a_local_idx` (`local` ASC) ;

INSERT INTO `rossisport`.`marcas` (`marca`) VALUES ('Arrow');

INSERT INTO `rossisport`.`descripciones` (`codigo`, `marca`, `categoria`, `slim`) VALUES ('Pepe', 'Arrow', 'Pantalon', true);
INSERT INTO `rossisport`.`descripciones` (`codigo`, `marca`, `categoria`, `slim`) VALUES ('Juan', 'Arrow', 'Pantalon', false);

INSERT INTO `rossisport`.`colores` (`Color`) VALUES ('Blanco');
INSERT INTO `rossisport`.`colores` (`Color`) VALUES ('Azul');
INSERT INTO `rossisport`.`colores` (`Color`) VALUES ('Negro');

INSERT INTO `rossisport`.`locales` (`local`) VALUES ('Deposito 1');
INSERT INTO `rossisport`.`locales` (`local`) VALUES ('Deposito 2');

INSERT INTO `rossisport`.`articulos` (`codigo`, `talle`, `color`, `local`, `stock`) VALUES ('Juan', 'S', 'Negro', 'Deposito 1', '10');
INSERT INTO `rossisport`.`articulos` (`codigo`, `talle`, `color`, `local`, `stock`) VALUES ('Juan', 'M', 'Negro', 'Deposito 1', '8');
INSERT INTO `rossisport`.`articulos` (`codigo`, `talle`, `color`, `local`, `stock`) VALUES ('Juan', 'L', 'Negro', 'Deposito 1', '5');
INSERT INTO `rossisport`.`articulos` (`codigo`, `talle`, `color`, `local`, `stock`) VALUES ('Pepe', 'S', 'Negro', 'Deposito 2', '5');
INSERT INTO `rossisport`.`articulos` (`codigo`, `talle`, `color`, `local`, `stock`) VALUES ('Pepe', 'M', 'Negro', 'Deposito 2', '2');

ALTER TABLE `rossisport`.`descripciones` ADD COLUMN `descripcion` VARCHAR(500) NULL  AFTER `categoria` ;

INSERT INTO `rossisport`.`componentes` (`Componente`) VALUES ('Algodón');
INSERT INTO `rossisport`.`componentes` (`Componente`) VALUES ('Poliester');

INSERT INTO `rossisport`.`composiciones` (`codigo`, `componente`, `porcentaje`) VALUES ('Juan', 'Algodón', '100');
INSERT INTO `rossisport`.`composiciones` (`codigo`, `componente`, `porcentaje`) VALUES ('Pepe', 'Poliester', '100');

UPDATE `rossisport`.`descripciones` SET `descripcion`='' WHERE `codigo`='Juan';
UPDATE `rossisport`.`descripciones` SET `descripcion`='' WHERE `codigo`='Pepe';

ALTER TABLE `rossisport`.`composiciones` DROP FOREIGN KEY `codigo` ;
ALTER TABLE `rossisport`.`composiciones` 
  ADD CONSTRAINT `codigo`
  FOREIGN KEY (`codigo` )
  REFERENCES `rossisport`.`descripciones` (`codigo` )
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `rossisport`.`articulos` DROP FOREIGN KEY `a_codigo` ;
ALTER TABLE `rossisport`.`articulos` 
  ADD CONSTRAINT `a_codigo`
  FOREIGN KEY (`codigo` )
  REFERENCES `rossisport`.`descripciones` (`codigo` )
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `rossisport`.`articulos` DROP FOREIGN KEY `a_talle` ;
ALTER TABLE `rossisport`.`articulos` 
  ADD CONSTRAINT `a_talle`
  FOREIGN KEY (`talle` )
  REFERENCES `rossisport`.`talles` (`talle` )
  ON DELETE NO ACTION
  ON UPDATE CASCADE;

UPDATE `rossisport`.`talles` SET `talle`='3 L' WHERE `talle`='L';
UPDATE `rossisport`.`talles` SET `talle`='2 M' WHERE `talle`='M';
UPDATE `rossisport`.`talles` SET `talle`='1 S' WHERE `talle`='S';
UPDATE `rossisport`.`talles` SET `talle`='4 XL' WHERE `talle`='XL';
INSERT INTO `rossisport`.`talles` (`talle`) VALUES ('5 XXL');
