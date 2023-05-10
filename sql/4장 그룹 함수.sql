--4장 그룹 함수
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA%';

SELECT MIN(hire_date), MAX(hire_date)
FROM employees;
--알파벳순으로 제일 빠른 사원의 이름과 제일 늦은 사원의 이름 출력
SELECT MIN(first_name), MAX(last_name)
FROM employees;

SELECT MAX(salary)
FROM employees;

--COUNT 함수: 중복되는 값과 null값을 포함한 테이블 행의 수 반환
SELECT COUNT(*) FROM employees;

--STDDEV 함수: null값을 제외한 표본표준편차
--VARIANCE 함수: null값을 제외한 표본분산
SELECT SUM(salary) AS 합계,
ROUND(AVG(salary),2) AS 평균,
ROUND(STDDEV(salary),2) AS 표준편차,
ROUND(VARIANCE(salary), 2) AS 분산
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
--GROUPING SETS를 활용해서 위와 같은 결과를 도출해보면
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

--ROLLUP, CUBE 사용
select department_id, job_id, round(avg(salary),2), count(*)
from employees
group by department_id, job_id
order by department_id, job_id;

select department_id, job_id, round(avg(salary),2) as 평균, count(*) as 사원의수
from employees
group by rollup(department_id,job_id)
order by department_id, job_id;

select department_id, job_id, round(avg(salary),2) as 평균, count(*) as 사원의수
from employees
group by cube(department_id,job_id)
order by department_id, job_id;

select 
decode(grouping(department_id),1,'소계',
to_char(department_id)) as 부서, --'소계'와 같은 타입을 써야해서 to_char를 씀
decode(grouping(job_id),1,'소계',job_id) as 직무,
round(avg(salary),2) as 평균,
count(*) as 사원의수
from employees
group by cube(department_id, job_id)
order by 부서, 직무;

select 
decode(grouping(job_id),1,'소계',job_id) as 직무,
round(avg(salary),2) as 평균,
count(*) as 사원의수
from employees
group by rollup(department_id, job_id);

select 
decode(grouping_id(department_id, job_id), 2, '소계', 3, '합계',
to_char(department_id)) as 부서번호,
decode(grouping_id(department_id, job_id), 1, '소계', 3, '합계',
job_id) as 직무,
grouping_id(department_id, job_id) as gid, 
round(avg(salary),2) as 평균,
count(*) as 사원의수
from
employees
group by cube(department_id, job_id)
order by 부서번호, 직무;

--연습문제
--1번
select job_id, avg(salary) from employees group by job_id;
--2번
select department_id, count(*) from employees group by department_id;
--3번
select department_id, job_id, count(*) from employees 
group by department_id, job_id;
--4번
select department_id, round(stddev(salary),2) from employees 
group by department_id;
--5번
select department_id, count(*) from employees 
group by department_id
having count(*) >= 4;
--6번
select job_id, count(*) from employees
where department_id = 50
group by job_id;
--7번
select job_id, count(*) from employees
where department_id = 50
group by job_id
having count(*) <= 10;
--8번
select to_char(hire_date, 'YYYY') as 입사년도,
round(avg(salary)), count(*) as 사원수 from employees
group by to_char(hire_date, 'YYYY')
order by 입사년도;
--9번
select to_char(hire_date, 'YYYY') as 입사년도,
to_char(hire_date, 'MM') as 입사월,
round(avg(salary)) as 급여평균,
count(*) as 사원수
from employees 
group by rollup(to_char(hire_date, 'YYYY') ,to_char(hire_date, 'MM'))
order by 입사년도, 입사월;
--10번
select 
decode(grouping(to_char(hire_date, 'YYYY')), 1, '합계', to_char(hire_date, 'YYYY'))  as 입사년도,
decode(grouping(to_char(hire_date, 'MM')), 1, '소계', to_char(hire_date, 'MM')) as 입사월,
round(avg(salary)) as 급여평균,
count(*) as 사원수
from employees 
group by cube(to_char(hire_date, 'YYYY') ,to_char(hire_date, 'MM'))
order by 입사년도, 입사월;
--11번
select 
decode(grouping_id(to_char(hire_date, 'YYYY'),to_char(hire_date, 'MM')), 2, '소계', 3, '합계', to_char(hire_date, 'YYYY')) as 입사년도,
decode(grouping_id(to_char(hire_date, 'YYYY'),to_char(hire_date, 'MM')), 1, '소계', 3, '합계', to_char(hire_date, 'MM')) as 입사월,
grouping_id(to_char(hire_date, 'YYYY'), to_char(hire_date, 'MM')) as gid, 
round(avg(salary)) as 급여평균,
count(*) as 사원수
from employees
group by cube(to_char(hire_date,'YYYY'), to_char(hire_date, 'MM'))
order by 입사년도, 입사월