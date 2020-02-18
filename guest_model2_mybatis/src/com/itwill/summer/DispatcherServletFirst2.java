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
public class DispatcherServletFirst2 extends HttpServlet {
	
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
			forwardPath="forward:/WEB-INF/views/guest_main.jsp";
			break;
		case "/guest_list.do":
			try {
				GuestService guestService=new GuestService();
				ArrayList<Guest> guestList=guestService.selectAll();
				request.setAttribute("guestList", guestList);
				forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
				
			}catch (Exception e) {
				request.setAttribute("error_msg", e.getMessage());
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
			
			break;
		case "/guest_view.do":
			String guest_noStr1 = request.getParameter("guest_no");
			if(guest_noStr1==null||guest_noStr1.equals("")){
				//response.sendRedirect("guest_main.jsp");
				forwardPath="redirect:guest_main.do";
			}else {
				try {
					GuestService guestService=new GuestService();
					Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr1));
					if(guest==null){
						/*
							<script>
								alert('존재하지않는 게시물입니다.');
								location.href='guest_list.jsp';
							</script>	
						 */	
						forwardPath="redirect:guest_list.do";
						//forwardPath="forward:guest_list.do";
					}else {
						request.setAttribute("guest", guest);
						forwardPath="forward:/WEB-INF/views/guest_view.jsp";
					}
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
			break;
		case "/guest_write_form.do":
			forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";
			break;
		case "/guest_write_action.do":
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main.do";
			}else {
				
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				try {
					GuestService guestService = new GuestService();
					boolean insertOK = guestService
							.insertGuest(new Guest(0, guest_name, "", guest_email, guest_homepage, guest_title, guest_content));
					if (insertOK) {
						//response.sendRedirect("guest_list.jsp");
						forwardPath="redirect:guest_list.do";
					} else {
						//response.sendRedirect("guest_error.jsp");
						forwardPath="forward:/WEB-INF/views/guest_error.jsp";
						
					}
				}catch (Exception e) {
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
					e.printStackTrace();
					
				}
			}
			break;
		case "/guest_remove_action.do":
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main.do";
			}else {
				try {
					String guest_noStr2 = request.getParameter("guest_no");
					GuestService guestService = new GuestService();
					boolean insertOK = guestService.deleteGuest(Integer.parseInt(guest_noStr2));
					if (insertOK) {
						//response.sendRedirect("guest_list.jsp");
						forwardPath="redirect:guest_list.do";
					} else {
						//response.sendRedirect("guest_error.jsp");
						forwardPath="forward:/WEB-INF/views/guest_error.jsp";
					}
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
			break;
		case "/guest_modify_form.do":
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main.do";
			}else {
				try {
					String guest_noStr3 = request.getParameter("guest_no");
					GuestService guestService = new GuestService();
					Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr3));
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
			break;
		case "/guest_modify_action.do":
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath = "redirect:guest_main.do";
			}else {
				try {
					
					String guest_noStr = request.getParameter("guest_no");
					String guest_name = request.getParameter("guest_name");
					String guest_email = request.getParameter("guest_email");
					String guest_homepage = request.getParameter("guest_homepage");
					String guest_title = request.getParameter("guest_title");
					String guest_content = request.getParameter("guest_content");
					GuestService guestService = new GuestService();
					Guest updateGuest = new Guest(Integer.parseInt(guest_noStr), guest_name, "", guest_email, guest_homepage,
							guest_title, guest_content);
					boolean updateOK = guestService.updateGuest(updateGuest);
					if (updateOK) {
						//response.sendRedirect("guest_view.jsp?guest_no=" + guest_noStr);
						forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
						//forwardPath="forward:guest_view.do";
					} else {
						//response.sendRedirect("guest_error.jsp");
						forwardPath="forward:/WEB-INF/views/guest_error.jsp";
					}
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
			break;
		default:
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
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










