DROP TABLE IF EXISTS LOGIN;
DROP TABLE IF EXISTS USUARIO;
CREATE TABLE LOGIN(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    IP VARCHAR(100) NOT NULL,
    ACCION VARCHAR(30) NOT NULL,
    NOMBRE_USUARIO VARCHAR(50) NOT NULL,
    TOKEN VARCHAR(100) NOT NULL,
    FECHA_CREACION DATE NOT NULL
);

CREATE TABLE USUARIO(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(30) NOT NULL,
    FECHA_CREACION DATE NOT NULL
);