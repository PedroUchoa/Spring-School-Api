CREATE TABLE administrations(
        id VARCHAR(255) NOT NULL PRIMARY KEY UNIQUE,
        name VARCHAR(255) NOT NULL UNIQUE,
        salary DOUBLE NOT NULL,
        is_active BOOLEAN NOT NULL,
        phone VARCHAR(255) NOT NULL,
        start_date DATE NOT NULL,
        end_date DATE,
        functional VARCHAR(255) NOT NULL UNIQUE
)