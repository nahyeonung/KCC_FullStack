create sequence depts_seq
start with 91
increment by 1
maxvalue 100
nocycle
nocache;

drop table depts cascade constraints;

create table depts(
deptno number(2),
dname varchar2(14),
loc varchar2(13),
constraint depts_dname_uk unique(dname),
constraint depts_deptno_pk primary key(deptno));

select sequence_name, min_value, max_value,
increment_by, last_number
from user_sequences;

select object_name
from user_objects
where object_type='SEQUENCE';

insert into depts(deptno, dname, loc)
values(depts_seq.NEXTVAL, 'MARKETING', 'SAN DIEGO');

select * from depts;

select depts_seq.currval from dual;

alter sequence depts_seq
maxvalue 99999;

drop sequence depts_seq;

select depts_seq.currval from dual;

drop table emps;
create table emps as select * from employees;
select * from emps where first_name = 'David';

create index emps_first_name_idx
on emps(first_name);

drop index emps_first_name_idx;

select ic.index_name, ic.column_name,
        ix.uniqueness
from user_indexes ix, user_ind_columns ic
where ic.index_name = ix.index_name
and ic.table_name = 'EMPLOYEES';
--오라클 11g Express Edition은 비트맵 인덱스를 지원하지 않음
create bitmap index emps_comm_idx on emps(commission_pct);

select * from emps where commission_pct>0.3;

select * from emps where email='DAUSTIN';
create unique index emps_email_idx on emps(email);
select * from emps where email='DAUSTIN';

select * from emps
where coalesce(salary+salary*commission_pct, salary)>10000;

create index emps_annsal_idx
on emps(coalesce(salary+salary*commission_pct, salary));

select * from emps
where coalesce(salary+salary*commission_pct, salary) > 10000;

select * from emps
where first_name='Peter' and last_name='Hall';

create unique index emps_name_indx
on emps(first_name, last_name);

select * from emps
where first_name='Peter' and last_name='Hall';