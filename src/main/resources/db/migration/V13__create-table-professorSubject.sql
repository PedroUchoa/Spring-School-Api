CREATE TABLE professor_subject(
    professor_id VARCHAR(255) NOT NULL,
    school_subject_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_professor_id FOREIGN KEY (professor_id) REFERENCES professor(id),
    CONSTRAINT fk_school_subject_2_id FOREIGN KEY (school_subject_id) REFERENCES school_subject(id)
)