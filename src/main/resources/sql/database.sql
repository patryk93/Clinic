-- -----------------------------------------------------
-- Schema clinic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `clinic` DEFAULT CHARACTER SET utf8 ;
USE `clinic` ;

-- -----------------------------------------------------
-- Table `clinic`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`users` (
                                                   `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
                                                   `first_name` VARCHAR(245) NULL COMMENT 'Imię',
    `last_name` VARCHAR(245) NULL COMMENT 'Nazwisko',
    `email` VARCHAR(245) NULL COMMENT 'Adres email',
    `password` VARCHAR(60) NULL COMMENT 'Hasło',
    `superadmin` TINYINT(1) NULL COMMENT 'Czy użytkownik jest Super Administratorem.',
    `enable` TINYINT(1) NOT NULL DEFAULT '1' COMMENT 'Czy jest aktywny i może się logować.',
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    COMMENT = 'Tabela zawierająca dane użytkowników';


-- -----------------------------------------------------
-- Table `clinic`.`patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`patients` (
                                                `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
                                                `first_name` VARCHAR(245) NULL COMMENT 'Imię',
    `last_name` VARCHAR(245) NULL COMMENT 'Nazwisko',
    `email` VARCHAR(245) NULL COMMENT 'Adres email',
    `phone_number` VARCHAR(13) NULL COMMENT 'Numer telefonu',
    `adress` VARCHAR(300) NULL COMMENT 'Adres do korespondencji',
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    COMMENT = 'Tabela zawierająca dane pacjentów';

-- -----------------------------------------------------
-- Table `clinic`.`doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`doctors` (
                                                `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
                                                `first_name` VARCHAR(245) NULL COMMENT 'Imię',
    `last_name` VARCHAR(245) NULL COMMENT 'Nazwisko',
    `email` VARCHAR(245) NULL COMMENT 'Adres email',
    `phone_number` VARCHAR(13) NULL COMMENT 'Numer telefonu',
    `adress` VARCHAR(300) NULL COMMENT 'Adres do korespondencji',
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    COMMENT = 'Tabela zawierająca dane lekarzy';


-- -----------------------------------------------------
-- Table `clinic`.`visits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`visits` (
                                                   `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
                                                   `name` VARCHAR(255) NULL COMMENT 'Nazwa wizyty.',
    `ingredients` TEXT NULL COMMENT 'Składniki przepisu.',
    `description` TEXT NULL COMMENT 'Opis przepisu.',
    `created` DATETIME NULL COMMENT 'Data dodania.',
    `updated` DATETIME NULL COMMENT 'Data edycji.',
    `preparation_time` INT NULL COMMENT 'Czas przygotowania w minutach.',
    `preparation` TEXT NULL COMMENT 'Sposób przygotowania.',
    `patient_id` INT NOT NULL COMMENT 'Klucz obcy tabeli patients.',
    `doctor_id` INT NOT NULL COMMENT 'Klucz obcy tabeli doctors.',
    `user_id` INT NOT NULL COMMENT 'Klucz obcy tabeli users.',
    PRIMARY KEY (`id`),
    INDEX `fk_visits_patients1_idx` (`patient_id` ASC),
    CONSTRAINT `fk_visits_patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `clinic`.`patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

    INDEX `fk_visits_doctors1_idx` (`doctor_id` ASC),
    CONSTRAINT `fk_visits_doctors1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `clinic`.`doctors` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

    INDEX `fk_visits_users1_idx` (`user_id` ASC),
    CONSTRAINT `fk_visits_users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `clinic`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    COMMENT = 'Tabela zawierająca wizyty';


-- -----------------------------------------------------
-- Table `clinic`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`plan` (
                                                 `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli',
                                                 `name` VARCHAR(45) NULL COMMENT 'Nazwa planu.',
    `description` TEXT NULL COMMENT 'Opis planu',
    `created` DATETIME NULL COMMENT 'Data utworzenia.',
    `admin_id` INT NOT NULL COMMENT 'Klucz obcy tabeli admins.',
    PRIMARY KEY (`id`),
    INDEX `fk_plan_admins1_idx` (`admin_id` ASC),
    CONSTRAINT `fk_plan_admins1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `clinic`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    COMMENT = 'Tabela zawierająca informacje na temat planów.';


-- -----------------------------------------------------
-- Table `clinic`.`day_name`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`day_name` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(45) NULL COMMENT 'Nazwa dnia.',
    `display_order` INT NULL COMMENT 'Kolejność wyświetlania.',
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    COMMENT = 'Tabela zawierająca nazwy dni.';


-- -----------------------------------------------------
-- Table `clinic`.`recipe_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `clinic`.`recipe_plan` (
                                                        `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Klucz główny tabeli.',
                                                        `recipe_id` INT NOT NULL COMMENT 'Klucz obcy tabeli przepisów.',
                                                        `meal_name` VARCHAR(245) NULL COMMENT 'Nazwa posiłku',
    `display_order` INT NULL COMMENT 'Kolejność wyświetlania posiłku w ciągu dnia.',
    `day_name_id` INT NOT NULL COMMENT 'Klucz obcy tabeli dni.',
    `plan_id` INT NOT NULL COMMENT 'Klucz obcy tabeli plany.',
    PRIMARY KEY (`id`),
    INDEX `fk_recipe_plan_recipe1_idx` (`recipe_id` ASC),
    INDEX `fk_recipe_day_day_name1_idx` (`day_name_id` ASC),
    INDEX `fk_recipe_plan_plan1_idx` (`plan_id` ASC),
    CONSTRAINT `fk_recipe_plan_recipe1`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `clinic`.`visits` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_recipe_day_day_name1`
    FOREIGN KEY (`day_name_id`)
    REFERENCES `clinic`.`day_name` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_recipe_plan_plan1`
    FOREIGN KEY (`plan_id`)
    REFERENCES `clinic`.`plan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    COMMENT = 'Tabela zawierająca informacje o połączeniu przepisu oraz planu.';

