-- MySQL Script generated by MySQL Workbench
-- Tue Dec  3 20:59:47 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Carrera
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Carrera
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Carrera` DEFAULT CHARACTER SET utf8 ;
USE `Carrera` ;

-- -----------------------------------------------------
-- Table `Carrera`.`Carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Carrera`.`Carrera` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Carrera`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Carrera`.`Curso` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `creditos` INT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Carrera`.`CarreraCurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Carrera`.`CarreraCurso` (
  `codigoCarrera` INT NOT NULL,
  `codigoCurso` INT NOT NULL,
  PRIMARY KEY (`codigoCarrera`, `codigoCurso`),
  INDEX `fk_Carrera_has_Curso_Curso1_idx` (`codigoCurso` ASC) VISIBLE,
  INDEX `fk_Carrera_has_Curso_Carrera_idx` (`codigoCarrera` ASC) VISIBLE,
  CONSTRAINT `fk_Carrera_has_Curso_Carrera`
    FOREIGN KEY (`codigoCarrera`)
    REFERENCES `Carrera`.`Carrera` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carrera_has_Curso_Curso1`
    FOREIGN KEY (`codigoCurso`)
    REFERENCES `Carrera`.`Curso` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
