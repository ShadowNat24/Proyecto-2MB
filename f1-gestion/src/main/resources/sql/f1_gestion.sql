CREATE DATABASE IF NOT EXISTS f1_gestion CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE f1_gestion;

CREATE TABLE IF NOT EXISTS proveedor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(120) NOT NULL,
    email_contacto VARCHAR(160)
);

CREATE TABLE IF NOT EXISTS escuderia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(120) NOT NULL,
    proveedor_id INT,
    CONSTRAINT fk_escuderia_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
);

CREATE TABLE IF NOT EXISTS piloto (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(120) NOT NULL,
    nacionalidad VARCHAR(80),
    fecha_nacimiento DATE,
    proveedor_id INT,
    CONSTRAINT fk_piloto_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
);

CREATE TABLE IF NOT EXISTS auto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    modelo VARCHAR(100) NOT NULL,
    anio_fabricacion INT,
    escuderia_id INT,
    CONSTRAINT fk_auto_escuderia FOREIGN KEY (escuderia_id) REFERENCES escuderia(id)
);

CREATE TABLE IF NOT EXISTS circuito (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(120) NOT NULL,
    pais VARCHAR(80),
    longitud_pista DECIMAL(8,3),
    vueltas INT
);

CREATE TABLE IF NOT EXISTS temporada (
    anio INT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS gran_premio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(120) NOT NULL,
    fecha DATE,
    temporada_anio INT,
    circuito_id INT,
    CONSTRAINT fk_gp_temporada FOREIGN KEY (temporada_anio) REFERENCES temporada(anio),
    CONSTRAINT fk_gp_circuito FOREIGN KEY (circuito_id) REFERENCES circuito(id)
);

CREATE TABLE IF NOT EXISTS participacion_temporada (
    numero_competidor INT NOT NULL,
    temporada_anio INT NOT NULL,
    piloto_codigo INT NOT NULL,
    auto_id INT NOT NULL,
    PRIMARY KEY (numero_competidor, temporada_anio, piloto_codigo),
    CONSTRAINT fk_part_temporada FOREIGN KEY (temporada_anio) REFERENCES temporada(anio),
    CONSTRAINT fk_part_piloto FOREIGN KEY (piloto_codigo) REFERENCES piloto(codigo),
    CONSTRAINT fk_part_auto FOREIGN KEY (auto_id) REFERENCES auto(id)
);

CREATE TABLE IF NOT EXISTS resultado (
    gran_premio_id INT NOT NULL,
    numero_competidor INT NOT NULL,
    temporada_anio INT NOT NULL,
    piloto_codigo INT NOT NULL,
    posicion INT,
    vueltas_completadas INT,
    tiempo_por_vuelta DECIMAL(12,4),
    puntos INT,
    PRIMARY KEY (gran_premio_id, numero_competidor, temporada_anio, piloto_codigo),
    CONSTRAINT fk_resultado_gp FOREIGN KEY (gran_premio_id) REFERENCES gran_premio(id),
    CONSTRAINT fk_resultado_participacion FOREIGN KEY (numero_competidor, temporada_anio, piloto_codigo)
        REFERENCES participacion_temporada(numero_competidor, temporada_anio, piloto_codigo)
);
