CREATE TABLE classrooms(
    id VARCHAR(255) NOT NULL PRIMARY KEY UNIQUE,
    name VARCHAR(255) NOT NULL UNIQUE,
    localization VARCHAR(255) NOT NULL UNIQUE
)