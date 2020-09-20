DROP TABLE IF EXISTS JOBPORTAL;
DROP TABLE IF EXISTS DESIGNATION;
DROP TABLE IF EXISTS EMPLOYEE;

  
CREATE TABLE EMPLOYEE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL,
  PHONE VARCHAR(250) NOT NULL,
  DESIGNATION_CODE VARCHAR(5) NOT NULL,
  SALARY_EXP VARCHAR(250) NOT NULL,
  EXPERIENCE INT NOT NULL
);

  
CREATE TABLE DESIGNATION (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  CODE VARCHAR(5) NOT NULL,
  DESIGNATION VARCHAR(250) NOT NULL
);

  
 
CREATE TABLE JOBPORTAL(
  JOBID INT AUTO_INCREMENT  PRIMARY KEY,
  COMPANY_NAME VARCHAR(250) NOT NULL,
  DESGINATION_CODE VARCHAR(5) NOT NULL,
  SALARY_PROVIDED VARCHAR(250) NOT NULL,
  EXPERIENCE INT NOT NULL
);