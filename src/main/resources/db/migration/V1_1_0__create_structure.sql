CREATE TABLE IF NOT EXISTS Company (
    id INT NOT NULL PRIMARY KEY,
    INN BIGINT NOT NULL,
    OGRN BIGINT NOT NULL,
    name VARCHAR(250),
    address VARCHAR(350)
 );
