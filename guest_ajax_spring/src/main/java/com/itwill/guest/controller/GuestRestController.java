package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestResultList;
import com.itwill.guest.GuestService;

@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	@RequestMapping(value = "guest/guest_list_html", produces = "text/plain;charset=UTF-8")
	public String guest_list_html() throws Exception {
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
	@RequestMapping(value = "guest/guest_list_xml2", produces = "text/xml;charset=UTF-8")
	public List<Guest> guest_list_xml2() throws Exception {
		return guestService.selectAll();
	}
	
	@RequestMapping(value = "guest/guest_list_xml", produces = "text/xml;charset=UTF-8")
	public GuestResultList guest_list_xml() throws Exception {
		
		GuestResultList guestResultList=new GuestResultList();
		guestResultList.setGuestList(guestService.selectAll());
		
		return guestResultList;
	}
	@RequestMapping(value = "guest/guest_detail_xml", produces = "text/xml;charset=UTF-8")
	public String guest_detail_xml() throws Exception {
		
		return "";
	}
	@RequestMapping(value = "guest/guest_list_json", produces = "application/json;charset=UTF-8")
	public List<Guest> guest_list_json() throws Exception {
		return guestService.selectAll();
		
	}
	@RequestMapping(value = "guest/guest_detail_json", produces = "application/json;charset=UTF-8")
	public List<Guest> guest_detail_json(@RequestParam(value = "guest_no")int  guest_no) throws Exception {
		Guest guest = guestService.selectByNo(guest_no);
		List<Guest> guestList=new ArrayList<Guest>();
		guestList.add(guest);
		return guestList;
	}
	
	
}
