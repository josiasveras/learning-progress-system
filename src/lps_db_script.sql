CREATE DATABASE lps_db;
USE lps_db;

CREATE TABLE hello_world (
	id int PRIMARY KEY,
    content varchar(255) NOT NULL
);

INSERT INTO hello_world (id, content)
VALUES 
(1, 'Hello, World!'),
(2, '¡Hola, Mundo!'),
(3, 'Ciao, mondo!'),
(4, 'Hallo, Welt!'),
(5, 'Saluton, mondo!'),
(6, 'Olá, Mundo!');