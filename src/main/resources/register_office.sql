DROP TABLE IF EXISTS ro_person;
DROP TABLE IF EXISTS ro_passport;

CREATE TABLE ro_person (
    person_id SERIAL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    patronymic VARCHAR(100),
    date_of_birth DATE NOT NULL,
    PRIMARY KEY (person_id)
);

CREATE TABLE ro_passport (
    passport_id SERIAL,
    person_id INTEGER NOT NULL,
    series VARCHAR(10) NOT NULL,
    number VARCHAR(10) NOT NULL,
    issue_date DATE NOT NULL,
    issue_department VARCHAR(200),
    PRIMARY KEY (passport_id),
    FOREIGN KEY (person_id) REFERENCES ro_person(person_id) ON DELETE RESTRICT
);