package com.itwill.simpleTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag  extends TagSupport{
	public HelloTag() {
		System.out.println("1.HelloTag()생성자");
	}
	@Override
	public int doStartTag() throws JspException {
		System.out.println("2.doStartTag()");
		return super.doStartTag();
	}
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("2.doEndTag()");
		return super.doEndTag();
	}
}
