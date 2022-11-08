DROP TABLE IF EXISTS ro_passport;
DROP TABLE IF EXISTS ro_person;

CREATE TABLE ro_person (
    person_id SERIAL,
    sex SMALLINT NOT NULL,
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

INSERT INTO ro_person (sex, first_name, last_name, patronymic, date_of_birth)
VALUES (1, 'Elena', 'Kasatkina', 'Sergeevna', '1998-03-24'),
(2, 'Oleg', 'Kasatkin', 'Petrovich', '1997-10-16');

INSERT INTO ro_passport (person_id, series, number, issue_date, issue_department)
VALUES (1, 'HB', '123456', '2018-11-02', 'Petrovskoye ROVD');