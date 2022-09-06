-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_arcos_teste
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_arcos_teste
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_arcos_teste` DEFAULT CHARACTER SET utf8 ;
USE `db_arcos_teste` ;

-- -----------------------------------------------------
-- Table `db_arcos_teste`.`tb_produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arcos_teste`.`tb_produtos` (
  `pcodigo` INT NOT NULL AUTO_INCREMENT,
  `pdescricao` VARCHAR(50) NULL,
  `ppreco` VARCHAR(10) NULL,
  PRIMARY KEY (`pcodigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arcos_teste`.`tb_estoques`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arcos_teste`.`tb_estoques` (
  `pquantidade` VARCHAR(10) NULL,
  `tb_produtos_pcodigo` INT NOT NULL,
  INDEX `fk_tb_estoques_tb_produtos_idx` (`tb_produtos_pcodigo` ASC) VISIBLE,
  CONSTRAINT `fk_tb_estoques_tb_produtos`
    FOREIGN KEY (`tb_produtos_pcodigo`)
    REFERENCES `db_arcos_teste`.`tb_produtos` (`pcodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_arcos_teste`.`tb_vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_arcos_teste`.`tb_vendas` (
  `pdata` VARCHAR(10) NULL,
  `pcpf` VARCHAR(10) NULL,
  `preco_unitario` VARCHAR(45) NULL,
  `qtde_vendas` VARCHAR(45) NULL,
  `tb_produtos_pcodigo` INT NOT NULL,
  INDEX `fk_tb_vendas_tb_produtos1_idx` (`tb_produtos_pcodigo` ASC) VISIBLE,
  CONSTRAINT `fk_tb_vendas_tb_produtos1`
    FOREIGN KEY (`tb_produtos_pcodigo`)
    REFERENCES `db_arcos_teste`.`tb_produtos` (`pcodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
