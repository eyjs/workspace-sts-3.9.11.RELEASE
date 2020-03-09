package com.itwill.controller.annotation;

import org.springframework.stereotype.Component;

@Component("elBean")
public class SpringELBean {
	private String member1;
	private String member2;
	private String member3;
	private String member4;
	
	public SpringELBean() {
		member1="이효리";
		member2="김완선";
		member3="강수지";
		member4="신명숙";
	}
	
	public String printMembers() {
		return member1+","+member2+","+member3+","+member4;
	}
	
	public String getMember1() {
		return member1;
	}

	public void setMember1(String member1) {
		this.member1 = member1;
	}

	public String getMember2() {
		return member2;
	}

	public void setMember2(String member2) {
		this.member2 = member2;
	}

	public String getMember3() {
		return member3;
	}

	public void setMember3(String member3) {
		this.member3 = member3;
	}

	public String getMember4() {
		return member4;
	}

	public void setMember4(String member4) {
		this.member4 = member4;
	}
	
}
