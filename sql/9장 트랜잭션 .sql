--9장 트랜잭션
--오토커밋 on
set autocommit on
show autocommit
--오토커밋 off
set autocommit off
show autocommit
--savepoint와 rollback
create table emps as select * from employees;
delete from emps where department_id=10;
savepoint delete10;
delete from emps where department_id=20;
savepoint delete20;
delete from emps where department_id=30;
rollback to savepoint delete20;

--DML문에 의한 행 잠금 실습(두 세션으로 접속)
--첫 번째 세션 코드
select empno, ename, sal from emp
where deptno=30;

update emp set sal = sal*1*1.1
where deptno=30;

select empno, ename, sal from emp
where deptno=30;

rollback;
commit;
--두 번째 세션 코드
select empno, ename, sal from emp where deptno=30;
--아래의 update문은 첫 번째 세션 코드가 commit 될 때까지 실행되지 않는다.
update emp set sal=sal+500 where empno=115;

--연습문제
--1번
create table emp_temp as select * from employees;
select * from emp_temp;
--2번
delete emp_temp where department_id=20;
savepoint svpnt_del_20;
select count(*) from emp_temp;
--3번
delete emp_temp where department_id=50;
savepoint svpnt_del_50;
select count(*) from emp_temp;
--4번
delete emp_temp where department_id=60;
select count(*) from emp_temp;
--5번
rollback to savepoint svpnt_del_50;
select count(*) from emp_temp;
commit;



