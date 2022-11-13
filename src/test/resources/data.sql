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

