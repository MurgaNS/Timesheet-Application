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
    country_id  BIGINT,
    is_deleted boolean DEFAULT FALSE NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK__client_country_id FOREIGN KEY (country_id)
        REFERENCES country (id)


);

CREATE table project
(
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(10000),
    client_id   BIGINT,
    status      VARCHAR(20),
    PRIMARY KEY (id),
    CONSTRAINT FK__project_client_id FOREIGN KEY (client_id)
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
    client_id   BIGINT        NOT NULL,
    project_id  BIGINT        NOT NULL,
    category_id BIGINT        NOT NULL,
    description TEXT,
    hours       DECIMAL(4, 1) NOT NULL DEFAULT 0,
    overtime    DECIMAL(4, 1)          DEFAULT 0,
    PRIMARY KEY (id),
    CONSTRAINT FK__work_log_client_id FOREIGN KEY (client_id)
        REFERENCES client (id),
    CONSTRAINT FK__work_log_project_id FOREIGN KEY (project_id)
        REFERENCES project (id),
    CONSTRAINT FK__work_log_category_id FOREIGN KEY (category_id)
        REFERENCES category (id)

);

CREATE table project_employee
(
    project_id  BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    CONSTRAINT FK__project_employee_project_id FOREIGN KEY (project_id)
        REFERENCES project (id),
    CONSTRAINT FK__project_employee_employee_id FOREIGN KEY (employee_id)
        REFERENCES employee (id)
);

CREATE table lead_employee
(
    project_id  BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    CONSTRAINT FK__lead_employee_project_id FOREIGN KEY (project_id)
        REFERENCES project (id),
    CONSTRAINT FK__lead_employee_employee_id FOREIGN KEY (employee_id)
        REFERENCES employee (id)
);

COMMIT;







