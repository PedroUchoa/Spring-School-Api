CREATE TABLE report_grades(
    school_grades_id VARCHAR(255) NOT NULL,
    school_report_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_school_grades_2_id FOREIGN KEY (school_grades_id) REFERENCES school_grades(id),
    CONSTRAINT fk_school_report_2_id FOREIGN KEY (school_report_id) REFERENCES school_report(id)
)