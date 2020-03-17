package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestResultList;
import com.itwill.guest.GuestService;

@Controller

public class GuestRestController {
	@Autowired
	private GuestService guestService;

	@RequestMapping(value = "/guest/guest_list_html.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String guest_list_html() throws Exception {
		StringBuffer sb = new StringBuffer();
		List<Guest> guestList = guestService.selectAll();
		for (int i = 0; i < guestList.size(); i++) {
			Guest guest = guestList.get(i);
			sb.append("<div class=\"guest_item\">");
			sb.append("<h3 class=\"guest_title\"  guest_no=\"" + guest.getGuest_no() + "\"><a href='#'>"
					+ guest.getGuest_title() + "</a>[HTML]</h3>");
			sb.append("</div>");
		}
		return sb.toString();
	}
	@RequestMapping(value = "/guest/guest_list_json.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody List<Guest> guest_list_json() throws Exception {
		List<Guest> guestList = guestService.selectAll();
		return guestList;
	}
	@RequestMapping(value = "/guest/guest_list_xml.do", produces = "application/xml;charset=UTF-8")
	public @ResponseBody GuestResultList guest_list_xml() throws Exception {
		List<Guest> guestList = guestService.selectAll();
		GuestResultList guestResultList=new GuestResultList();
		guestResultList.setGuestList(guestList);
		return guestResultList;
	}

	@RequestMapping(value = "/guest/guest_detail_html.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String guest_detail_html(@RequestParam(defaultValue = "5") String guest_no) throws Exception {
		StringBuffer sb = new StringBuffer();
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no.trim()));
		sb.append("<div class=\"guest_date\">");
		sb.append("날짜:" + guest.getGuest_date());
		sb.append("</div>");
		sb.append("<div class=\"guest_name\">");
		sb.append("	이름:" + guest.getGuest_name());
		sb.append("</div>");
		sb.append("<div class=\"guest_email\">");
		sb.append("이메일:" + guest.getGuest_email());
		sb.append("</div>");
		sb.append("<div class=\"guest_homepage\">");
		sb.append("홈페이지:" + guest.getGuest_homepage());
		sb.append("</div>");
		sb.append("<div class=\"guest_content\">");
		sb.append("내용:" + guest.getGuest_content());
		sb.append("</div>");
		return sb.toString();
	}
	
	@RequestMapping(value = "/guest/guest_detail_json.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody Guest guest_detail_json(@RequestParam(defaultValue = "5") String guest_no) throws Exception {
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no.trim()));
		return guest;
	}
	@RequestMapping(value = "/guest/guest_detail_xml.do", produces = "application/xml;charset=UTF-8")
	public @ResponseBody Guest guest_detail_xml(@RequestParam(defaultValue = "5") String guest_no) throws Exception {
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no.trim()));
		return guest;
	}

	@RequestMapping(value = "/guest/guest_insert_action.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String guest_insert_action(@ModelAttribute Guest guest) throws Exception {
		String result = "false";
		try {
			// 2.DAO 메쏘드 호출
			boolean insertSuccess = guestService.insertGuest(guest);
			if (insertSuccess) {
				result = "true";
			} else {
				result = "false";
			}
		} catch (Exception e) {
			result = "false";
		}
		return result;
	}

	@RequestMapping(value = "/guest/guest_login_action.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String guest_login_action(@RequestParam String guest_id, @RequestParam String guest_pass,
			HttpSession session) throws Exception {
		String result = "fail";

		if (guest_id == null)
			guest_id = "";
		if (guest_pass == null)
			guest_pass = "";
		/*
		 * -----|------ id | pass -----|------ user1|user2 user1|user2
		 */
		if ((guest_id.equals("user1") && guest_pass.equals("user1"))
				|| (guest_id.equals("user2") && guest_pass.equals("user2"))) {
			session.setAttribute("user_id", guest_id);
			result = "success";
		} else {
			result = "fail";
		}
		return result;
	}

	@RequestMapping(value = "/guest/guest_logout_action.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String guest_logout_action(HttpSession session) throws Exception {
		String result = "succcess";
		session.invalidate();
		return result;
	}

	@RequestMapping(value = "/guest/guest_session_check.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map guest_session_check(HttpSession session) {
		String isLogin = "fail";
		String user_id = (String) session.getAttribute("user_id");
		if (user_id != null) {
			isLogin = "success";
		}
		HashMap map=new HashMap();
		map.put("status", isLogin);
		map.put("login_id", user_id);
		return map;
	}
}
