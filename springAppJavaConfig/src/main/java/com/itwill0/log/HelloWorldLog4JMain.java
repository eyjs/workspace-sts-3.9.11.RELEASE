package com.itwill0.log;

public class HelloWorldLog4JMain {

	public static void main(String[] args) {
		HelloWorldLog4J helloWorldLog4J=new HelloWorldLog4J();
		String msg1=helloWorldLog4J.hello("김경호");
		String msg2=helloWorldLog4J.hello("최경녀");
		System.out.println("###"+msg1);
		System.out.println("###"+msg2);

	}

}
