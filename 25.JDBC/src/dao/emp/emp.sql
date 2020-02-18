select * from EMP;

select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc 
from emp e left outer join dept d on e.deptno = d.deptno;