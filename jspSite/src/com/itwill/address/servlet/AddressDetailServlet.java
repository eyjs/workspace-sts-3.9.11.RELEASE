package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressDetailServlet
 */
@WebServlet("/address_detail.do")
public class AddressDetailServlet extends HttpServlet {
	private AddressService addressService;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		/*
		 address_detail.do?no=16
		 */
		String noStr=request.getParameter("no");
		if(noStr==null|| noStr.equals("")) {
			response.sendRedirect("address_list.do");
			return;
		}
		addressService=new AddressService();
		Address address= addressService.findByNo(Integer.parseInt(noStr));
		if(address==null) {
			response.sendRedirect("error_404.html");
			return;
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+address.getName()+"님 address detail</h1><hr>");
		out.println("<div>");
		out.println("<a href='address_delete_action.do?no="+address.getNo()+"'>"+address.getName()+"님삭제[GET]X</a>");
		out.println("<form action='address_delete_action.do' method='post'>");
		out.println("	<input type='hidden' name='no' value='"+address.getNo()+"'>");
		out.println("	<input type='submit' value='"+address.getName()+"님삭제[POST]O'>");
		out.println("</form> ");
		out.println("<a href='address_update_form.do?no="+address.getNo()+"'>"+address.getName()+"님수정폼</a>");
		out.println("<a href='address_insert_form.do'>주소록쓰기</a>");
		out.println("<a href='address_list.do'>주소록리스트</a>");
		out.println("</div>");
		out.println("<p>");
		out.println("	번호:"+address.getNo()+"<br>");
		out.println("	아이디:"+address.getId()+"<br>");
		out.println("	이름:"+address.getName()+"<br>");
		out.println("	전화:"+address.getPhone()+"<br>");
		out.println("	주소:"+address.getAddress()+"<br>");
		out.println("</p>");
		
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
