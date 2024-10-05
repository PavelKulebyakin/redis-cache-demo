CREATE TABLE IF NOT EXISTS item (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO item (name) VALUES ('Sample Item 1');
INSERT INTO item (name) VALUES ('Sample Item 2');
