INSERT INTO "division" (CODE, DESCRIPTION)
VALUES ('BA', 'Business-analysts'),
       ('QA', 'Quality assurance'),
       ('Java', 'Lava division'),
       ('.Net', '.Net division'),
       ('PHP', 'PHP division');

INSERT INTO "user" (LOGIN, PASSWORD, DIVISION_ID)
VALUES ('BA', '$2y$10$1ASV/pheHyN/SYWpfg9dpeQrQXz04jMiiXwFWz0OOIKpvON9TYT.2', 1),
       ('QA', '$2y$10$xJwG3LwkIx7WWxz0CwqhqeNENKDc86Ey/DBJLuzZET0khqwheALn.', 2),
       ('Java', '$2y$10$BKSGPKv9y4IkoWS4I/RmsexdYLtbiA8Wvrjwx9.5XsB3UEZ5ZNfeu', 3),
       ('.Net', '$2y$10$UChQW728aWunWQEPNwWeVeCfrwvEMcb2rESXxFenfJMN9qs9sqdje', 4),
       ('PHP', '$2y$10$kIUbVa.Z3J.xR7mZmPFx.uriiIRm6eVQ53MMyf8up1a5ElXCCOS5u', 5);

INSERT INTO "employee" (FIRST_NAME, LAST_NAME, TITLE, DIVISION_ID)
VALUES ('John', 'Doe', 'JUNIOR', 1),
       ('Sarah', 'Conor', 'JUNIOR', 1),
       ('John', 'Conor', 'JUNIOR', 1),
       ('Stanford', 'Pines', 'MIDDLE', 1),
       ('Gideon', 'Glisson', 'MIDDLE', 1),
       ('Shaldon', 'Kooper', 'SENIOR', 1),
       ('Shally', 'Kory', 'SENIOR', 1);

INSERT INTO "employee" (FIRST_NAME, LAST_NAME, TITLE, DIVISION_ID)
VALUES ('John', 'Snow', 'JUNIOR', 2),
       ('Tyrion', 'Lanister', 'JUNIOR', 2),
       ('Jamie', 'Lanister', 'JUNIOR', 2),
       ('Duncan', 'McLaod', 'MIDDLE', 2),
       ('Connor', 'McLaod', 'MIDDLE', 2),
       ('Arya', 'Stark', 'SENIOR', 2);

INSERT INTO "salary_payment" (PER_YEAR, PER_MONTH, EXPECTED_WORKED_TIME, ACTUAL_WORKED_TIME, SALARY_RATE, SALARY_PAYED, EMPLOYEE_ID)
VALUES (2022, 1, 159, 159, 500, 500, 1),
       (2022, 1, 159, 159, 600, 600, 2),
       (2022, 1, 159, 159, 700, 700, 3),
       (2022, 1, 159, 159, 1000, 1000, 4),
       (2022, 1, 159, 159, 1100, 1100, 5),
       (2022, 1, 159, 159, 2000, 2000, 6),
       (2022, 1, 159, 159, 2500, 2500, 7),
       (2022, 1, 159, 159, 400, 400, 8),
       (2022, 1, 159, 159, 300, 300, 9),
       (2022, 1, 159, 159, 500, 500, 10),
       (2022, 1, 159, 159, 1500, 1500, 11),
       (2022, 1, 159, 159, 2000, 2000, 12),
       (2022, 1, 159, 159, 3000, 3000, 13);

INSERT INTO "salary_payment" (PER_YEAR, PER_MONTH, EXPECTED_WORKED_TIME, ACTUAL_WORKED_TIME, SALARY_RATE, SALARY_PAYED, EMPLOYEE_ID)
VALUES (2022, 2, 160, 160, 550, 550, 1),
       (2022, 2, 160, 160, 650, 650, 2),
       (2022, 2, 160, 160, 750, 750, 3),
       (2022, 2, 160, 160, 1050, 1050, 4),
       (2022, 2, 160, 160, 1150, 1150, 5),
       (2022, 2, 160, 160, 2050, 2050, 6),
       (2022, 2, 160, 160, 2550, 2550, 7),
       (2022, 2, 160, 160, 450, 450, 8),
       (2022, 2, 160, 160, 350, 350, 9),
       (2022, 2, 160, 160, 550, 550, 10),
       (2022, 2, 160, 160, 1550, 1550, 11),
       (2022, 2, 160, 160, 2050, 2050, 12),
       (2022, 2, 160, 160, 3050, 3050, 13);

INSERT INTO "salary_payment" (PER_YEAR, PER_MONTH, EXPECTED_WORKED_TIME, ACTUAL_WORKED_TIME, SALARY_RATE, SALARY_PAYED, EMPLOYEE_ID)
VALUES (2022, 3, 175, 175, 555, 555, 1),
       (2022, 3, 175, 175, 655, 655, 2),
       (2022, 3, 175, 175, 755, 755, 3),
       (2022, 3, 175, 175, 1055, 1055, 4),
       (2022, 3, 175, 175, 1155, 1155, 5),
       (2022, 3, 175, 175, 2055, 2055, 6),
       (2022, 3, 175, 175, 2555, 2555, 7),
       (2022, 3, 175, 175, 455, 455, 8),
       (2022, 3, 175, 175, 355, 355, 9),
       (2022, 3, 175, 175, 555, 555, 10),
       (2022, 3, 175, 175, 1555, 1555, 11),
       (2022, 3, 175, 175, 2055, 2055, 12),
       (2022, 3, 175, 175, 3055, 3055, 13);