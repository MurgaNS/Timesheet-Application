START TRANSACTION;
CREATE table country
(
    id           BIGINT      NOT NULL AUTO_INCREMENT,
    country_code VARCHAR(20) NOT NULL UNIQUE,
    name         VARCHAR(40) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE table category
(
    id   BIGINT      NOT NULL AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE table client
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL UNIQUE,
    address     VARCHAR(50),
    city        VARCHAR(40),
    postal_code VARCHAR(20),
    FK_country_id  BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT client_country_id FOREIGN KEY (FK_country_id)
        REFERENCES country (id)


);

CREATE table project
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(10000),
    FK_client_id   BIGINT,
    status      VARCHAR(20),
    PRIMARY KEY (id),
    CONSTRAINT project_client_id FOREIGN KEY (FK_client_id)
        REFERENCES client (id)

);

CREATE table employee
(
    id             BIGINT      NOT NULL AUTO_INCREMENT,
    name           VARCHAR(50),
    username       VARCHAR(50) UNIQUE,
    password       VARCHAR(50),
    hours_per_week DECIMAL(4, 1) DEFAULT 0,
    email          VARCHAR(50) NOT NULL UNIQUE,
    status         VARCHAR(20),
    role           VARCHAR(20),
    PRIMARY KEY (id)
);


CREATE table work_log
(
    id          BIGINT        NOT NULL AUTO_INCREMENT,
    date        DATE,
    FK_client_id   BIGINT        NOT NULL,
    FK_project_id  BIGINT        NOT NULL,
    FK_category_id BIGINT        NOT NULL,
    description TEXT,
    hours       DECIMAL(4, 1) NOT NULL DEFAULT 0,
    overtime    DECIMAL(4, 1)          DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT work_log_client_id FOREIGN KEY (FK_client_id)
        REFERENCES client (id),
    CONSTRAINT work_log_project_id FOREIGN KEY (FK_project_id)
        REFERENCES project (id),
    CONSTRAINT work_log_category_id FOREIGN KEY (FK_category_id)
        REFERENCES category (id)

);

CREATE table project_employee
(
    FK_project_id  BIGINT NOT NULL,
    FK_employee_id BIGINT NOT NULL,
    CONSTRAINT project_employee_project_id FOREIGN KEY (FK_project_id)
        REFERENCES project (id),
    CONSTRAINT project_employee_employee_id FOREIGN KEY (FK_employee_id)
        REFERENCES employee (id)
);

CREATE table lead_employee
(
    FK_project_id  BIGINT NOT NULL,
    FK_employee_id BIGINT NOT NULL,
    CONSTRAINT lead_employee_project_id FOREIGN KEY (FK_project_id)
        REFERENCES project (id),
    CONSTRAINT lead_employee_employee_id FOREIGN KEY (FK_employee_id)
        REFERENCES employee (id)
);

COMMIT;







