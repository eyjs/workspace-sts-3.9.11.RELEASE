package com.itwill.domain;

public class Hello {
	private int no;
	private String name;
	public Hello() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Hello(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hello [no=" + no + ", name=" + name + "]";
	}
}
