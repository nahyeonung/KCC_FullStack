--12장 뷰
select * from user_views;
select * from user_role_privs;
select * from user_sys_privs;

create view emp_view_dept60
as select employee_id, first_name, last_name, job_id, salary
from employees
where department_id=60;

desc emp_view_dept60;

drop view emp_view_dept60;

create view emp_dept60_salary
as select
    employee_id as empno,
    first_name || ' ' || last_name as name,
    salary as monthly_salary
    from employees
    where department_id=60;
--서브쿼리 말고 view 자체에서 열 이름 지정
create view emp_dept60_salary (empno, name, monthly_salary)
as select
    employee_id,
    first_name || ' ' || last_name,
    salary
    from employees
    where department_id=60;
select * from emp_dept60_salary;
--뷰 수정
create or replace view emp_dept60_salary
as select
    employee_id as empno,
    first_name || ' ' || last_name as name,
    job_id as job,
    salary
    from employees
    where department_id=60;
desc emp_dept60_salary;

select * from emp_dept60_salary;
insert into emp_dept60_salary values(888, 'test', 'test', 200);
--복합 뷰 생성
create view emp_view
as select 
    e.employee_id as id,
    e.first_name as name,
    d.department_name as department,
    j.job_title as job
    from employees e
    left join departments d on e.department_id = d.department_id
    join jobs j on e.job_id = j.job_id;
select * from emp_view;

select * from emp_details_view;

drop view emp_dept60_salary;

create or replace view emp_dept60
as select * from emps where department_id=60;

select * from emp_dept60;
select * from emps where employee_id=104;

create or replace view emp_dept60
as select distinct * from emps where department_id=60;

select * from emp_dept60;
select * from emps where employee_id = 106;

delete from emp_dept60 where employee_id = 106;

create or replace view emp_dept60
as select 
    employee_id,
    first_name || ', ' || last_name as name,
    salary*12 as annual_salary
    from emps where department_id=60;
select * from emp_dept60;
select * from emps where employee_id = 106;
update emp_dept60 set annual_salary = annual_salary*1.1
where employee_id=106;

create or replace view emp_Dept60
as select employee_id, first_name, hire_date, salary, department_id
from emps
where department_id=60
with check option;

update emp_dept60
set department_id=10
where employee_id=105;

create or replace view emp_dept60
as select employee_id, first_name, hire_date, salary, department_id
from emps
where department_id=60
with read only;

select row_number, first_name, salary
from (select first_name, salary,
    row_number() over (order by salary desc) as row_number
    from employees)
where row_number between 1 and 10;
--연습문제
--1번
create or replace view sal_gap_view_by_job as select e.first_name as name, a.job_id,
round(a.avg_sal - e.salary) as job_sal_gap
from employees e
join (select job_id, (max_salary + min_salary)/2 as avg_sal from jobs) a
on a.job_id = e.job_id;
select * from sal_gap_view_by_job;
--2번
select * from departments;
select * from jobs;
select * from employees;

create or replace view practice as select e.employee_id as id, e.first_name as name, 
d.department_name as department, j.job_title as job from employees e
left join departments d on e.department_id = d.department_id
join jobs j on e.job_id = j.job_id;

select * from practice;




