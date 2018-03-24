


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `Olimpiadas` DEFAULT CHARACTER SET utf8 ;
USE `Olimpiadas` ;


CREATE TABLE IF NOT EXISTS `Olimpiadas`.`Pais` (
  `idPais` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `populacao`BIGINT(100) NOT NULL,
  `area` DOUBLE(1,3)  NOT NULL,
  PRIMARY KEY (`idPais`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `Olimpiadas`.`Ano` (
  `idAno` INT NOT NULL,
   `ano` datetime(8) NOT NULL,
   `tipo` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idAno`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `Olimpiadas`.`Modalidades` (
  `idModalidades` INT NOT NULL,
  `Modalidade` VARCHAR(45) NOT NULL,
  `Ouro` INT(45) NOT NULL,
  `Prata` INT(45) NOT NULL,
  `Bronze` INT(45) NOT NULL,
  PRIMARY KEY (`idModalidades`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `Olimpiadas`.`Olimpiadas` (
  `idOlimpiadas` INT NOT NULL,
  `Tipo` VARCHAR(45) NULL,
  `Pais_idPais` INT NOT NULL,
  `Ano_idAno` INT NOT NULL,
  `Modalidades_idModalidades` INT NOT NULL,
  PRIMARY KEY (`idOlimpiadas`),
  INDEX `fk_Olimpiadas_Pais_idx` (`Pais_idPais` ASC),
  INDEX `fk_Olimpiadas_Ano1_idx` (`Ano_idAno` ASC),
  INDEX `fk_Olimpiadas_Modalidades1_idx` (`Modalidades_idModalidades` ASC),
  CONSTRAINT `fk_Olimpiadas_Pais`
    FOREIGN KEY (`Pais_idPais`)
    REFERENCES `Olimpiadas`.`Pais` (`idPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Olimpiadas_Ano1`
    FOREIGN KEY (`Ano_idAno`)
    REFERENCES `Olimpiadas`.`Ano` (`idAno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Olimpiadas_Modalidades1`
    FOREIGN KEY (`Modalidades_idModalidades`)
    REFERENCES `Olimpiadas`.`Modalidades` (`idModalidades`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `Olimpiadas`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
