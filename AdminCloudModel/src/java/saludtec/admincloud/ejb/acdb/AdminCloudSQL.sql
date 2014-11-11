-- MySQL Script generated by MySQL Workbench
-- vie 07 nov 2014 09:10:38 COT
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema admin_cloud
-- -----------------------------------------------------
-- Admin cloud
CREATE SCHEMA IF NOT EXISTS `admin_cloud` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `admin_cloud` ;

-- -----------------------------------------------------
-- Table `admin_cloud`.`clinicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`clinicas` (
  `id_clinica` INT NOT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(250) NOT NULL,
  `nit` VARCHAR(250) NULL,
  `tipo_regimen` VARCHAR(250) NOT NULL,
  `direccion_principal` VARCHAR(250) NOT NULL,
  `telefono_prinicipal` VARCHAR(250) NOT NULL,
  `fax` VARCHAR(250) NULL,
  `email_principal` VARCHAR(250) NOT NULL,
  `actividad_economica` VARCHAR(500) NOT NULL,
  `otros` LONGTEXT NULL,
  `logo` LONGTEXT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `limite_sedes` INT NOT NULL DEFAULT 1,
  `limite_usuarios` INT NOT NULL DEFAULT 1,
  `fecha_limite_activo` DATE NOT NULL,
  `pais` VARCHAR(200) NOT NULL,
  `zona_horaria` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_clinica`),
  UNIQUE INDEX `nit_UNIQUE` (`nit` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`tipos_de_documentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`tipos_de_documentos` (
  `id_tipo_de_documento` INT NOT NULL AUTO_INCREMENT,
  `tipo_de_documento` VARCHAR(500) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_tipo_de_documento`),
  INDEX `fk_tipo_documento_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_tipo_documento_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`departamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`departamentos` (
  `id_departamento` INT NOT NULL AUTO_INCREMENT,
  `departamento` VARCHAR(500) NOT NULL,
  `codigo` VARCHAR(100) NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_departamento`),
  INDEX `fk_departamento_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_departamento_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`companias_de_seguros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`companias_de_seguros` (
  `id_compania_de_seguro` INT NOT NULL AUTO_INCREMENT,
  `compania_de_seguro` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(500) NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_compania_de_seguro`),
  INDEX `fk_compania_s_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_compania_s_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`tipos_de_vinculacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`tipos_de_vinculacion` (
  `id_tipo_de_vinculacion` INT NOT NULL AUTO_INCREMENT,
  `tipo_de_vinculacion` VARCHAR(500) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_tipo_de_vinculacion`),
  INDEX `fk_vinculacion_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_vinculacion_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`estratos_sociales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`estratos_sociales` (
  `id_estrato_social` INT NOT NULL AUTO_INCREMENT,
  `estrato_social` VARCHAR(500) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_estrato_social`),
  INDEX `fk_estratos_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_estratos_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`estados_pacientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`estados_pacientes` (
  `id_estado_paciente` INT NOT NULL AUTO_INCREMENT,
  `estado_paciente` VARCHAR(500) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_estado_paciente`),
  INDEX `fk_estado_paciente_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_estado_paciente_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`razas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`razas` (
  `id_raza` INT NOT NULL AUTO_INCREMENT,
  `raza` VARCHAR(500) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`id_raza`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`estados_civiles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`estados_civiles` (
  `id_estado_civil` INT NOT NULL AUTO_INCREMENT,
  `estado_civil` VARCHAR(500) NOT NULL,
  `fecha_creacion` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  PRIMARY KEY (`id_estado_civil`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`como_supo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`como_supo` (
  `id_como_supo` INT NOT NULL AUTO_INCREMENT,
  `como_supo` VARCHAR(500) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_como_supo`),
  INDEX `fk_como_supo_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_como_supo_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `admin_cloud`.`consecutivos_facturacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`consecutivos_facturacion` (
  `id_informacion_facturacion` INT NOT NULL AUTO_INCREMENT,
  `resolucion` VARCHAR(250) NOT NULL,
  `fecha_resolucion` DATE NOT NULL,
  `numero_inicial` INT NOT NULL,
  `numero_final` INT NOT NULL,
  `numero_actual` INT NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_informacion_facturacion`),
  INDEX `fk_consecutivos_recibos_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_consecutivos_facturas_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`consecutivos_recibos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`consecutivos_recibos` (
  `id_informacion_facturacion` INT NOT NULL,
  `numero_actual` INT NOT NULL DEFAULT 0,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_informacion_facturacion`),
  INDEX `fk_consecutivos_recibos_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_consecutivos_recibos_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`modulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`modulos` (
  `id_modulo` INT NOT NULL AUTO_INCREMENT,
  `modulo` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `icono` VARCHAR(100) NULL,
  PRIMARY KEY (`id_modulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`modulos_clinicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`modulos_clinicas` (
  `id_modulo_clinica` INT NOT NULL AUTO_INCREMENT,
  `id_modulo` INT NOT NULL,
  `fecha_creacion` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NULL,
  `estado` VARCHAR(50) NULL,
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_modulo_clinica`),
  INDEX `fk_id_modulo_idx` (`id_modulo` ASC),
  INDEX `fk_modulo_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_modulo_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_modulo`
    FOREIGN KEY (`id_modulo`)
    REFERENCES `admin_cloud`.`modulos` (`id_modulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`perfiles_modulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`perfiles_modulos` (
  `id_perfil_modulo` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_perfil_modulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`claves_arqueo_de_caja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`claves_arqueo_de_caja` (
  `id_clave_arqueo_de_caja` INT NOT NULL AUTO_INCREMENT,
  `clave_arqueo_de_caja` VARCHAR(250) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `id_clinica` INT NULL,
  PRIMARY KEY (`id_clave_arqueo_de_caja`),
  INDEX `fk_clave_arqueo_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_clave_arqueo_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`claves_correccion_factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`claves_correccion_factura` (
  `id_clave_correccion_factura` INT NOT NULL AUTO_INCREMENT,
  `clave_correccion_factura` VARCHAR(250) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_clave_correccion_factura`),
  INDEX `fk_clave_correccion_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_clave_correccion_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`categorias_procedimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`categorias_procedimientos` (
  `id_categoria_procedimiento` INT NOT NULL AUTO_INCREMENT,
  `categoria_procedimiento` VARCHAR(200) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_categoria_procedimiento`),
  INDEX `fk_categoria_procedimiento_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_categoria_procedimiento_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`procedimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`procedimientos` (
  `id_procedimiento` INT NOT NULL AUTO_INCREMENT,
  `procedimiento` VARCHAR(500) NOT NULL,
  `id_categoria_procedimiento` INT NOT NULL,
  `rango` INT NOT NULL,
  `ambito_realizacion` INT NOT NULL,
  `finalidad_procedimiento` INT NOT NULL,
  `acto_quirurgico` INT NOT NULL,
  `cups` VARCHAR(250) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `editable` VARCHAR(10) NOT NULL DEFAULT 'no',
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_procedimiento`),
  INDEX `fk_categoria_procedimiento_idx` (`id_categoria_procedimiento` ASC),
  INDEX `fk_procedimiento_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_categoria_procedimiento`
    FOREIGN KEY (`id_categoria_procedimiento`)
    REFERENCES `admin_cloud`.`categorias_procedimientos` (`id_categoria_procedimiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_procedimiento_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`convenios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`convenios` (
  `id_convenio` INT NOT NULL AUTO_INCREMENT,
  `convenio` VARCHAR(250) NOT NULL,
  `codigo_convenio` VARCHAR(100) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_convenio`),
  INDEX `fk_convenio_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_convenio_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`tipos_de_monedas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`tipos_de_monedas` (
  `id_tipo_de_moneda` INT NOT NULL AUTO_INCREMENT,
  `tipo_moneda` VARCHAR(100) NOT NULL,
  `nombre_moneda` VARCHAR(250) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_tipo_de_moneda`),
  INDEX `fk_moneda_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_moneda_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`perfiles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`perfiles` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `perfil` VARCHAR(200) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_perfil`),
  INDEX `fk_clinica_perfil_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_clinica_perfil`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`pacientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`pacientes` (
  `id_paciente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  `apellido` VARCHAR(200) NOT NULL,
  `id_tipo_de_documento` INT NOT NULL,
  `numero_de_documento` VARCHAR(100) NOT NULL,
  `fecha_de_nacimiento` VARCHAR(45) NOT NULL,
  `id_estado_paciente` INT NOT NULL,
  `id_estado_civil` INT NOT NULL,
  `id_raza` INT NOT NULL,
  `sexo` VARCHAR(10) NOT NULL,
  `ocupacion` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(100) NOT NULL,
  `celular` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `pais` VARCHAR(100) NOT NULL,
  `id_departamento` INT NOT NULL,
  `ciudad` VARCHAR(100) NOT NULL,
  `nacionalidad` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `zona_residencial` VARCHAR(50) NOT NULL,
  `codigo_postal` VARCHAR(50) NOT NULL,
  `id_estrato_social` INT NOT NULL,
  `id_compania_de_seguro` INT NOT NULL,
  `id_tipo_de_vinculacion` INT NOT NULL,
  `nombre_acudiente` VARCHAR(200) NULL,
  `apellido_acudiente` VARCHAR(200) NULL,
  `id_tipo_de_documento_acudiente` INT NULL,
  `numero_de_documento_acudiente` VARCHAR(100) NULL,
  `telefono_acudiente` VARCHAR(100) NULL,
  `parentesco_acudiente` VARCHAR(100) NULL,
  `nombre_emergencia` VARCHAR(500) NULL,
  `telefono_emergencia` VARCHAR(100) NULL,
  `parentesco_emergencia` VARCHAR(100) NULL,
  `alerta_medica` LONGTEXT NULL,
  `foto` VARCHAR(45) NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_paciente`),
  INDEX `fk_id_tipo_documento_paciente_idx` (`id_tipo_de_documento` ASC),
  INDEX `fk_id_estado_paciente_idx` (`id_estado_paciente` ASC),
  INDEX `fk_id_estrato_paciente_idx` (`id_estrato_social` ASC),
  INDEX `fk_id_departamento_paciente_idx` (`id_departamento` ASC),
  INDEX `fk_id_compania_seguro_paciente_idx` (`id_compania_de_seguro` ASC),
  INDEX `fk_id_tipo_vinculacion_paciente_idx` (`id_tipo_de_vinculacion` ASC),
  INDEX `fk_id_tipo_documento_acudiente_idx` (`id_tipo_de_documento_acudiente` ASC),
  INDEX `fk_id_clinica_paciente_idx` (`id_clinica` ASC),
  INDEX `fk_id_estado_civil_paciente_idx` (`id_estado_civil` ASC),
  INDEX `fk_id_raza_paciente_idx` (`id_raza` ASC),
  CONSTRAINT `fk_id_tipo_documento_paciente`
    FOREIGN KEY (`id_tipo_de_documento`)
    REFERENCES `admin_cloud`.`tipos_de_documentos` (`id_tipo_de_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_estado_paciente`
    FOREIGN KEY (`id_estado_paciente`)
    REFERENCES `admin_cloud`.`estados_pacientes` (`id_estado_paciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_estado_civil_paciente`
    FOREIGN KEY (`id_estado_civil`)
    REFERENCES `admin_cloud`.`estados_civiles` (`id_estado_civil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_estrato_paciente`
    FOREIGN KEY (`id_estrato_social`)
    REFERENCES `admin_cloud`.`estratos_sociales` (`id_estrato_social`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_departamento_paciente`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `admin_cloud`.`departamentos` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_raza_paciente`
    FOREIGN KEY (`id_raza`)
    REFERENCES `admin_cloud`.`razas` (`id_raza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_compania_seguro_paciente`
    FOREIGN KEY (`id_compania_de_seguro`)
    REFERENCES `admin_cloud`.`companias_de_seguros` (`id_compania_de_seguro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_tipo_vinculacion_paciente`
    FOREIGN KEY (`id_tipo_de_vinculacion`)
    REFERENCES `admin_cloud`.`tipos_de_vinculacion` (`id_tipo_de_vinculacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_tipo_documento_acudiente`
    FOREIGN KEY (`id_tipo_de_documento_acudiente`)
    REFERENCES `admin_cloud`.`tipos_de_documentos` (`id_tipo_de_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_clinica_paciente`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`convenios_procedimientos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`convenios_procedimientos` (
  `id_convenio_procedimiento` INT NOT NULL AUTO_INCREMENT,
  `id_convenio` INT NOT NULL,
  `id_procedimiento` INT NOT NULL,
  `tipo_descuento` VARCHAR(100) NOT NULL,
  `valor_descuento` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  INDEX `fk_rel_convenio_proc_idx` (`id_convenio` ASC),
  INDEX `fk_rel_procedimiento_conv_idx` (`id_procedimiento` ASC),
  INDEX `fk_clinica_rel_proc_conv_idx` (`id_clinica` ASC),
  PRIMARY KEY (`id_convenio_procedimiento`),
  CONSTRAINT `fk_rel_convenio_proc`
    FOREIGN KEY (`id_convenio`)
    REFERENCES `admin_cloud`.`convenios` (`id_convenio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rel_procedimiento_conv`
    FOREIGN KEY (`id_procedimiento`)
    REFERENCES `admin_cloud`.`procedimientos` (`id_procedimiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clinica_rel_proc_conv`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`profesionales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`profesionales` (
  `id_profesional` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `id_tipo_de_documento` INT NOT NULL,
  `numero_de_documento` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `usuario` VARCHAR(100) NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_profesional`),
  INDEX `fk_tipo_documento_prof_idx` (`id_tipo_de_documento` ASC),
  INDEX `fk_clinica_profesional_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_tipo_documento_prof`
    FOREIGN KEY (`id_tipo_de_documento`)
    REFERENCES `admin_cloud`.`tipos_de_documentos` (`id_tipo_de_documento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clinica_profesional`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`comisiones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`comisiones` (
  `id_comision` INT NOT NULL,
  `id_profesional` INT NOT NULL,
  `id_procedimiento` INT NOT NULL,
  `tipo_comision` VARCHAR(100) NOT NULL,
  `valor_comision` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_comision`),
  INDEX `fk_procedimiento_comision_idx` (`id_procedimiento` ASC),
  INDEX `fk_clinica_comision_idx` (`id_clinica` ASC),
  INDEX `fk_profesional_comision_idx` (`id_profesional` ASC),
  CONSTRAINT `fk_procedimiento_comision`
    FOREIGN KEY (`id_procedimiento`)
    REFERENCES `admin_cloud`.`procedimientos` (`id_procedimiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clinica_comision`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesional_comision`
    FOREIGN KEY (`id_profesional`)
    REFERENCES `admin_cloud`.`profesionales` (`id_profesional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`facturas` (
  `id_factura` INT NOT NULL AUTO_INCREMENT,
  `numero_factura` VARCHAR(100) NOT NULL,
  `id_paciente` INT NOT NULL,
  `nombre_paciente` VARCHAR(100) NOT NULL,
  `apellido_paciente` VARCHAR(100) NOT NULL,
  `tipo_de_documento` VARCHAR(100) NOT NULL,
  `numero_de_documento` VARCHAR(100) NOT NULL,
  `razon_social_clinica` VARCHAR(200) NOT NULL,
  `nit_clinica` VARCHAR(100) NOT NULL,
  `tipo_regimen_clinica` VARCHAR(100) NOT NULL,
  `direccion_clinica` VARCHAR(100) NOT NULL,
  `telefono_clinica` VARCHAR(100) NOT NULL,
  `fax_clinica` VARCHAR(100) NOT NULL,
  `email_clinica` VARCHAR(100) NOT NULL,
  `otros_clinica` LONGTEXT NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL DEFAULT 'activo',
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_factura`),
  INDEX `fk_id_paciente_factura_idx` (`id_paciente` ASC),
  INDEX `fk_id_factura_clinica_idx` (`id_clinica` ASC),
  CONSTRAINT `fk_id_paciente_factura`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `admin_cloud`.`pacientes` (`id_paciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_factura_clinica`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `admin_cloud`.`descripcion_facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `admin_cloud`.`descripcion_facturas` (
  `id_descripcion_factura` INT NOT NULL AUTO_INCREMENT,
  `id_procedimiento` INT NOT NULL,
  `procedimiento` VARCHAR(500) NOT NULL,
  `cups` VARCHAR(100) NOT NULL,
  `valor_procedimiento` DOUBLE NOT NULL,
  `cantidad` INT NOT NULL,
  `id_profesional` INT NULL,
  `nombre_profesional` VARCHAR(100) NULL,
  `apellido_profesional` VARCHAR(100) NULL,
  `tipo_de_documento` VARCHAR(100) NULL,
  `numero_de_documento` VARCHAR(100) NULL,
  `id_comision` INT NULL,
  `tipo_de_comision` VARCHAR(100) NULL,
  `valor_comision` DOUBLE NULL,
  `total_comision` DOUBLE NULL,
  `id_convenio` INT NULL,
  `valor_convenio` DOUBLE NULL,
  `total_procedimiento` DOUBLE NOT NULL,
  `id_factura` INT NOT NULL,
  `fecha_creacion` TIMESTAMP NOT NULL,
  `ultima_edicion` DATETIME NOT NULL,
  `estado` VARCHAR(50) NOT NULL,
  `id_clinica` INT NOT NULL,
  PRIMARY KEY (`id_descripcion_factura`),
  INDEX `fk_profesional_descripcion_factura_idx` (`id_profesional` ASC),
  INDEX `fk_procedimiento_descripcion_factura_idx` (`id_procedimiento` ASC),
  INDEX `fk_comision_descripcion_factura_idx` (`id_comision` ASC),
  INDEX `fk_convenio_descripcion_factura_idx` (`id_convenio` ASC),
  INDEX `fk_clinica_descripcion_factura_idx` (`id_clinica` ASC),
  INDEX `fk_factura_descripcion_idx` (`id_factura` ASC),
  CONSTRAINT `fk_profesional_descripcion_factura`
    FOREIGN KEY (`id_profesional`)
    REFERENCES `admin_cloud`.`profesionales` (`id_profesional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_procedimiento_descripcion_factura`
    FOREIGN KEY (`id_procedimiento`)
    REFERENCES `admin_cloud`.`procedimientos` (`id_procedimiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comision_descripcion_factura`
    FOREIGN KEY (`id_comision`)
    REFERENCES `admin_cloud`.`comisiones` (`id_comision`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_convenio_descripcion_factura`
    FOREIGN KEY (`id_convenio`)
    REFERENCES `admin_cloud`.`convenios` (`id_convenio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clinica_descripcion_factura`
    FOREIGN KEY (`id_clinica`)
    REFERENCES `admin_cloud`.`clinicas` (`id_clinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_descripcion`
    FOREIGN KEY (`id_factura`)
    REFERENCES `admin_cloud`.`facturas` (`id_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
