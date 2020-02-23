package com.itwill.guest;

public class GuestUtil {
	/*
		 * \r\n을 html <br>로 convert
		 */
		public static String convertHtmlBr(String comment) {
			//**********************************************************************
			if (comment == null)
				return "";
			int length = comment.length();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < length; i++) {
				String tmp = comment.substring(i, i + 1);
				if ("\r".compareTo(tmp) == 0) {
					tmp = comment.substring(++i, i + 1);
					if ("\n".compareTo(tmp) == 0)
						buffer.append("<br>\r");
					else
						buffer.append("\r");
				}
				buffer.append(tmp);
			}
			return buffer.toString();
		}
}

