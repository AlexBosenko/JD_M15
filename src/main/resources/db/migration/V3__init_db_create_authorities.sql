CREATE TABLE IF NOT EXISTS authorities (
    user_name VARCHAR(50) NOT NULL PRIMARY KEY,
    authority VARCHAR(100) NOT NULL
);

INSERT INTO authorities (user_name, authority)
VALUES ('user', 'user');