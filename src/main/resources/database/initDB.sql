CREATE TABLE IF NOT EXISTS swimming_product
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    manufacturer VARCHAR(255),
    price        SMALLINT
);