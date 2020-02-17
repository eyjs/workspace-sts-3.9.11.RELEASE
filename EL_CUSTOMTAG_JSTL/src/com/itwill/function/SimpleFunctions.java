package com.itwill.function;

public class SimpleFunctions {
	public String getTitleString(String t, int depth) {

		StringBuilder title = new StringBuilder(128);
		if (t.length() > 15) {
			// t = t.substring(0,15);
			// t = t+"...";
			t = String.format("%s...", t.substring(0, 15));
		}
		// 답글공백삽입

		for (int i = 0; i < depth; i++) {
			title.append("&nbsp;&nbsp;");
		}

		if (depth > 0) {
			title.append("<img border='0' src='image/re.gif'/>");
		}

		title.append(t.replace(" ", "&nbsp;"));

		return title.toString();
	}
}
