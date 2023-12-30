CREATE TABLE IF NOT EXISTS users (
    user_name VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

INSERT INTO users (user_name, password, enabled)
VALUES ('user', '{noop}jdbcDefault', true);