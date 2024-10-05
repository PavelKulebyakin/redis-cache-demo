CREATE TABLE IF NOT EXISTS item (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO item (name, quantity) VALUES ('Sample Item 1', 2);
INSERT INTO item (name, quantity) VALUES ('Sample Item 2', 5);
