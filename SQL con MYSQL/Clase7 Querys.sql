CREATE DATABASE tienda;
USE tienda;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    activo BOOLEAN DEFAULT TRUE,
    fecha_registro DATE
);

DESCRIBE usuario;

INSERT INTO usuario (nombre, correo, fecha_registro)
VALUES ('Ana Torres', 'ana@correo.com', '2026-07-01');

INSERT INTO usuario (nombre, correo, fecha_registro)
VALUES ('Carlos Ruiz', 'carlos@correo.com', '2026-07-05');

SELECT * FROM usuario;

CREATE TABLE perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL UNIQUE,
    bio VARCHAR(255),
    telefono VARCHAR(20),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

INSERT INTO perfil (usuario_id, bio, telefono)
VALUES (1, 'Desarrolladora backend', '3001234567');

INSERT INTO perfil (usuario_id, bio, telefono)
VALUES (2, 'Disenador UX', '3009876543');

SELECT * FROM perfil;

SELECT nombre, ciudad
FROM cliente;

SELECT producto, monto
FROM pedido
WHERE monto > 100000;

SELECT producto, monto
FROM pedido
ORDER BY monto DESC;

SELECT cliente.nombre, pedido.producto, pedido.monto
FROM cliente
JOIN pedido ON cliente.id = pedido.cliente_id
ORDER BY cliente.nombre;

USE tienda;

select * from cliente;
USE tienda;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    ciudad VARCHAR(60)
);

CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto VARCHAR(100) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    cliente_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
); 

select * from cliente;
USE tienda; 

