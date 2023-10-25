CREATE TABLE service_classroom(
    general_services_id VARCHAR(255) NOT NULL,
    classrooms_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_general_services_id FOREIGN KEY (general_services_id) REFERENCES general_services(id),
    CONSTRAINT fk_classrooms_id FOREIGN KEY (classrooms_id) REFERENCES classrooms(id)
)