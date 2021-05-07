-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_gestao_de_obras
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_gestao_de_obras
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_gestao_de_obras` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_gestao_de_obras` ;

-- -----------------------------------------------------
-- Table `db_gestao_de_obras`.`obra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gestao_de_obras`.`obra` (
  `id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `codigo` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  UNIQUE INDEX `index_obra_codigo` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_gestao_de_obras`.`almoxarifado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gestao_de_obras`.`almoxarifado` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `obra_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `index_almoxarifado_obra_id` (`obra_id` ASC) VISIBLE,
  CONSTRAINT `fk_almoxarifado_obra`
    FOREIGN KEY (`obra_id`)
    REFERENCES `db_gestao_de_obras`.`obra` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_gestao_de_obras`.`cargo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gestao_de_obras`.`cargo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `index_cargo_nome` (`nome` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_gestao_de_obras`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gestao_de_obras`.`endereco` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `bairro` VARCHAR(255) NULL DEFAULT NULL,
  `cidade` VARCHAR(255) NULL DEFAULT NULL,
  `complemento` VARCHAR(255) NULL DEFAULT NULL,
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  `logradouro` VARCHAR(255) NULL DEFAULT NULL,
  `numero` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_gestao_de_obras`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gestao_de_obras`.`usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL UNIQUE,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL UNIQUE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `index_usuario email` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_gestao_de_obras`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gestao_de_obras`.`funcionario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(255) NOT NULL,
  `data_nascimento` DATE NULL DEFAULT NULL,
  `matricula` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `sexo` VARCHAR(255) NULL DEFAULT NULL,
  `cargo_id` BIGINT NULL DEFAULT NULL,
  `endereco_id` BIGINT NULL DEFAULT NULL,
  `obra_id` BIGINT NULL DEFAULT NULL,
  `usuario_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `index_funcionario_usuario_id` (`usuario_id` ASC) VISIBLE,
  UNIQUE INDEX `index_funcionario_cpf` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `index_funcionario_endereco_id` (`endereco_id` ASC) VISIBLE,
  INDEX `index_funcionario_cargo_id` (`cargo_id` ASC) VISIBLE,
  INDEX `index_funcionario_obra_id` (`obra_id` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_cargo`
    FOREIGN KEY (`cargo_id`)
    REFERENCES `db_gestao_de_obras`.`cargo` (`id`),
  CONSTRAINT `fk_funcionario_endereco`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `db_gestao_de_obras`.`endereco` (`id`),
  CONSTRAINT `fk_funcionario_obra`
    FOREIGN KEY (`obra_id`)
    REFERENCES `db_gestao_de_obras`.`obra` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_funcionario_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `db_gestao_de_obras`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_gestao_de_obras`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gestao_de_obras`.`material` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `observacao` VARCHAR(255) NULL DEFAULT NULL,
  `peso` DOUBLE NULL DEFAULT NULL,
  `almoxarifado_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `index_material_almoxarifado_id` (`almoxarifado_id` ASC) VISIBLE,
  CONSTRAINT `fk_material_almoxarifado`
    FOREIGN KEY (`almoxarifado_id`)
    REFERENCES `db_gestao_de_obras`.`almoxarifado` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

