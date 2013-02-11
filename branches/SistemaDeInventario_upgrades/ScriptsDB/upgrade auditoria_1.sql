CREATE  TABLE `rossisport`.`logs` (
  `accion` INT(28) NOT NULL ,
  `ordinal` INT(11) NOT NULL ,
  `user` VARCHAR(50) NULL ,
  `maquina` VARCHAR(50) NOT NULL ,
  `fecha` DATETIME NOT NULL ,
  `permiso` VARCHAR(50) NOT NULL ,
  `descripcion` VARCHAR(2000) NULL ,
  PRIMARY KEY (`accion`, `ordinal`) );
  
CREATE  TABLE `rossisport`.`modulos` (
  `modulo` VARCHAR(50) NOT NULL ,
  `licencia` BLOB NOT NULL ,
  PRIMARY KEY (`modulo`) );

ALTER TABLE `rossisport`.`logs` CHANGE COLUMN `fecha` `fecha` DATETIME NOT NULL  AFTER `ordinal` , CHANGE COLUMN `maquina` `maquina` VARCHAR(50) NOT NULL  AFTER `fecha` , CHANGE COLUMN `user` `user` VARCHAR(50) NULL  , CHANGE COLUMN `descripcion` `descripcion` VARCHAR(2000) NOT NULL  
, DROP PRIMARY KEY 
, ADD PRIMARY KEY (`accion`, `ordinal`, `fecha`, `maquina`) ;

INSERT INTO `rossisport`.`logs` (`accion`, `ordinal`, `maquina`, `user`, `permiso`, `descripcion`) VALUES ('0', '0', '0', '0', '0', '0');

