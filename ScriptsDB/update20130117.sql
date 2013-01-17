ALTER TABLE `rossisport`.`proveedores` 
  ADD CONSTRAINT `pais_fk`
  FOREIGN KEY (`pais` )
  REFERENCES `rossisport`.`paises` (`pais` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `pais_idx` (`pais` ASC) ;


ALTER TABLE `rossisport`.`facturas` 
  ADD CONSTRAINT `moneda_fk`
  FOREIGN KEY (`moneda` )
  REFERENCES `rossisport`.`monedas` (`moneda` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION, 
  ADD CONSTRAINT `plazo_fk`
  FOREIGN KEY (`plazopago` )
  REFERENCES `rossisport`.`plazo_pagos` (`plazopago` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION, 
  ADD CONSTRAINT `tipo_fk`
  FOREIGN KEY (`tipopago` )
  REFERENCES `rossisport`.`tipo_pagos` (`tipopago` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `moneda_fk_idx` (`moneda` ASC) 
, ADD INDEX `plazo_fk_idx` (`plazopago` ASC) 
, ADD INDEX `tipo_fk_idx` (`tipopago` ASC) ;
