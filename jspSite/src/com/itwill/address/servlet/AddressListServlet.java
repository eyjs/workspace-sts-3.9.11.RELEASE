package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressListServlet
 */
@WebServlet("/address_list.do")
public class AddressListServlet extends HttpServlet {
	private AddressService addressService;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		addressService=new AddressService();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			ArrayList<Address> addressList=
					addressService.findAll();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>address list</h1><hr>");
			out.println("<div>");
			out.println("<a href='address_insert_form.do'>주소록쓰기</a>");
			out.println("</div>");
			out.println("<div>");
			out.println("	<table border=\"1\">");
			out.println("		<tr><td>이름</td><td>주소</td></tr>");
			for(Address address:addressList) {
			out.println("<tr><td><a href='address_detail.do?no="+address.getNo()+"'>"+address.getName()+"</a></td><td>"+address.getAddress()+"</td></tr>");
			}
			out.println("	</table>");
			out.println("</div>");
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

}









