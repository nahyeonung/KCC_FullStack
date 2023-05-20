--9�� Ʈ�����
--����Ŀ�� on
set autocommit on
show autocommit
--����Ŀ�� off
set autocommit off
show autocommit
--savepoint�� rollback
create table emps as select * from employees;
delete from emps where department_id=10;
savepoint delete10;
delete from emps where department_id=20;
savepoint delete20;
delete from emps where department_id=30;
rollback to savepoint delete20;

--DML���� ���� �� ��� �ǽ�(�� �������� ����)
--ù ��° ���� �ڵ�
select empno, ename, sal from emp
where deptno=30;

update emp set sal = sal*1*1.1
where deptno=30;

select empno, ename, sal from emp
where deptno=30;

rollback;
commit;
--�� ��° ���� �ڵ�
select empno, ename, sal from emp where deptno=30;
--�Ʒ��� update���� ù ��° ���� �ڵ尡 commit �� ������ ������� �ʴ´�.
update emp set sal=sal+500 where empno=115;

--��������
--1��
create table emp_temp as select * from employees;
select * from emp_temp;
--2��
delete emp_temp where department_id=20;
savepoint svpnt_del_20;
select count(*) from emp_temp;
--3��
delete emp_temp where department_id=50;
savepoint svpnt_del_50;
select count(*) from emp_temp;
--4��
delete emp_temp where department_id=60;
select count(*) from emp_temp;
--5��
rollback to savepoint svpnt_del_50;
select count(*) from emp_temp;
commit;



