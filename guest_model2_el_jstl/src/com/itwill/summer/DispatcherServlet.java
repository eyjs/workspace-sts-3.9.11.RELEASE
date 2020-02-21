package com.itwill.summer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
//@WebServlet(value = {"/a.do","/b.do","/c.do"})
//@WebServlet("*.do")
//@WebServlet(value = {"/a.do"})

public class DispatcherServlet extends HttpServlet {
	private HashMap<String, Controller> controllerMap;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		controllerMap = new HashMap<String, Controller>();
		
		/*
		 * web.xml에설정된 파라메타값가져오기
		 * <servlet>
				<servlet-name>controller</servlet-name>
				<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>configFile</param-name>
					<param-value>/WEB-INF/guest_controller_mapping.properties</param-value>
				</init-param>
			</servlet>
		 */
		String configFile=config.getInitParameter("configFile");
		String configFileRealPath = 
				this.getServletContext()
				.getRealPath(configFile);
		try {
			FileInputStream fis=new FileInputStream(configFileRealPath);
			Properties mappingProperties=new Properties();
			mappingProperties.load(fis);
			Set commandKeySet = mappingProperties.keySet();
			Iterator commandKeyIter = commandKeySet.iterator();
			System.out.println("------------"+configFile+"--------------");
			while (commandKeyIter.hasNext()) {
				String command = (String) commandKeyIter.next();
				String controllerClassStr=
						mappingProperties.getProperty(command);
				//System.out.println(command+"="+controllerClassStr);
				Class c = Class.forName(controllerClassStr);
				Controller controller = (Controller)c.newInstance();
				System.out.println(command+"="+controller);
				controllerMap.put(command,controller);
			}
			System.out.println("--------------------------------------");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		/*
		controllerMap.put("/guest_main.do", new GuestMainController());
		controllerMap.put("/guest_write_form.do", new GuestWriteFormController());
		controllerMap.put("/guest_write_action.do", new GuestWriteActionController());
		controllerMap.put("/guest_list.do", new GuestListController());
		controllerMap.put("/guest_view.do", new GuestViewController());
		controllerMap.put("/guest_modify_form.do", new GuestModifyFormController());
		controllerMap.put("/guest_modify_action.do", new GuestModifyActionController());
		controllerMap.put("/guest_remove_action.do", new GuestRemoveActionController());
		controllerMap.put("/guest_error.do", new GuestErrorController());
		*/
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		  <<요청command>> 
		   	/guest_main.do 
		   	/guest_write_form.do 
		   	/guest_write_action.do
		   	/guest_list.do 
			/guest_view.do 
			/guest_modify_form.do 
			/guest_modify_action.do
		   	/guest_remove_action.do 
		   	/guest_error.do
		 */
		/*
		 * 1.클라이언트요청분석(URL)
		 */
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		/*
		 * 2.클라이언트요청에따른업무실행(Service)
		 */
		String forwardPath = "";
		/***************************************************/
		Controller controller = controllerMap.get(command);
		/***************************************************/
		forwardPath = controller.handleRequest(request, response);

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
