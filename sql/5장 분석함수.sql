--5장 분석함수
select employee_id, department_id, salary,
rank() over (order by salary desc) sal_rank,
dense_rank() over (order by salary desc) sal_dense_rank,
row_number() over (order by salary desc) sal_number
from employees;

select employee_id, department_id, salary,
cume_dist() over(order by salary desc) sal_come_dist,
percent_rank() over(order by salary desc) sal_pct_rank
from employees;

select employee_id, department_id, salary,
cume_dist() over (order by commission_pct desc) commel_cume_dist,
percent_rank() over (order by commission_pct desc) comm_pct_rank
from employees;

--IT_PROG인 사원들을 대상으로 부서내 전체 급여에서 본인이 차지하는 비율을 출력
select first_name, salary,
round(ratio_to_report(salary) over (), 4) as salary_ratio
from employees
where job_id = 'IT_PROG';

select department_id,
round(avg(salary) over (partition by department_id), 2)
from employees;

select department_id, round(avg(salary), 2)
from employees
group by department_id;

select employee_id, department_id, salary,
ntile(10) over (order by salary desc) sal_quart_tile
from employees
where department_id = 50;

select employee_id,
lag(salary, 1, 0) over (order by salary) as lower_sal,
salary,
lead(salary, 1, 0) over (order by salary) as higher_sal
from employees
order by salary;

select department_id,
listagg(first_name, ',') within group(order by hire_date) as names
from employees
group by department_id;

select department_id, first_name, salary,
sum(salary) over(partition by department_id 
order by salary
rows between unbounded preceding and current row) as sum_rows
from employees;

select department_id, first_name, salary,
sum(salary) over(partition by department_id 
order by salary
range between unbounded preceding and current row) as sum_rows
from employees;

select 
avg(salary),
regr_avgx(commission_pct, salary)
from employees;
--위와 같은 식
select avg(salary) from employees where commission_pct is not null;

select 
regr_avgy(commission_pct, salary)
from employees;
--위와 같은 식 
select avg(commission_pct) from employees where salary is not null;

select distinct department_id,
regr_count(manager_id, department_id)
over (partition by department_id) "regr_count"
from employees
order by department_id;

select department_id, count(*)
from employees
group by department_id
order by department_id;

select department_id,manager_id from employees;

select 
job_id, employee_id, salary,
round(sysdate-hire_date) "working_day",
round(regr_slope(salary, sysdate-hire_date)
over(partition by job_id),2) "regr_slope",
round(regr_intercept(salary, sysdate-hire_date)
over(partition by job_id), 2) "regr_intercept"
from employees
where department_id = 80
order by job_id, employee_id;

select 
distinct job_id,
round(regr_slope(salary, sysdate-hire_date)
over(partition by job_id),2) "regr_slope",
round(regr_intercept(salary, sysdate-hire_date)
over(partition by job_id),2) "regr_intercept",
round(regr_r2(salary, sysdate-hire_date)
over(partition by job_id),2) "regr_r2"
from employees
where department_id =80;

insert into sales_log values(1101, 4, 'sales_mon', 100);
insert into sales_log values(1101, 4, 'sales_tue', 150);
insert into sales_log values(1101, 4, 'sales_wed', 80);
insert into sales_log values(1101, 4, 'sales_thu', 60);
insert into sales_log values(1101, 4, 'sales_fri', 120);
insert into sales_log values(1102, 5, 'sales_mon', 300);
insert into sales_log values(1102, 5, 'sales_tue', 300);
insert into sales_log values(1102, 5, 'sales_wed', 230);
insert into sales_log values(1102, 5, 'sales_thu', 120);
insert into sales_log values(1102, 5, 'sales_fri', 150);
commit;
select * from sales_log;

--create table sales(
--employee_id number(6),
--week_id number(2),
--sales_mon number(8,2),
--sales_tue number(8,2),
--sales_wed number(8,2),
--sales_thu number(8,2),
--sales_fri number(8,2));
--commit;
--insert into sales values(1101,4,100,150,80,60,120);
--insert into sales values(1102,5,300,300,230,120,150);
--commit;
select * from sales;

select sum(quantity) from sales_log
where week_day = 'sales_mon';

select sum(sales_mon) from sales;

select * from sales_log
pivot
( sum(quantity)
for week_day IN('sales_mon' as sales_mon,
                'sales_tue' as sales_tue,
                'sales_wed' as sales_wed,
                'sales_thu' as sales_thu,
                'sales_fri' as sales_fri)
                )
order by employee_id, week_id;

select employee_id, week_id, week_day, quantity
from sales
unpivot
( quantity
  for week_day
  in(sales_mon, sales_tue, sales_wed, sales_thu, sales_fri)
  );
  
--연습문제
select department_id, first_name, salary,
rank() over (partition by department_id order by salary desc) sal_rank,
nvl(sum(salary) over(partition by department_id
order by salary
rows between 1 preceding and 1 preceding),0) prev_salary,
nvl(sum(salary) over(partition by department_id
order by salary desc
rows between 1 preceding and 1 preceding),sum(salary) over(partition by department_id
order by salary desc
rows current row)) prev_salary2
from employees;

