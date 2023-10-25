CREATE TABLE subject_grades(
    school_grades_id VARCHAR(255) NOT NULL,
    school_subject_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_school_grades_id FOREIGN KEY (school_grades_id) REFERENCES school_grades(id),
    CONSTRAINT fk_school_subject_id FOREIGN KEY (school_subject_id) REFERENCES school_subject(id)
)