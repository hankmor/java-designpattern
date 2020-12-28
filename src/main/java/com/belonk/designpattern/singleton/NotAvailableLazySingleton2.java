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
public class NotAvailableLazySingleton2 {
	//~ Static fields/constants/initializer

	private static NotAvailableLazySingleton2 INSTANCE;

	//~ Instance fields


	//~ Constructors

	private NotAvailableLazySingleton2() {
	}

	//~ Methods

	public static NotAvailableLazySingleton2 getInstance() {
		//! 这里多线程并发时，会存在线程安全问题，可能创建多个实例，违背单例模式设计
		if (INSTANCE == null) {
			// 这里并不能解决线程安全问题，因为多个线程进入这里，同样会创建多个实例
			synchronized (NotAvailableLazySingleton2.class) {
				INSTANCE = new NotAvailableLazySingleton2();
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		NotAvailableLazySingleton2 singleton1 = NotAvailableLazySingleton2.getInstance();
		NotAvailableLazySingleton2 singleton2 = NotAvailableLazySingleton2.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}