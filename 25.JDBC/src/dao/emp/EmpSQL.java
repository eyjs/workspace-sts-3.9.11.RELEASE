package dao.emp;

public class EmpSQL {
	public static final String SELECT_ALLEMP_WITHDEPT=
"select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc from emp e left outer join dept d on e.deptno = d.deptno";
	public static final String SELECT_EMPNO_WITHDEPT=
"select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc from emp e left outer join dept d on e.deptno = d.deptno where empno=?";
}
