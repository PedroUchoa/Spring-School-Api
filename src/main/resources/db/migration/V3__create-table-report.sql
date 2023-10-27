CREATE TABLE school_report(
    id VARCHAR(255) NOT NULL PRIMARY KEY UNIQUE,
    semester VARCHAR(255) NOT NULL UNIQUE,
    is_active BOOLEAN NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE
)