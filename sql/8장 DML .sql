CREATE TABLE empl AS SELECT * FROM employees;
DESC empl;
SELECT * FROM empl;
-- 테이블의 제약조건은 복사되지 않는다. 단 Not Null은 복사됨.
-- Not Null은 제외한 다른 제약조건은 복사되지 않는다.
CREATE TABLE emp2 AS SELECT * FROM employees WHERE 1=2;
SELECT * FROM emp2;
DESC emp2;

INSERT INTO departments
VALUES (280, 'Data Analytics', null, 1700);

select * from departments where department_id = 280;
rollback;
select * from departments where department_id = 280;

create table managers as 
select employee_id, first_name, job_id, salary, hire_date
from employees
where 1=2;

--다른 테이블을 이용한 행 복사(values 절을 사용하지 않음)
insert into managers
select employee_id, first_name, job_id, salary, hire_date
from employees
where job_id like '%MAN';
select * from managers;
--UPDATE
create table emps as select * from employees;
--ALTER로 제약조건을 추가
alter table emps
add (constraint emps_emp_id_pk primary key (employee_id),
    constraint emps_manager_id_fk foreign key (manager_id)
    references emps(employee_id)
    );
    
select employee_id, first_name, salary
from emps
where employee_id = 103;

update emps
set salary=salary*1.1
where employee_id=103;
commit;
--서브쿼리를 사용한 다중 열 update
select employee_id, first_name, job_id, salary, manager_id
from emps
where employee_id in (108, 109);

update emps
set (job_id, salary, manager_id) =
    (select job_id, salary, manager_id
        from emps
        where employee_id = 108)
where employee_id=109;
--행 삭제
delete from emps
where employee_id = 104;

delete from emps
where employee_id = 103;

create table depts as 
select * from departments;

desc depts;

delete from emps
where department_id = 
    (select department_id 
    from depts
    where department_name = 'Shipping');
commit;

--RETURNING
variable emp_name varchar2(50);
variable emp_sal number;
variable;

delete emps
where employee_id=109
returning first_name, salary into :emp_name, :emp_sal;

--multiple insert
--unconditional insert all
insert all
    into emp1
        values(300, 'Kildong', 'Hong', 'KHONG', '011.624.7902',
        to_date('2015-05-11', 'YYYY-MM-DD'), 'IT_PROG', 6000, null, 100, 90)
    into emp2
        values(400, 'Kilseo', 'Hong', 'KSHONG', '011.3402.7902',
        to_date('2015-06-20', 'YYYY-MM-DD'), 'IT_PROG', 5500, null, 100, 90)
    select * from dual;
rollback;
select * from dual;
--unconditional insert로 하나의 테이블에 2개의 행을 집어넣고 싶다면?
insert all
    into emp1
        values(300, 'Kildong', 'Hong', 'KHONG', '011.624.7902',
        to_date('2015-05-11', 'YYYY-MM-DD'), 'IT_PROG', 6000, null, 100, 90)
    into emp1
        values(200, 'Tildong', 'Tong', 'TKHONG', '011.624.7902',
        to_date('2015-05-11', 'YYYY-MM-DD'), 'IT_PROG', 2000, null, 200, 20)
    into emp2
        values(400, 'Kilseo', 'Hong', 'KSHONG', '011.3402.7902',
        to_date('2015-06-20', 'YYYY-MM-DD'), 'IT_PROG', 5500, null, 100, 90)
    into emp2
        values(500, 'TKilseo', 'THong', 'TKSHONG', '011.3402.7902',
        to_date('2015-06-20', 'YYYY-MM-DD'), 'IT_PROG', 2500, null, 200, 20)
    select * from dual;
--conditional insert all
create table emp_10 as select * from employees where 1=2;
create table emp_20 as select * from employees where 1=2;
insert all
    when department_id = 10 then
    into emp_10 values
        (employee_id, first_name, last_name, email, phone_number,
        hire_date, job_id, salary, commission_pct, manager_id, department_id)
    when department_id = 20 then
    into emp_20 values
        (employee_id, first_name, last_name, email, phone_number,
        hire_date, job_id, salary, commission_pct, manager_id, department_id)
    select * from employees;
