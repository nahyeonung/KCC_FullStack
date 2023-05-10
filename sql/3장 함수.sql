--Null ġȯ �Լ� NVL, NVL2, COALSESCE
SELECT first_name, salary + salary*NVL(commission_pct,0) AS ann_sal
FROM employees;

SELECT first_name, NVL2(commission_pct, salary+(salary*commission_pct), salary) ann_sal
FROM employees;

SELECT first_name, COALESCE(salary + (salary*commission_pct), salary) AS ann_sal
FROM employees;

--LNNVL �Լ�: expr1�� ����� FALSE �Ǵ� UNKNOWN�̸� TRUE��ȯ, TRUE�� FALSE��ȯ
--���ʽ��� 650�޷����� ���� ������� ã�ƶ�.
SELECT first_name, COALESCE(salary*commission_pct,0) AS bonus
FROM employees
WHERE LNNVL(salary*commission_pct >= 650);
--UNION�� ����� ����
SELECT first_name, COALESCE(salary*commission_pct, 0)
FROM employees
WHERE salary*commission_pct < 650
UNION ALL
SELECT first_name, COALESCE(salary*commission_pct, 0)
FROM employees
WHERE salary*commission_pct IS NULL;

--DECODE �Լ�
SELECT job_id, salary,
DECODE(job_id, 'IT_PROG', salary*1.10,
                'FI_MGR', salary*1.15,
                'FI_ACCOUNT', salary*1.20,
                salary) AS revised_salary
FROM employees;

--CASE ��
SELECT job_id, salary,
CASE job_id WHEN 'IT_PROG' THEN salary*1.10
            WHEN 'FI_MGR' THEN salary*1.15
            WHEN 'FI_ACCOUNT' THEN salary*1.20
            ELSE salary
            END AS revised_salary
FROM employees;
--CASE ������ ���� ������ �� ��(WHEN �� �ȿ��� ������ �ο�)
SELECT employee_id, salary,
CASE WHEN salary < 5000 THEN salary*1.2
     WHEN salary < 10000 THEN salary*1.10
     WHEN salary < 15000 THEN salary*1.05
     ELSE salary
     END AS revised_salary
FROM employees;

--UNION
SELECT employee_id, first_name
FROM employees
WHERE hire_date LIKE '04%'
UNION
SELECT employee_id, first_name
FROM employees
WHERE department_id = 20;
--UNION ALL: �ߺ��� ������ �״�� ���
SELECT employee_id, first_name
FROM employees
WHERE hire_date LIKE '04%'
UNION ALL
SELECT employee_id, first_name
FROM employees
WHERE department_id = 20;

--INTERSECT: ������
SELECT employee_id, first_name
FROM employees
WHERE hire_date LIKE '04%'
INTERSECT
SELECT employee_id, first_name
FROM employees
WHERE department_id = 20;

--MINUS: ������(ù ��° �������� �ְ� �� ��° �������� ���� ��)
SELECT employee_id, first_name
FROM employees
WHERE hire_date LIKE '04%'
MINUS
SELECT employee_id, first_name
FROM employees
WHERE department_id = 20;

--3�� ��������
--1
select * from employees where email like '%LEE%';
--2
select first_name, salary, job_id from employees where manager_id = 103;
--3
select * from employees where (department_id = 80 and job_id = 'SA_MAN')
or (department_id = 20 and manager_id = 100);
--4
select regexp_replace(phone_number, '[.]', '-') from employees;
--4�� ����
select regexp_replace(regexp_replace(phone_number,'[0-9]', '#'),'[.]','-') from employees;
--5��
select rpad(first_name|| ' '||last_name,20, '*') as full_name, to_char(salary, '$009,999.00') as salary, 
to_char(hire_date, 'YYYY-MM-DD') as hire_date, trunc(sysdate - hire_date) as workday
from employees
where salary >= 5000
order by full_name;
--6��
select rpad(first_name|| ' '|| last_name,20,'*') as full_name, 
to_char(salary, '$009,999.99') as salary, 
to_char(hire_date,'YYYY"��" MM"��" DD"��"') AS hire_date,
trunc(months_between(sysdate, hire_date)) as month
from employees
where department_id=30
order by salary desc;
--7��
select rpad(first_name|| ' '|| last_name,17,'*') as full_name, 
to_char(salary+salary*commission_pct,'$99,999.99') as salary
from employees
where department_id = 80 and salary > 10000;
--8��
select first_name,
CASE WHEN months_between(sysdate, hire_date)/12 >= 15 THEN 15||'����'
     WHEN months_between(sysdate, hire_date)/12 >= 10 THEN 10||'����'
     WHEN months_between(sysdate, hire_date)/12 >= 5 THEN 5||'����'
     ELSE trunc(months_between(sysdate, hire_date)/12)||'����'
     END AS "�ٹ����"
from employees
where department_id=60;
--9��
select hire_date+1000 from employees where first_name='Lex';
--10��
select first_name, hire_date from employees 
where hire_date like '%/05/%';
--11��
select first_name, salary,
to_char(hire_date, 'YYYY"�� �Ի�"') as year,
to_char(hire_date, 'DAY') as day,
CASE WHEN hire_date >= '2010/01/01' THEN to_char(salary+salary*0.1, '$99,999')
     WHEN hire_date >= '2005/01/01' THEN to_char(salary+salary*0.05, '$99,999')
     ELSE to_char(salary, '$99,999')
     END AS increasing_salary
from employees;
--12��
select first_name, salary,
to_char(hire_date,'YYYY"�� �Ի�"') as year,
CASE WHEN hire_date >= '2010/01/01' THEN salary+salary*0.1
     WHEN hire_date >= '2005/01/01' THEN salary+salary*0.05
     ELSE salary
     END AS increasing_salary2
from employees;
--13��
select country_id, NVL(state_province, country_id) as state from locations;
