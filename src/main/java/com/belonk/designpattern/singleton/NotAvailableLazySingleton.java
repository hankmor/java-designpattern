package com.belonk.designpattern.singleton;

/**
 * 懒汉式，使用的时候再创建类实例
 * <p>
 * 优点：实现了懒加载
 * 缺点：存在线程安全问题
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NotAvailableLazySingleton {
	//~ Static fields/constants/initializer

	private static NotAvailableLazySingleton INSTANCE;

	//~ Instance fields


	//~ Constructors

	private NotAvailableLazySingleton() {
	}

	//~ Methods

	public static NotAvailableLazySingleton getInstance() {
		//! 这里多线程并发时，会存在线程安全问题，可能创建多个实例，违背单例模式设计
		if (INSTANCE == null) {
			INSTANCE = new NotAvailableLazySingleton();
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		NotAvailableLazySingleton singleton1 = NotAvailableLazySingleton.getInstance();
		NotAvailableLazySingleton singleton2 = NotAvailableLazySingleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}