--conditional insert first
create table emp_sal5000 as select employee_id, first_name, salary from employees where 1=2;
create table emp_sal10000 as select employee_id, first_name, salary from employees where 1=2;
create table emp_sal15000 as select employee_id, first_name, salary from employees where 1=2;
create table emp_sal20000 as select employee_id, first_name, salary from employees where 1=2;
create table emp_sal25000 as select employee_id, first_name, salary from employees where 1=2;

insert first
    when salary <= 5000 then
        into emp_sal5000 values(employee_id, first_name, salary)
    when salary <= 10000 then
        into emp_sal10000 values(employee_id, first_name, salary)
    when salary <= 15000 then
        into emp_sal15000 values(employee_id, first_name, salary)
    when salary <= 20000 then
        into emp_sal20000 values(employee_id, first_name, salary)
    when salary <= 25000 then
        into emp_sal25000 values(employee_id, first_name, salary)
    select employee_id, first_name, salary from employees;

select count(*) from emp_sal5000;
select count(*) from emp_sal10000;
select count(*) from emp_sal15000;
select count(*) from emp_sal20000;
select count(*) from emp_sal25000;

--DROP은 실행 후 취소가 안됨. 그래서 조심해서 써야됨. 만약 ROLLBACK을 사용하면 DROP 이전 작업이 취소됨
--연습문제
--1번
create table emp_salary_info as select employee_id, first_name, salary, commission_pct from employees where 1=2;
select * from emp_salary_info;
create table emp_hiredate_info as select employee_id, first_name, hire_date, department_id from employees where 1=2;
select * from emp_hiredate_info;
--2번
insert into employees values(1030, 'KilDong', 'Hong', 'HONGKD' ,'010-1234-5678', '2018/03/20', 'IT_PROG', 6000, 0.2, 103, 60);
--3번
update employees set salary = salary + salary*0.1 where employee_id=1030;
--4번
delete employees where employee_id=1030;
--5번
select employee_id, first_name, hire_date, to_char(hire_date,'YYYY')as year from employees
where hire_date <= '2003/12/31';
--새로운 테이블을 생성하는 방법
create table emp_yr_2001 (
    employee_id NUMBER(6,0),
    first_name VARCHAR2(20),
    hire_date DATE,
    yr VARCHAR2(20));
create table emp_yr_2002 (
    employee_id NUMBER(6,0),
    first_name VARCHAR2(20),
    hire_date DATE,
    yr VARCHAR2(20));
create table emp_yr_2003 (
    employee_id NUMBER(6,0),
    first_name VARCHAR2(20),
    hire_date DATE,
    yr VARCHAR2(20));
insert all
    when to_char(hire_date, 'YYYY') = '2001' then
        into emp_yr_2001 values (employee_id, first_name, hire_date, yr)
    when to_char(hire_date, 'YYYY') = '2002' then
        into emp_yr_2002 values (employee_id, first_name, hire_date, yr)
    when to_char(hire_date, 'YYYY') = '2003' then
        into emp_yr_2003 values (employee_id, first_name, hire_date, yr)
    select employee_id, first_name, hire_date, to_char(hire_date,'YYYY') as yr
    from employees;

select * from emp_yr_2001;
select * from emp_yr_2002;
select * from emp_yr_2003;
rollback;
--6번
insert first
    when to_char(hire_date, 'YYYY') <= 2001 then
        into emp_yr_2001 values (employee_id, first_name, hire_date, yr)
    when to_char(hire_date, 'YYYY') <= 2002 then
        into emp_yr_2002 values (employee_id, first_name, hire_date, yr)
    when to_char(hire_date, 'YYYY') <= 2003 then
        into emp_yr_2003 values (employee_id, first_name, hire_date, yr)
    select employee_id, first_name, hire_date,to_char(hire_date, 'YYYY') as yr from employees;
--7번
create table emp_personal_info as 
select employee_id, first_name, last_name, email, phone_number
from employees
where 1=2;
create table emp_office_info as
select employee_id, hire_date, salary, commission_pct,
manager_id, department_id
from employees
where 1=2;
insert all
    into emp_personal_info values
        (employee_id, first_name, last_name, email, phone_number)
    into emp_office_info values
        (employee_id, hire_date, salary, commission_pct, manager_id, department_id)
    select * from employees;
--8번
create table emp_comm as select * from employees where 1=2;
create table emp_nocomm as select * from employees where 1=2;
insert all
    when commission_pct is not null then
    into emp_comm
    when commission_pct is null then
    into emp_nocomm
    select * from employees;
select * from emp_comm;
select * from emp_nocomm;
