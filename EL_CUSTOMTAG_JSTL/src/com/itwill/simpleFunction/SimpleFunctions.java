package com.itwill.simpleFunction;

import com.itwill.bean.Board;

public class SimpleFunctions {
	public String getTitleString(Board board) {
		StringBuilder title = new StringBuilder(128);
		String t = board.getTitle();
		if (t.length() > 15) {
			//t = t.substring(0,15);
			//t = t+"...";
			t = String.format("%s...", t.substring(0, 15));
		}
		//답글공백삽입
		
		for (int i = 0; i < board.getDepth(); i++) {
			title.append("&nbsp;&nbsp;");
		}
		
		if (board.getDepth() > 0) {
			title.append("<img border='0' src='image/re.gif'/>");
		}
		
		title.append(t.replace(" ", "&nbsp;"));
		
		return title.toString();
}
}
