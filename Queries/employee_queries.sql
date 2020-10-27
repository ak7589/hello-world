
select * from employee_rnd

select count(*) from employee_rnd

select count(last_name) from employee_rnd

select count(distinct last_name) from employee_rnd

select last_name,count(last_name) from employee_rnd group by last_name

select last_name,count(last_name) from employee_rnd group by last_name
having count(last_name) > 1

/* Improved query from the last query , because we do not want to repeat count(last_name */

select last_name,count(last_name) as LastNameCount from employee_rnd group by last_name
having LastNameCount > 1

select count(salary) from employee_rnd

select count(salary) from employee_rnd

select max(salary) from employee_rnd

select min(salary) from employee_rnd

select avg(salary) from employee_rnd

select count(first_name) from employee_rnd where last_name='Kumar'