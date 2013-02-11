CREATE  TABLE `rossisport`.`usuarios` (
  `user` VARCHAR(50) NOT NULL ,
  `pass` BLOB NULL ,
  `nombre` VARCHAR(100) NULL ,
  `expir_pass` DATE NULL ,
  `errores_permitidos` INT NULL ,
  `ultimo_login` DATETIME NULL ,
  PRIMARY KEY (`user`) );

CREATE  TABLE `rossisport`.`grupos` (
  `nombre` VARCHAR(50) NOT NULL ,
  `descripcion` VARCHAR(500) NULL ,
  PRIMARY KEY (`nombre`) );

CREATE  TABLE `rossisport`.`permisos` (
  `nombre` VARCHAR(50) NOT NULL ,
  `descripcion` VARCHAR(500) NULL ,
  PRIMARY KEY (`nombre`) );

CREATE  TABLE `rossisport`.`usuario_grupo` (
  `user` VARCHAR(50) NOT NULL ,
  `grupo` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`user`, `grupo`) ,
  INDEX `user_1_idx` (`user` ASC) ,
  INDEX `grupo_1_idx` (`grupo` ASC) ,
  CONSTRAINT `user_1`
    FOREIGN KEY (`user` )
    REFERENCES `rossisport`.`usuarios` (`user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `grupo_1`
    FOREIGN KEY (`grupo` )
    REFERENCES `rossisport`.`grupos` (`nombre` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE  TABLE `rossisport`.`grupo_permiso` (
  `grupo` VARCHAR(50) NOT NULL ,
  `permiso` VARCHAR(50) NOT NULL ,
  `negativo` BINARY NULL DEFAULT false ,
  PRIMARY KEY (`grupo`, `permiso`) ,
  INDEX `grupo_idx` (`grupo` ASC) ,
  INDEX `permiso_1_idx` (`permiso` ASC) ,
  CONSTRAINT `grupo_2`
    FOREIGN KEY (`grupo` )
    REFERENCES `rossisport`.`grupos` (`nombre` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `permiso_1`
    FOREIGN KEY (`permiso` )
    REFERENCES `rossisport`.`permisos` (`nombre` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
