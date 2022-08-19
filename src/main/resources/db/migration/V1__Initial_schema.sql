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
    country_id  BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country (id)

);

CREATE table project
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(50),
    client_id   BIGINT UNIQUE,
    status      VARCHAR(20),
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client (id)

);

CREATE table employee
(
    id             BIGINT      NOT NULL AUTO_INCREMENT,
    name           VARCHAR(50),
    username       VARCHAR(50),
    password       VARCHAR(50),
    hours_per_week DOUBLE,
    email          VARCHAR(50) NOT NULL UNIQUE,
    status         VARCHAR(20),
    role           VARCHAR(20),
    PRIMARY KEY (id)
);


CREATE table work_log
(
    id          BIGINT NOT NULL AUTO_INCREMENT,
    date        DATE,
    client_id   BIGINT NOT NULL,
    project_id  BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    description VARCHAR(300),
    hours       DOUBLE NOT NULL,
    overtime    DOUBLE,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE table project_employee
(
    project_id  BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);

CREATE table lead_employee
(
    project_id  BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
);







