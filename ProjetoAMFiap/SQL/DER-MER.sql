


CREATE TABLE userform(
    user_id        NUMBER(5)
        CONSTRAINT user_pk PRIMARY KEY,
    firstname      VARCHAR2(30) NOT NULL,
    lastname       VARCHAR2(30) NOT NULL,
    email          NOT NULL UNIQUE,
    born_date      DATE NOT NULL,
    phone          VARCHAR2(20) NOT NULL,
    accesspassword VARCHAR2(30) NOT NULL
);

CREATE SEQUENCE user_id MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;


CREATE TABLE academictraining(
    at_id          NUMBER(5) 
        CONSTRAINT academictraining_pk PRIMARY KEY,
    start_date     DATE NOT NULL,
    end_date       DATE NOT NULL,
    institution    VARCHAR2(100) NOT NULL,
    course         VARCHAR2(70) NOT NULL,
    at_description VARCHAR2(200) NOT NULL,
    user_id        NUMBER(5)
);

CREATE SEQUENCE at_id MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;

ALTER TABLE academictraining ADD CONSTRAINT academictraining_user_fk FOREIGN KEY (user_id) REFERENCES userform (user_id);


CREATE TABLE professionalexperience(
    pe_id           NUMBER(5)
        CONSTRAINT professionalexperience_pk PRIMARY KEY,
    jobtitle        VARCHAR2(100) NOT NULL,
    employer        VARCHAR2(50) NOT NULL,
    start_date      DATE NOT NULL,
    end_date        DATE NOT NULL,
    job_description VARCHAR2(500)
    user_id         NUMBER(5)
);

CREATE SEQUENCE pe_id MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;

ALTER TABLE professionalexperience ADD CONSTRAINT professionalexperience_user_fk FOREIGN KEY (user_id) REFERENCES userform (user_id);


CREATE TABLE languages(
    lang_id    NUMBER(5)
        CONSTRAINT languages_pk PRIMARY KEY,
    lang       VARCHAR2(15) NOT NULL,
    lang_level VARCHAR2(15) NOT NULL,
    user_id    NUMBER(5)
);

CREATE SEQUENCE lang_id MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;

ALTER TABLE languages ADD CONSTRAINT languages_user_fk FOREIGN KEY (user_id) REFERENCES userform (user_id);


CREATE TABLE extracurricularcourses(
    ec_id        NUMBER(5)
        CONSTRAINT extracurricularcourses_pk PRIMARY KEY,
    extc_course  VARCHAR2(50) NOT NULL,
    course_level VARCHAR2(15) NOT NULL,
    user_id      NUMBER(5)
);

CREATE SEQUENCE ec_id MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;

ALTER TABLE extracurricularcourses ADD CONSTRAINT extracurricularcourses_user_fk FOREIGN KEY (user_id) REFERENCES userform (user_id);


CREATE TABLE bio(
    bio_id          NUMBER(5),
    bio_description VARCHAR2(300) NOT NULL
);

ALTER TABLE bio ADD CONSTRAINT bio_user_fk FOREIGN KEY (bio_id) REFERENCES userform (user_id);

ALTER TABLE bio ADD CONSTRAINT bio_pk PRIMARY KEY (bio_id);


CREATE TABLE locations(
    location_id NUMBER(5),
    country     VARCHAR2(20) NOT NULL,
    address     VARCHAR2(150) NOT NULL,
);

ALTER TABLE locations ADD CONSTRAINT location_user_fk FOREIGN KEY (location_id) REFERENCES userform (user_id);

ALTER TABLE locations ADD CONSTRAINT locations_pk PRIMARY KEY (location_id);


CREATE TABLE profession(
    profession_id NUMBER(5),
    profession_name VARCHAR2(30) NOT NULL
);

ALTER TABLE profession ADD CONSTRAINT profession_user_fk FOREIGN KEY (profession_id) REFERENCES userform (user_id);

ALTER TABLE profession ADD CONSTRAINT profession_pk PRIMARY KEY (profession_id);


CREATE TABLE jobopening(
    job_id         NUMBER(5)
        CONSTRAINT jobopening_pk PRIMARY KEY,
    jobname        VARCHAR2(100) NOT NULL,
    overview       VARCHAR2(300) NOT NULL,
    country        VARCHAR2(50) NOT NULL,
    city           VARCHAR2(50) NOT NULL,
    address        VARCHAR2(50) NOT NULL, 
    jobdescription VARCHAR2(500) NOT NULL
);

CREATE SEQUENCE job_id MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;


CREATE TABLE user_jobopening(
    job_id  NUMBER(5),
    user_id NUMBER(5)
);

ALTER TABLE user_jobopening ADD CONSTRAINT user_jobopening_job_fk FOREIGN KEY (job_id) REFERENCES jobopening(job_id);

ALTER TABLE user_jobopening ADD CONSTRAINT user_jobopening_user_fk FOREIGN KEY (user_id) REFERENCES userform(user_id);

ALTER TABLE user_jobopening ADD CONSTRAINT user_jobopening_pk PRIMARY KEY (job_id, user_id);


CREATE TABLE user_jobopening_feedback(
    job_id  NUMBER(5),
    user_id NUMBER(5),
    feedback VARCHAR2(300) NOT NULL
);

ALTER TABLE user_jobopening_feedback ADD CONSTRAINT user_jobopening_feedback_job_fk FOREIGN KEY (job_id) REFERENCES jobopening(job_id);

ALTER TABLE user_jobopening_feedback ADD CONSTRAINT user_jobopening_feedback_user_fk FOREIGN KEY (user_id) REFERENCES userform(user_id);

ALTER TABLE user_jobopening_feedback ADD CONSTRAINT user_jobopening_feedback_pk PRIMARY KEY (job_id, user_id);



CREATE TABLE employee(
    employee_id    NUMBER(5)
        CONSTRAINT employee_pk PRIMARY KEY,
    firstname      VARCHAR2(30) NOT NULL,
    lastname       VARCHAR2(30) NOT NULL,
    email          NOT NULL UNIQUE,
    born_date      DATE NOT NULL,
    phone          VARCHAR2(20) NOT NULL,
    accesspassword VARCHAR2(30) NOT NULL
);

CREATE SEQUENCE employee_id MINVALUE 1 START WITH 1 INCREMENT BY 1 NOCACHE;
