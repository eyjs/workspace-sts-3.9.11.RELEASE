package com.itwill.simpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloAttributeTag  extends TagSupport{
	private String name;
	
	public void setName(String name) {
		System.out.println("2.HelloAttributeTag.setName("+name+")");
		this.name = name;
	}
	
	public HelloAttributeTag() {
		System.out.println("1.HelloAttributeTag()생성자");
	}
	@Override
	public int doStartTag() throws JspException {
		System.out.println("3.doStartTag()");
		String msg="";
		if(name==null) {
			name="GUEST";
		}
		if(name.equals("김경호")) {
			msg="잘생긴 "+name+" 님안녕하세요!!";
		}else {
			msg=name+" 님안녕하세요!!";
		}
		
		try {
			pageContext.getOut().print(msg);
		} catch (IOException e) {
			new JspException(e.getMessage());
		}
		
		
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		System.out.println("4.doEndTag()");
		try {
			pageContext.getOut().print("<hr>");
		} catch (IOException e) {
			new JspException(e.getMessage());
		}
		
		return EVAL_PAGE;
	}

}
