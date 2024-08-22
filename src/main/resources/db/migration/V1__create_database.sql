CREATE TABLE product
(
    id             SERIAL PRIMARY KEY,
    name           VARCHAR NOT NULL,
    country        VARCHAR NOT NULL,
    manufacturer   VARCHAR NOT NULL,
    is_online      BOOLEAN NOT NULL,
    is_installment BOOLEAN NOT NULL
);

CREATE TABLE model
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR NOT NULL,
    serial_number VARCHAR NOT NULL UNIQUE,
    color         VARCHAR NOT NULL,
    size          VARCHAR NOT NULL,
    price         INTEGER NOT NULL,
    is_on_stock   BOOLEAN NOT NULL,
    product_id    INTEGER NOT NULL
);

CREATE TABLE computer_model
(
    id             INTEGER PRIMARY KEY,
    category       VARCHAR NOT NULL,
    processor_type VARCHAR NOT NULL
);

CREATE TABLE refrigerator_model
(
    id              INTEGER PRIMARY KEY,
    number_of_doors INTEGER NOT NULL,
    compressor_type VARCHAR NOT NULL
);

CREATE TABLE smartphone_model
(
    id                INTEGER PRIMARY KEY,
    memory            INTEGER NOT NULL,
    number_of_cameras INTEGER NOT NULL
);


CREATE TABLE television_model
(
    id          INTEGER PRIMARY KEY,
    tv_category VARCHAR NOT NULL,
    technology  VARCHAR NOT NULL
);

CREATE TABLE vacuum_cleaner_model
(
    id              INTEGER PRIMARY KEY,
    dust_bag_volume INTEGER NOT NULL,
    number_of_modes INTEGER NOT NULL
);

ALTER TABLE model
    ADD CONSTRAINT FK_MODEL_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE computer_model
    ADD CONSTRAINT FK_COMPUTER_MODEL FOREIGN KEY (id) REFERENCES model (id);
ALTER TABLE refrigerator_model
    ADD CONSTRAINT FK_REFRIGERATOR_MODEL FOREIGN KEY (id) REFERENCES model (id);
ALTER TABLE smartphone_model
    ADD CONSTRAINT FK_SMARTPHONE_MODEL FOREIGN KEY (id) REFERENCES model (id);
ALTER TABLE television_model
    ADD CONSTRAINT FK_TELEVISION_MODEL FOREIGN KEY (id) REFERENCES model (id);
ALTER TABLE vacuum_cleaner_model
    ADD CONSTRAINT FK_VACUUM_CLEANER_MODEL FOREIGN KEY (id) REFERENCES model (id);