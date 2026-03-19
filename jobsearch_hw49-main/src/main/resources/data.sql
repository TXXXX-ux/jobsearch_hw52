INSERT INTO users (name, phone_number, email, password) VALUES
('Tyler Durden', '555-0101', 'tyler@fightclub.com', 'soap123'),
('Robert Paulson', '555-0202', 'bob@projectmayhem.com', 'bitchtits');

INSERT INTO resumes (user_id, category, title, info) VALUES
(1, 'Sales', 'Sales Manager', 'Expert in soap sales'),
(1, 'Security', 'Night Watchman', 'Invisible and alert');

INSERT INTO vacancies (user_id, category, title, description) VALUES
(2, 'IT', 'Java Developer', 'Looking for someone to fix the system'),
(2, 'Sales', 'Retail Assistant', 'Soap shop assistant needed');

-- тут я добавлю тестового юзера, если его не будет
INSERT INTO users (name, surname, age, email, password, phone_number)
VALUES ('test', 'test', 20, 'test@gmail.com', '123', '0555123456');

-- здесь я добавлю тестовую вакансию (user_id = 1, так как это будет наш первый юзер)
INSERT INTO vacancies (user_id, category, title, description)
VALUES (1, 'IT', 'Java Developer', 'Strong Junior with Spring skills');

INSERT INTO responses (vacancy_id, resume_id) VALUES (2, 1);