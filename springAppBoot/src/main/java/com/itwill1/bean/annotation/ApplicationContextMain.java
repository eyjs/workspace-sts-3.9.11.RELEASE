package com.itwill1.bean.annotation;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args)throws Exception {
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill1/bean/annotation/1.bean_annotation.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		AnnotationBean annotationBean1=
				(AnnotationBean)applicationContext.getBean("annotationBean");
		AnnotationBean annotationBean2=
				(AnnotationBean)applicationContext.getBean("annotationBean");
		AnnotationBean annotationBean3=
				(AnnotationBean)applicationContext.getBean("annotationBean");
		System.out.println("### annotationBean1:"+annotationBean1);
		System.out.println("### annotationBean2:"+annotationBean2);
		System.out.println("### annotationBean3:"+annotationBean3);
		
		
		DisposableBean context=(DisposableBean)applicationContext;
		context.destroy();
	}

}
