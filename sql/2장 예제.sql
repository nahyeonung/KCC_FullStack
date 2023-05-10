--2.1 예제
select first_name, last_name, salary from employees;

select * from departments;

select department_name, location_id from departments;

select location_id, department_name from departments;

select first_name, hire_date, salary from employees;

select first_name, last_name, salary, salary+salary*0.1 from employees;

select first_name, department_id, commission_pct from employees;

select first_name as 이름, salary 급여 from employees;

select first_name "employee name", salary*12 "annual salary" from employees;

select first_name || ' ' || last_name || '''s salary is $' || salary as "Employee Details" from employees;

select department_id from employees;

select distinct department_id from employees;

select rowid, rownum, employee_id, first_name from employees;