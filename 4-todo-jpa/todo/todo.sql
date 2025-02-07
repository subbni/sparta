CREATE TABLE users (
       id  BIGINT AUTO_INCREMENT PRIMARY KEY,
       name    VARCHAR(100) NOT NULL,
       email   VARCHAR(255) NOT NULL UNIQUE,
       password VARCHAR(255) NOT NULL,
       created_at  DATETIME NOT NULL,
       updated_at  DATETIME NOT NULL,
       account_status VARCHAR(20) NOT NULL
);

CREATE TABLE todos (
       id    BIGINT AUTO_INCREMENT PRIMARY KEY,
       user_id     BIGINT NOT NULL,
       title    VARCHAR(100) NOT NULL,
       content   VARCHAR(200),
       created_at  DATETIME NOT NULL,
       updated_at  DATETIME NOT NULL,
       FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE comments (
       id    BIGINT AUTO_INCREMENT PRIMARY KEY,
       user_id     BIGINT NOT NULL,
       todo_id     BIGINT NOT NULL,
       content   VARCHAR(255) NOT NULL,
       created_at  DATETIME NOT NULL,
       updated_at  DATETIME NOT NULL,
       FOREIGN KEY (user_id) REFERENCES users(id),
       FOREIGN KEY (todo_id) REFERENCES todos(id)
);