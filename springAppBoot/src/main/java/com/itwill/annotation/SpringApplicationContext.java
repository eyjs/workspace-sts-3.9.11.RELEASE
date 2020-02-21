package com.itwill.annotation;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

public class SpringApplicationContext {
	private HashMap beanMap=new HashMap();
	public SpringApplicationContext() {
	}
	public void printBean() {
		System.out.println(beanMap);
	}
	public <T> T getBean(Class<T> clazz) throws IllegalAccessException, InstantiationException {
		
		Field[] fields=clazz.getFields();
		Method[] methods=clazz.getMethods();
		System.out.println("------------멤버변수-----------------------");
		for (Field field : fields) {
			System.out.println(field);
			System.out.println(field.getAnnotation(TestAnnotation.class));
		}
		System.out.println("--------------메쏘드--------------------");
		for (Method method:methods) {
			System.out.println(method);
			System.out.println(method.getAnnotation(TestAnnotation.class));
		}
		System.out.println("-----------------------------------");
		
		MyComponent annotation = (MyComponent)clazz.getAnnotation(MyComponent.class);
		if(annotation!=null && annotation.annotationType()==MyComponent.class) {
			T instance = (T)clazz.newInstance();
			String beanName=annotation.value();
			if(beanName.equals("")) {
				String className = instance.getClass().getSimpleName();
				beanMap.put(className,instance);
				
			}else {
				beanMap.put(beanName,instance);
				
			}
			return instance;
		}else {
			return null;
		}
	}
}