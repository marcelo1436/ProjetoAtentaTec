-- MySQL Workbench Synchronization
-- Generated: 2015-09-13 13:38
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Usuario

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `provaatentatec`.`compra` (
  `id_compra` INT(11) NOT NULL,
  `data_compra` DATE NULL DEFAULT NULL,
  `id_mercado` INT(11) NOT NULL,
  `id_produto` INT(11) NOT NULL,
  PRIMARY KEY (`id_compra`),
  INDEX `fk_compra_mercado_idx` (`id_mercado` ASC),
  INDEX `fk_compra_produto1_idx` (`id_produto` ASC),
  CONSTRAINT `fk_compra_mercado`
    FOREIGN KEY (`id_mercado`)
    REFERENCES `provaatentatec`.`mercado` (`id_mercado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `provaatentatec`.`produto` (`id_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `provaatentatec`.`consumoproduto` (
  `id_consumo` INT(11) NOT NULL,
  `data_consumo` DATE NULL DEFAULT NULL,
  `quantidade` INT(11) NULL DEFAULT NULL,
  `id_produto` INT(11) NOT NULL,
  PRIMARY KEY (`id_consumo`),
  INDEX `fk_consumoproduto_produto1_idx` (`id_produto` ASC),
  CONSTRAINT `fk_consumoproduto_produto1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `provaatentatec`.`produto` (`id_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `provaatentatec`.`mercado` (
  `id_mercado` INT(11) NOT NULL DEFAULT '0',
  `nome_mercado` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id_mercado`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `provaatentatec`.`produto` (
  `id_produto` INT(11) NOT NULL DEFAULT '0',
  `nome_produto` VARCHAR(80) NULL DEFAULT NULL,
  `tipo_produto` TINYINT(4) NULL DEFAULT NULL,
  `marca_produto` VARCHAR(40) NULL DEFAULT NULL,
  `valor_produto` DECIMAL(10,2) NULL DEFAULT NULL,
  `dataValidade_produto` DATE NULL DEFAULT NULL,
  `quantidade_produto` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_produto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `provaatentatec`.`schema_version` (
  `version_rank` INT(11) NOT NULL,
  `installed_rank` INT(11) NOT NULL,
  `version` VARCHAR(50) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `script` VARCHAR(1000) NOT NULL,
  `checksum` INT(11) NULL DEFAULT NULL,
  `installed_by` VARCHAR(100) NOT NULL,
  `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` INT(11) NOT NULL,
  `success` TINYINT(1) NOT NULL,
  PRIMARY KEY (`version`),
  INDEX `schema_version_vr_idx` (`version_rank` ASC),
  INDEX `schema_version_ir_idx` (`installed_rank` ASC),
  INDEX `schema_version_s_idx` (`success` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `provaatentatec`.`usuario` (
  `id_usuario` INT(11) NOT NULL,
  `login` VARCHAR(80) NOT NULL,
  `senha` VARCHAR(30) NOT NULL,
  `ativo` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `provaatentatec`.`usuario` (`id_usuario`, `login`, `senha`, `ativo`) VALUES ('1', 'admin', '1', '1');
