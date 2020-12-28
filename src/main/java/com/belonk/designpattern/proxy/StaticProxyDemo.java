package com.belonk.designpattern.proxy;

/**
 * Created by sun on 2020/12/27.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class StaticProxyDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		 * 静态代理；
		 * 优点：不修改真实主题对象就可以通过代理对象扩展其功能
		 * 缺点：
		 * 1、每一个真实主题对象都需要创建一个代理类，类可能过多；
		 * 2、抽象主题修改，所有的代理类也会修改
		 *
		 * 解决方案：动态代理
		 */

		// 直接请求
		Subject subject = new RealSubject();
		subject.request();
		// 通过代理请求
		Proxy proxy = new Proxy(subject);
		proxy.request();
		/*
		request...
		before request...
		request...
		after request...
		 */
	}
}

// 抽象主题
interface Subject {
	void request();
}

// 真实主题
class RealSubject implements Subject {
	@Override
	public void request() {
		System.out.println("request...");
	}
}

class Proxy implements Subject {
	private final Subject subject;

	public Proxy(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void request() {
		// 扩展功能
		System.out.println("before request...");
		this.subject.request();
		System.out.println("after request...");
	}
}