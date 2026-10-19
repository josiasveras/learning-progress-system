DROP DATABASE lps_db;
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

CREATE TABLE tasks (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    goal_id BIGINT NOT NULL,
    task_number INT NOT NULL,
    task_title VARCHAR(255) NOT NULL,
    task_description VARCHAR(255) NOT NULL,
    task_status VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    completed_date DATE,
    difficulty VARCHAR(255),
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tasks (goal_id, task_number, task_title, task_description, task_status, planned_date, completed_date, difficulty)
VALUES 
(1, 44, 'Trilha 03 - TAREFA 44 - Matemática', 'Estudo da aula 05, do tópico “Conjuntos Numéricos” até o final; e resolução de 5 questões.', 'IN_PROGRESS
', '2026-10-19', null, '4 — Difícil');