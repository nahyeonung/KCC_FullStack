--10�� ���̺� ������ ����
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
--���� ������ ����� ����(CTAS)
create table emp2 as select * from employees;
select count(*) from emp2;
--������ ���� ���̺� ����
create table emp3 as select * from employees where 1=2;
select count(*) from emp3;
--���̺� ���� ����(alter table)
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
--��������
--1��
create table member(
    id varchar2(15),
    name varchar2(20),
    password varchar2(20),
    phone varchar2(15),
    email varchar2(100));
--2��
insert into member values('user123', '�����', 'a1234567890', '011-234-5678', 'user@user.com');
--3��
select * from member where id='user123';
--4��
update member set name='ȫ�浿' , password='a1234', phone='011-222-3333', email='user@user.co.kr' where id='user123';
select * from member where id='user123';
--5��
delete member where id='user123' and password='a1234';
--6��
truncate table member;
--7��
drop table member;