package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressDeleteActionServlet
 */
@WebServlet("/address_delete_action.do")
public class AddressDeleteActionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("address_list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 1.파라메타받기 
		 * 2.AddressService.delete메쏘드호출 
		 * 3.address_list.do redirection
		 */
		try {
			request.setCharacterEncoding("UTF-8");
			String noStr=request.getParameter("no");
			AddressService addressService=new AddressService();
			addressService.delete(Integer.parseInt(noStr));
			response.sendRedirect("address_list.do");
		}catch (Exception e) {
			response.sendRedirect("error/error.jsp");
			e.printStackTrace();
			
		}
		
	}

}
