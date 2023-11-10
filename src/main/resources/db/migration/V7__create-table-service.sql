CREATE TABLE general_services(
    id VARCHAR(255) NOT NULL PRIMARY KEY UNIQUE,
    name VARCHAR(255) NOT NULL,
    salary DOUBLE NOT NULL,
    is_active BOOLEAN NOT NULL,
    phone VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE
)