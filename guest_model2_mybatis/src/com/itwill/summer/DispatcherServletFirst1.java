package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
/*
 *  모든요청의 진입점(Controller)
 */
public class DispatcherServletFirst1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		<<요청command>>
		/guest_main.do
		/guest_write_form.do
		/guest_write_action.do
		/guest_list.do
		/guest_view.do
		/guest_modify_form.do
		/guest_modify_action.do
		/guest_delete_action.do
		/guest_error.do
		 */
		/*
		 * 1.클라이언트요청분석(URL)
		 */
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		/*
		 * 2.클라이언트요청에따른업무실행(Service)
		 */
		String forwardPath="";
		/***************************************************/
		switch (command) {
		case "/guest_main.do":
			break;
		case "/guest_list.do":
			break;
		case "/guest_view.do":
			break;
		case "/guest_write_form.do":
			break;
		case "/guest_write_action.do":
			break;
		case "/guest_remove_action.do":
			break;
		case "/guest_modify_form.do":
			break;
		case "/guest_modify_action.do":
			break;
		default:
			break;
		}
		/****************************************************/
		/*
		 * 3.JSP forward or redirect
		 */
		String[] pathArray = forwardPath.split(":");
		String isRedirect = pathArray[0];
		forwardPath = pathArray[1];
		if (isRedirect.equals("redirect")) {
			response.sendRedirect(forwardPath);
		} else if (isRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
	}
	

}










