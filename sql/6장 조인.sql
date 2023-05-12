--6장 조인
select e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

select e.first_name, e.salary, m.first_name, m.salary
from employees e, employees m
where e.manager_id = m.employee_id and e.salary> m.salary;

select e.first_name as employee_name, m.first_name as manager_name
from employees e, employees m
where e.manager_id = m.employee_id and e.employee_id = 103;

select e.first_name, e.salary, j.job_title
from employees e, jobs j
where e.salary
between j.min_salary and j.max_salary
order by e.first_name;

select e.employee_id, e.first_name, e.hire_date,
j.start_date, j.end_date, j.job_id, j.department_id
from employees e, job_history j
where e.employee_id = j.employee_id
order by j.employee_id;

select e.employee_id, e.first_name, e.hire_date, j.start_date, j.end_date,
j.job_id, j.department_id
from employees e, job_history j
where e.employee_id = j.employee_id(+)
order by j.employee_id;

select employee_id, department_name
from employees
cross join departments;

select first_name, job_title
from employees
natural join jobs;

select first_name, department_name
from employees
natural join departments;

select first_name, department_name
from employees
join departments
using(department_id);

select first_name, department_name
from employees e
join departments d
on e.department_id=d.department_id;

select e.first_name, d.department_name,
l.street_address || ', ' || l.city || ', ' || 
l.state_province as address
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id;

select e.first_name as name, d.department_name as department
from employees e
join departments d
on e.department_id = d.department_id
where employee_id = 103;

select e.first_name as name, d.department_name as department,
l.street_address || ', ' || l.city || ', ' || l.state_province
as address
from employees e
join departments d
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id
where employee_id = 103;

select e.first_name as name,
d.department_name as department
from employees e
join departments d
on e.department_id = d.department_id and employee_id = 103;

select e.employee_id, e.first_name, e.hire_date,
j.start_date, j.end_date, j.job_id, j.department_id
from employees e
left outer join job_history j
on e.employee_id = j.employee_id
order by e.employee_id;

select e.employee_id, e.first_name, e.hire_date,
j.start_date, j.end_date, j.job_id, j.department_id
from employees e
left join job_history j
on e.employee_id = j.employee_id
order by e.employee_id;

select e.employee_id, e.first_name, e.hire_date,
j.start_date, j.end_date, j.job_id, j.department_id
from employees e
full outer join job_history j
on e.employee_id = j.employee_id
order by e.employee_id;

--연습문제
select * from locations;
select * from employees;
select * from departments;
select * from jobs;

--1번
select e.first_name, d.department_name, c.city
from employees e
join departments d on e.department_id = d.department_id
join locations c on d.location_id = c.location_id
where e.first_name = 'John';
--2번
select e.employee_id, e.first_name, e.salary,
d.first_name as first_name_1, ds.department_name
from employees e
join employees d on e.manager_id = d.employee_id
join departments ds on d.department_id = ds.department_id 
where e.employee_id = 103;
--3번
select e.employee_id, e.first_name, e.salary, em.first_name as first_name_1,
em.salary as salary_1, d.department_name
from employees e
left join employees em on e.manager_id = em.employee_id
left join departments d on em.department_id = d.department_id
where e.department_id = 90;
--4번
select e.employee_id, l.city
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
where e.employee_id = 103;
--5번
select l.city as "Department Location", j.job_title
from employees e
join employees em on e.manager_id = em.employee_id
join jobs j on em.job_id = j.job_id
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
where e.employee_id=103;
--6번
select e.employee_id, e.first_name, e.last_name, e.email, e.phone_number,
e.hire_date, j.job_title, e.salary, e.commission_pct, em.first_name, em.last_name, d.department_name
from employees e
join employees em on e.manager_id = em.employee_id
join departments d on e.department_id = d.department_id
join jobs j on e.job_id = j.job_id;
--7번
select employee_id, e.first_name, e.department_id, d.department_id
from employees e, departments d
where e.department_id = d.department_id;

--103번 사원이 근무하는 부서의 이름은?
select d.department_name
from employees e
join departments d on e.department_id = d.department_id
where e.employee_id = 103;
--60번 부서의 매니저 이름은?
select distinct em.first_name
from employees e
join employees em on e.manager_id = em.employee_id
where e.department_id = 60;
--IT 부서의 도시 이름(city)과 우편번호를 출력하세요
select l.city, l.postal_code
from departments d
join locations l on d.location_id = l.location_id
where d.department_name = 'IT';
--Alexander Hunold 사원의 매니저 이름은?
select em.first_name || ' ' || em.last_name as name
from employees e
join employees em on e.manager_id = em.employee_id
--where e.first_name = 'Alexander' and e.last_name = 'Hunold';
where e.first_name || ' ' || e.last_name = 'Alexander Hunold';
--107번 사원이 근무하는 부서의 도시(city)이름은?
select l.city
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
where e.employee_id = 107;
