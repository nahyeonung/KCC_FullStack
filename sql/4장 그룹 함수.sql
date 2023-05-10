--4�� �׷� �Լ�
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA%';

SELECT MIN(hire_date), MAX(hire_date)
FROM employees;
--���ĺ������� ���� ���� ����� �̸��� ���� ���� ����� �̸� ���
SELECT MIN(first_name), MAX(last_name)
FROM employees;

SELECT MAX(salary)
FROM employees;

--COUNT �Լ�: �ߺ��Ǵ� ���� null���� ������ ���̺� ���� �� ��ȯ
SELECT COUNT(*) FROM employees;

--STDDEV �Լ�: null���� ������ ǥ��ǥ������
--VARIANCE �Լ�: null���� ������ ǥ���л�
SELECT SUM(salary) AS �հ�,
ROUND(AVG(salary),2) AS ���,
ROUND(STDDEV(salary),2) AS ǥ������,
ROUND(VARIANCE(salary), 2) AS �л�
FROM employees;

SELECT ROUND(AVG(salary*commission_pct), 2) AS avg_bonus
FROM employees;

SELECT ROUND(SUM(salary*commission_pct), 2) AS sum_bonus,
COUNT(*) count,
ROUND(AVG(salary*commission_pct),2) AS avg_bonus1,
ROUND(SUM(salary*commission_pct)/count(*),2) AS avg_bonus2
FROM employees;

SELECT AVG(NVL(salary*commission_pct,0))
FROM employees;

SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id;

SELECT department_id, job_id, SUM(salary)
FROM employees
GROUP BY department_id, job_id
ORDER BY job_id;

SELECT department_id, COUNT(first_name)
FROM employees
GROUP BY department_id;

SELECT department_id, ROUND(AVG(salary),2)
FROM employees
GROUP BY department_id
HAVING AVG(salary)>8000;

SELECT job_id, AVG(salary) PAYROLL
FROM employees
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING AVG(salary) > 8000
ORDER BY AVG(salary);

--GROUPING SETS
select to_char(department_id), round(avg(salary),2)
from employees
group by department_id
union all
select job_id, round(avg(salary),2)
from employees
group by job_id
order by 1;
--GROUPING SETS�� Ȱ���ؼ� ���� ���� ����� �����غ���
select department_id, job_id, round(avg(salary), 2)
from employees
group by grouping sets(department_id, job_id)
order by department_id, job_id;

select department_id, job_id, round(avg(salary), 2)
from employees
group by department_id, job_id
order by department_id, job_id;

select department_id, job_id, manager_id,
round(avg(salary),2) as avg_sal
from employees
group by 
grouping sets((department_id, job_id),(job_id, manager_id))
order by department_id, job_id, manager_id;

--ROLLUP, CUBE ���
select department_id, job_id, round(avg(salary),2), count(*)
from employees
group by department_id, job_id
order by department_id, job_id;

select department_id, job_id, round(avg(salary),2) as ���, count(*) as ����Ǽ�
from employees
group by rollup(department_id,job_id)
order by department_id, job_id;

select department_id, job_id, round(avg(salary),2) as ���, count(*) as ����Ǽ�
from employees
group by cube(department_id,job_id)
order by department_id, job_id;

select 
decode(grouping(department_id),1,'�Ұ�',
to_char(department_id)) as �μ�, --'�Ұ�'�� ���� Ÿ���� ����ؼ� to_char�� ��
decode(grouping(job_id),1,'�Ұ�',job_id) as ����,
round(avg(salary),2) as ���,
count(*) as ����Ǽ�
from employees
group by cube(department_id, job_id)
order by �μ�, ����;

select 
decode(grouping(job_id),1,'�Ұ�',job_id) as ����,
round(avg(salary),2) as ���,
count(*) as ����Ǽ�
from employees
group by rollup(department_id, job_id);

select 
decode(grouping_id(department_id, job_id), 2, '�Ұ�', 3, '�հ�',
to_char(department_id)) as �μ���ȣ,
decode(grouping_id(department_id, job_id), 1, '�Ұ�', 3, '�հ�',
job_id) as ����,
grouping_id(department_id, job_id) as gid, 
round(avg(salary),2) as ���,
count(*) as ����Ǽ�
from
employees
group by cube(department_id, job_id)
order by �μ���ȣ, ����;

--��������
--1��
select job_id, avg(salary) from employees group by job_id;
--2��
select department_id, count(*) from employees group by department_id;
--3��
select department_id, job_id, count(*) from employees 
group by department_id, job_id;
--4��
select department_id, round(stddev(salary),2) from employees 
group by department_id;
--5��
select department_id, count(*) from employees 
group by department_id
having count(*) >= 4;
--6��
select job_id, count(*) from employees
where department_id = 50
group by job_id;
--7��
select job_id, count(*) from employees
where department_id = 50
group by job_id
having count(*) <= 10;
--8��
select to_char(hire_date, 'YYYY') as �Ի�⵵,
round(avg(salary)), count(*) as ����� from employees
group by to_char(hire_date, 'YYYY')
order by �Ի�⵵;
--9��
select to_char(hire_date, 'YYYY') as �Ի�⵵,
to_char(hire_date, 'MM') as �Ի��,
round(avg(salary)) as �޿����,
count(*) as �����
from employees 
group by rollup(to_char(hire_date, 'YYYY') ,to_char(hire_date, 'MM'))
order by �Ի�⵵, �Ի��;
--10��
select 
decode(grouping(to_char(hire_date, 'YYYY')), 1, '�հ�', to_char(hire_date, 'YYYY'))  as �Ի�⵵,
decode(grouping(to_char(hire_date, 'MM')), 1, '�Ұ�', to_char(hire_date, 'MM')) as �Ի��,
round(avg(salary)) as �޿����,
count(*) as �����
from employees 
group by cube(to_char(hire_date, 'YYYY') ,to_char(hire_date, 'MM'))
order by �Ի�⵵, �Ի��;
--11��
select 
decode(grouping_id(to_char(hire_date, 'YYYY'),to_char(hire_date, 'MM')), 2, '�Ұ�', 3, '�հ�', to_char(hire_date, 'YYYY')) as �Ի�⵵,
decode(grouping_id(to_char(hire_date, 'YYYY'),to_char(hire_date, 'MM')), 1, '�Ұ�', 3, '�հ�', to_char(hire_date, 'MM')) as �Ի��,
grouping_id(to_char(hire_date, 'YYYY'), to_char(hire_date, 'MM')) as gid, 
round(avg(salary)) as �޿����,
count(*) as �����
from employees
group by cube(to_char(hire_date,'YYYY'), to_char(hire_date, 'MM'))
order by �Ի�⵵, �Ի��