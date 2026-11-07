CREATE DATABASE lps_db;
USE lps_db;

CREATE TABLE hello_world (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content varchar(255) NOT NULL
);

-- 1. Create the “goals” table (with ‘start_task_id’ and “target_task_id” set to null initially)
CREATE TABLE goals (
	goal_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    goal_name VARCHAR(255) NOT NULL,
    goal_description TEXT,
    goal_start_date DATE,
    goal_target_date DATE,
    start_task_id BIGINT NULL,  -- Optional during creation to prevent logical deadlocks
    target_task_id BIGINT NULL, -- Optional during creation to prevent logical deadlocks
    goal_status VARCHAR(50),
    goal_created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 2. Create the “tasks” table (which must be linked to a goal)
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
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    content_link VARCHAR(2048),
	note TEXT
);
