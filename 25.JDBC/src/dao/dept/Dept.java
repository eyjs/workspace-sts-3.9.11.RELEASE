package dao.dept;

import java.util.ArrayList;

/**
 * 특정 테이블과 동일한 속성을 가지는
 * OR-Mapping 클래스 (Object Relation)
 * DTO(Data Transfer Object)
 * @author 
 */
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", dname=" + dname + ", loc="+loc+"]";
	}
	@Override
	public int hashCode() {	
		return toString().hashCode();
	}
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Dept){
			return toString().equals(obj.toString());
			}
		return false;
		}
	}
