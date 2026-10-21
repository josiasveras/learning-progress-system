CREATE DATABASE lps_db;
USE lps_db;

CREATE TABLE hello_world (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
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
    task_status VARCHAR(255) NOT NULL DEFAULT 'PLANNED',
    start_date DATETIME,
    due_date DATETIME,
    completed_date DATETIME,
    difficulty VARCHAR(255) NOT NULL DEFAULT 'MODERATE',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tasks (goal_id, task_number, task_title, task_description, start_date, due_date, completed_date, difficulty)
VALUES 
(1, 44, 'Trilha 03 - TAREFA 44 - Matemática', 'Estudo da aula 05, do tópico “Conjuntos Numéricos” até o final; e resolução de 5 questões.', null, null, null, 'MODERATE');