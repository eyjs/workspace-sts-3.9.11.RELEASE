desc emp;
select * from emp order by sal desc;
update emp set sal=9000 where empno=7369;
commit;

select empno,ename,job,sal,deptno 
from emp 
where sal >= 1000 and sal<=2000 and job='SALESMAN';

