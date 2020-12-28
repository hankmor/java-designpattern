package com.belonk.designpattern.singleton;

/**
 * 懒汉式，使用的时候再创建类实例，并且进行双重检查
 * <p>
 * 优点：实现了懒加载，实现了线程安全，性能高
 * 缺点：
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class AvailableDoubleCheckLazySingleton {
	//~ Static fields/constants/initializer

	// 注意，这里添加了volatile关键字，一旦INSTANCE修改，其他线程都能感知
	private volatile static AvailableDoubleCheckLazySingleton INSTANCE;

	//~ Instance fields


	//~ Constructors

	private AvailableDoubleCheckLazySingleton() {
	}

	//~ Methods

	public static AvailableDoubleCheckLazySingleton getInstance() {
		// 双重检查
		// 1、首先检查实例是否为空，存在多个线程同时得到INSTANCE为null的情况
		if (INSTANCE == null) {
			synchronized (AvailableDoubleCheckLazySingleton.class) {
				// 2、采用同步代码块，只有一个线程能够进入，并且再次判断INSTANCE是否为null，双重检查。能够很好的解决线程安全问题
				if (INSTANCE == null) {
					INSTANCE = new AvailableDoubleCheckLazySingleton();
				}
			}
		}
		return INSTANCE;
	}

	public static void main(String[] args) {
		AvailableDoubleCheckLazySingleton singleton1 = AvailableDoubleCheckLazySingleton.getInstance();
		AvailableDoubleCheckLazySingleton singleton2 = AvailableDoubleCheckLazySingleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}