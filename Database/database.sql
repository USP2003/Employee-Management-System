-- Create Employees Table
CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    email VARCHAR2(50),
    department_id NUMBER,
    salary NUMBER,
    hire_date DATE
);

-- Create Salary History Table
CREATE TABLE salary_history (
    salary_id NUMBER PRIMARY KEY,
    employee_id NUMBER,
    old_salary NUMBER,
    new_salary NUMBER,
    change_date DATE
);

-- Create Sequence
CREATE SEQUENCE salary_seq START WITH 1 INCREMENT BY 1;

-- Create Procedure
CREATE OR REPLACE PROCEDURE update_salary
(
p_emp_id NUMBER,
p_new_salary NUMBER
)
IS
v_old_salary NUMBER;
BEGIN

SELECT salary INTO v_old_salary
FROM employees
WHERE employee_id = p_emp_id;

UPDATE employees
SET salary = p_new_salary
WHERE employee_id = p_emp_id;

INSERT INTO salary_history
(salary_id, employee_id, old_salary, new_salary, change_date)
VALUES
(salary_seq.NEXTVAL, p_emp_id, v_old_salary, p_new_salary, SYSDATE);

COMMIT;

END;
/