# simplecrudjsp
java server web

MysqlConnUtils.java

  String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;



  Create database jspexampledb;
  use jspexampledb;

  CREATE TABLE `usuario` (
    `id` INT(12) NOT NULL AUTO_INCREMENT,
    `identidad` VARCHAR(50) NOT NULL,
    `nombre` VARCHAR(100) NOT NULL,
    `departamento` VARCHAR(150) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `identidad` (`identidad`)
  )
  COLLATE='utf8_general_ci'
  ENGINE=InnoDB
  AUTO_INCREMENT=2
  ;
