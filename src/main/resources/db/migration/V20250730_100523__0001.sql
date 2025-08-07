CREATE TABLE client (
    uuid VARCHAR(36) PRIMARY KEY,
    document_type VARCHAR(30) NOT NULL,
    document_id VARCHAR(30) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    creation_date DATETIME NOT NULL,
    last_update DATETIME NOT NULL
);