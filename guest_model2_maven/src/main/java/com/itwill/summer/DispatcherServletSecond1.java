package com.itwill.summer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;
/*
 *  모든요청의 진입점(Controller)
 */
public class DispatcherServletSecond1 extends HttpServlet {
	
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
		Controller controller=null;
		/***************************************************/
		switch (command) {
		case "/guest_main.do":
			controller=new GuestMainController();
			break;
		case "/guest_list.do":
		    controller=new GuestListController();
			break;
		case "/guest_view.do":
			controller=new GuestViewController();
			break;
		case "/guest_write_form.do":
			controller=new GuestWriteFormController();
			break;
		case "/guest_write_action.do":
			controller=new GuestWriteActionController();
			break;
		case "/guest_remove_action.do":
			controller=new GuestRemoveActionController();
			break;
		case "/guest_modify_form.do":
			controller=new GuestModifyFormController();
			
			break;
		case "/guest_modify_action.do":
			controller=new GuestModifyActionController();
			
			break;
		default:
			controller=new GuestErrorController(); 
			break;
		}
		/****************************************************/
		forwardPath=controller.handleRequest(request, response);
		
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










