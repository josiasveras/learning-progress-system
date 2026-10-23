CREATE TABLE hello_world (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content varchar(255) NOT NULL
);

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
