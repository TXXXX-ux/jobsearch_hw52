DROP TABLE IF EXISTS responses;
DROP TABLE IF EXISTS resumes;
DROP TABLE IF EXISTS vacancies;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    age INT,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    phone_number VARCHAR(255)
);

CREATE TABLE vacancies (
    id SERIAL PRIMARY KEY,
    user_id INT,
    category VARCHAR(255),
    title VARCHAR(255),
    description TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE resumes (
    id SERIAL PRIMARY KEY,
    user_id INT,
    category VARCHAR(255),
    title VARCHAR(255),
    info TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE responses (
    id SERIAL PRIMARY KEY,
    vacancy_id INT,
    resume_id INT,
    FOREIGN KEY (vacancy_id) REFERENCES vacancies(id),
    FOREIGN KEY (resume_id) REFERENCES resumes(id)
);