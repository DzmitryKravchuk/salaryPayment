DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS "salary_payment";
DROP TABLE IF EXISTS "employee";
DROP TABLE IF EXISTS "division";

CREATE TABLE IF NOT EXISTS "division" (
    ID serial NOT NULL,
    CODE varchar(100) NOT NULL UNIQUE,
    DESCRIPTION varchar(255),
    CONSTRAINT office_pk PRIMARY KEY (ID)
);



CREATE TABLE IF NOT EXISTS "employee" (
    ID serial NOT NULL,
    FIRST_NAME varchar(255) NOT NULL,
    LAST_NAME varchar(255) NOT NULL,
    TITLE varchar(100) NOT NULL,
    DIVISION_ID bigint NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (ID)
);



CREATE TABLE IF NOT EXISTS "salary_payment" (
    ID serial NOT NULL,
    PER_YEAR int NOT NULL,
    PER_MONTH int NOT NULL,
    EXPECTED_WORKED_TIME int NOT NULL,
    ACTUAL_WORKED_TIME int NOT NULL,
    SALARY_RATE int NOT NULL,
    SALARY_PAYED int NOT NULL,
    EMPLOYEE_ID bigint NOT NULL,
    CONSTRAINT salary_payment_pk PRIMARY KEY (ID)
    );



CREATE TABLE IF NOT EXISTS "user" (
    ID serial NOT NULL,
    LOGIN varchar(255) NOT NULL,
    PASSWORD varchar(255) NOT NULL,
    DIVISION_ID bigint NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (ID)
    );

ALTER TABLE "employee" ADD CONSTRAINT employee_division_fk0 FOREIGN KEY (DIVISION_ID) REFERENCES "division"(ID);

ALTER TABLE "salary_payment" ADD CONSTRAINT salaryPayment_employee_fk0 FOREIGN KEY (EMPLOYEE_ID) REFERENCES "employee"(ID);

ALTER TABLE "user" ADD CONSTRAINT user_division_fk0 FOREIGN KEY (DIVISION_ID) REFERENCES "division"(ID);


