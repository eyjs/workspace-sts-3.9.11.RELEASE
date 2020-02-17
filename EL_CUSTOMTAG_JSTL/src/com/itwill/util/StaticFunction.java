package com.itwill.util;

import java.text.DecimalFormat;

public class StaticFunction {
	public static String number(double number,String pattern) {
		DecimalFormat format=new DecimalFormat(pattern);
		return format.format(number);
	}
}
