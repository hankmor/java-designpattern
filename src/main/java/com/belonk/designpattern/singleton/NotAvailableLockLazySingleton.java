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
public class NotAvailableLockLazySingleton {
	//~ Static fields/constants/initializer

	private static NotAvailableLockLazySingleton INSTANCE;

	//~ Instance fields


	//~ Constructors

	private NotAvailableLockLazySingleton() {
	}

	//~ Methods

	public synchronized static NotAvailableLockLazySingleton getInstance() {
		//! 直接在方法上加锁，解决了线程安全问题，但是性能太低
		if (INSTANCE == null) {
			INSTANCE = new NotAvailableLockLazySingleton();
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		NotAvailableLockLazySingleton singleton1 = NotAvailableLockLazySingleton.getInstance();
		NotAvailableLockLazySingleton singleton2 = NotAvailableLockLazySingleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}