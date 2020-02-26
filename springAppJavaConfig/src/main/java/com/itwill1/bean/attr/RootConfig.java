package com.itwill1.bean.attr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
/*
 1.bean_attr.xml
 */
@Configuration
public class RootConfig {
	/*
	<bean id="initDestroyBean" init-method="myInit"
		destroy-method="myDestroy"
		class="com.itwill1.bean.attr.InitDestroyBean" />
	 */
	@Bean(value = "initDestroyBean",
			initMethod = "myInit",
			destroyMethod = "myDestroy")
	public InitDestroyBean initDestroyBean() {
		return new InitDestroyBean();
	}
	/*
	 <bean lazy-init="true" id="lazyInitBean"
		class="com.itwill1.bean.attr.LazyInitBean" />
	 */
	@Bean
	@Lazy(value = true)
	public LazyInitBean lazyInitBean() {
		return new LazyInitBean();
	}
	/*
	<bean id="singletonBean" scope="singleton"
		class="com.itwill1.bean.attr.SingletonScopeBean" />
	<bean id="prototypeBean" scope="prototype"
		class="com.itwill1.bean.attr.PrototypeScopeBean" />
	 */
	@Bean(value = "singletonBean")
	@Scope(value = "singleton")
	public SingletonScopeBean singletonScopeBean() {
		return new SingletonScopeBean();
	}
	@Bean(value = "prototypeBean")
	@Scope(value = "prototype")
	public PrototypeScopeBean prototypeScopeBean() {
		return new PrototypeScopeBean();
	}
	/*
	<bean id="dependsOnA" depends-on="dependsOnB"
			class="com.itwill1.bean.attr.DependsOnA" />
	<bean id="dependsOnB" class="com.itwill1.bean.attr.DependsOnB" />
	*/
	@Bean("dependsOnA")
	@DependsOn(value = "dependsOnB")
	public DependsOnA dependsOnA() {
		return new DependsOnA();
	}
	@Bean("dependsOnB")
	public DependsOnB dependsOnB() {
		return new DependsOnB();
	}
	
}













