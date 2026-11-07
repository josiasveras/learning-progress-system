CREATE DATABASE lps_db;
USE lps_db;

-- 0. Create the “hello_world” test table
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
	task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    goal_id BIGINT NOT NULL,
    task_number INT NOT NULL,
    task_title VARCHAR(255) NOT NULL,
    task_description VARCHAR(255) NOT NULL,
    task_status VARCHAR(255) NOT NULL DEFAULT 'PLANNED',
    task_start_date DATETIME,
    task_due_date DATETIME,
    task_completed_date DATETIME,
    task_difficulty VARCHAR(255) NOT NULL DEFAULT 'MODERATE',
    task_created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    task_content_link VARCHAR(2048),
	task_note TEXT,
    
    CONSTRAINT fk_tasks_goal_id  
        FOREIGN KEY (goal_id) 
        REFERENCES goals(goal_id) 
        ON DELETE CASCADE -- If a goal is deleted, its tasks are also deleted (optional)
);

-- 3. Adding the foreign keys from goals to tasks (using ALTER TABLE to avoid ordering conflicts)
ALTER TABLE goals
    ADD CONSTRAINT fk_goals_start_task_id
    FOREIGN KEY (start_task_id) 
    REFERENCES tasks(task_id) 
    ON DELETE SET NULL;

ALTER TABLE goals
    ADD CONSTRAINT fk_goals_target_task_id
    FOREIGN KEY (target_task_id) 
    REFERENCES tasks(task_id) 
    ON DELETE SET NULL;


