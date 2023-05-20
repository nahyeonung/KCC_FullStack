--10장 테이블 생성과 관리
create table dept(
    deptno number(2),
    dname varchar(14),
    loc varchar(13) );
desc dept;

create table emp(
    empno number(4,0),
    ename varchar2(10),
    job varchar2(9),
    mgr number(4,0),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2,0)
);
--서브 쿼리를 사용한 생성(CTAS)
create table emp2 as select * from employees;
select count(*) from emp2;
--구조만 갖는 테이블 생성
create table emp3 as select * from employees where 1=2;
select count(*) from emp3;
--테이블 구조 변경(alter table)
create table emp_dept50
as
    select employee_id, first_name, salary*12 as ann_sal, hire_date
    from employees
    where department_id = 50;
alter table emp_dept50
    add (job varchar(10));
desc emp_dept50;

alter table emp_dept50
    modify(first_name varchar2(30));
alter table emp_dept50
    modify(first_name varchar2(20));
alter table emp_dept50
    add(job_id varchar2(10));
desc emp_dept50;
alter table emp_dept50
drop column job_id;
desc emp_dept50;

alter table emp_dept50
rename column job to job_id;
desc emp_dept50;

alter table emp_dept50 set unused(first_name);
desc emp_dept50;
alter table emp_dept50 drop unused columns;

rename emp_dept50 to employees_dept50;
select * from employees_dept50;

drop table employees_dept50;

truncate table emp2;
select * from emp2;
--연습문제
--1번
create table member(
    id varchar2(15),
    name varchar2(20),
    password varchar2(20),
    phone varchar2(15),
    email varchar2(100));
--2번
insert into member values('user123', '사용자', 'a1234567890', '011-234-5678', 'user@user.com');
--3번
select * from member where id='user123';
--4번
update member set name='홍길동' , password='a1234', phone='011-222-3333', email='user@user.co.kr' where id='user123';
select * from member where id='user123';
--5번
delete member where id='user123' and password='a1234';
--6번
truncate table member;
--7번
drop table member;