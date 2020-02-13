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
 * Servlet implementation class AddressUpdateFormServlet
 */
@WebServlet("/address_update_form.do")
public class AddressUpdateFormServlet extends HttpServlet {
	private AddressService addressService;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.파라메타바끼 
		 * 2.Service메쏘드호출 
		 * 3.클라이언트로 출력
		 */
		try {
			String noStr = request.getParameter("no");
			if (noStr == null || noStr.equals("")) {
				response.sendRedirect("address_list.do");
				return;
			}
			addressService = new AddressService();
			Address address = addressService.findByNo(Integer.parseInt(noStr));
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<h1>"+address.getName()+" 님수정폼</h1><hr>");
			out.println("<div>");
			out.println("	<a href='address_list.do'>주소록리스트</a>");
			out.println("</div>");
			out.println("<form method='post' action='address_update_action.do'>");
			out.println("	번호[readonly]<input type='text' name='no' value='"+address.getNo()+"' readonly='readonly'><br>");
			out.println("	아이디--<input type='text' name='id' value='"+address.getId()+"'><br>");
			out.println("	이름----<input type='text' name='name' value='"+address.getName()+"'><br>");
			out.println("	전화번호<input type='text' name='phone' value='"+address.getPhone()+"'><br>");
			out.println("	주소----<input type='text' name='address' value='"+address.getAddress()+"'><br>");
			out.println("	<input type='submit' value='"+address.getName()+"님수정'>");
			out.println("	<input type='reset' value='폼지우기'>");
			out.println("</form>");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
