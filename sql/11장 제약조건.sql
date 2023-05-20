--11장 제약조건
select * from user_constraints;

create table emp4(
    empno number(4) constraint emp4_empno_pk primary key,
    ename varchar2(10) not null,
    sal number(7,2) constraint emp4_sal_ck check(sal<=10000),
    deptno number(2) constraint emp4_deptno_dept_deptid_fk
                                references departments(department_id));
create table emp5(
    empno number(4),
    ename varchar2(10) not null,
    sal number(7,2),
    deptno number(2),
    constraint emp5_empno_pk primary key(empno),
    constraint emp5_sal_ck check(sal<=10000),
    constraint emp5_deptno_dept_deptid_fk
        foreign key(deptno) references departments(department_id));
create table depts(
    deptno number(2),
    dname varchar2(14),
    loc varchar2(13),
    constraint depts_dname_uk unique(dname),
    constraint depts_deptno_pk primary key(deptno));
alter table emp4
add (nickname varchar2(20));
alter table emp4
add unique(nickname);

insert into emp4 
values (1000, 'KILDONG', 2000,10,NULL);

insert into emp4
values (2000, 'KILSEO', 3000, 20, 'KSEO');

select * from emp4;
--nickname 제약조건에 unique가 있기 때문에 KSEO를 또 넣으면 에러
update emp4 set nickname = 'KSEO' WHERE empno=1000;

create table emps(
    empno number(4),
    ename varchar2(10) not null,
    job varchar2(9),
    mgr number(4),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2) not null,
    constraint emps_empno_pk primary key(empno),
    constraint emps_depts_deptno_fk foreign key(deptno)
        references depts(deptno));
create table emp6 (
    empno number(4) constraint emp6_empno_pk primary key,
    ename varchar2(10) not null,
    sal number(7,2) check(sal<=10000),
    deptno number(2) constraint emp6_deptno_dept_deptid_fk
                    references departments(department_id));

select constraint_name, constraint_type, status
from user_constraints
where table_name = 'EMPS';

alter table emps drop constraint emps_manager_id_fk;
commit;