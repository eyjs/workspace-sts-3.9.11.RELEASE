package com.itwill.address.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressUpdateActionServlet
 */
@WebServlet("/address_update_action.do")
public class AddressUpdateActionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			response.sendRedirect("address_list.do");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.파라메타받기
		 * 2.AddressService update메쏘드호출
		 * 3.address_detail.do?no=12 로 redirection
		 */
		try {
			request.setCharacterEncoding("UTF-8");
			String noStr=request.getParameter("no");
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			AddressService addressService= new AddressService();
			addressService.update(new Address(Integer.parseInt(noStr), id, name, phone, address));
			response.sendRedirect("address_detail.do?no="+noStr);
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error/error.jsp");
		}
		
	}

}
