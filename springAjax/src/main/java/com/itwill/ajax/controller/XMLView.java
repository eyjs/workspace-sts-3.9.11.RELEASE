package com.itwill.ajax.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class XMLView extends AbstractView{
	public XMLView() {
		System.out.println("### XMLView()생성자");
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<String> friendsList=
				(ArrayList<String>)model.get("friendsList");
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<?xml version='1.0' encoding='UTF-8'?>");
		out.println("<friends>");
		for (String friend : friendsList) {
			out.println("<friend>");
			out.print(friend);
			out.println("</friend>");
		}
		out.print("</friends>");
	}

}









