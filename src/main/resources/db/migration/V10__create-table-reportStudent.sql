CREATE TABLE report_student(
    student_id VARCHAR(255) NOT NULL,
    school_report_id VARCHAR(255) NOT NULL,
    CONSTRAINT fk_students_id FOREIGN KEY (student_id) REFERENCES students(id),
    CONSTRAINT fk_school_report_id FOREIGN KEY (school_report_id) REFERENCES school_report(id)
)