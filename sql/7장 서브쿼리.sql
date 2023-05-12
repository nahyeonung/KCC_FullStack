--7Àå ¼­ºêÄõ¸®
select first_name, salary
from employees
where salary > (select salary
from employees
where first_name = 'Nancy');

select first_name, job_id, hire_date
from employees
where job_id = (select job_id
from employees
where employee_id = 103);

select first_name, job_id, hire_date
from employees
where job_id = (select job_id
from employees
where employee_id=103);

select salary
from employees
where first_name = 'David';

select first_name, salary
from employees
where salary > any (select salary
from employees where first_name = 'David');

select first_name, department_id, job_id
from employees
where department_id in (select department_id from employees
where first_name = 'David');

select first_name, department_id, job_id
from employees e 
where exists(select * from departments d
where d.manager_id = e.employee_id);

select first_name, e.department_id, job_id
from departments d
join employees e
on d.manager_id = e.employee_id
order by e.department_id;

select first_name, salary
from employees a
where salary > (select avg(salary)
from employees b
where b.department_id = a.department_id);

select employee_id,
lpad(' ', 3*(level-1)) || first_name || ' ' || last_name, level
from employees 
start with manager_id is null
connect by prior employee_id = manager_id;