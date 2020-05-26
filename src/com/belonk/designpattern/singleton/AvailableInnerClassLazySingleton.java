package com.belonk.designpattern.singleton;

/**
 * 懒汉式，使用静态内部类实现
 * <p>
 * 优点：实现了懒加载，实现了线程安全，性能高
 * 缺点：
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class AvailableInnerClassLazySingleton {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors

	private AvailableInnerClassLazySingleton() {
	}

	//~ Methods

	public static AvailableInnerClassLazySingleton getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * 静态内部类
	 * <p>
	 * 静态内部类在外部类装载时并不会立即实例化，而是在调用getInstance方法，才会装载内部类，从而完成实例化。
	 * <p>
	 * 类加载是创建实例，保证了线程安全
	 */
	private static class InstanceHolder {
		private static final AvailableInnerClassLazySingleton INSTANCE = new AvailableInnerClassLazySingleton();
	}

	public static void main(String[] args) {
		// Set<AvailableInnerClassLazySingleton> singletons = new HashSet<>();
		// for (int i = 0; i < 10000; i++) {
		// 	for (int j = 0; j < 100; j++) {
		// 		new Thread(() -> {
		// 			singletons.add(AvailableInnerClassLazySingleton.getInstance());
		// 			if (singletons.size() > 1) {
		// 				System.out.println("出错了：" + singletons.size());
		// 			}
		// 		}).start();
		// 	}
		// }
		AvailableInnerClassLazySingleton singleton1 = AvailableInnerClassLazySingleton.getInstance();
		AvailableInnerClassLazySingleton singleton2 = AvailableInnerClassLazySingleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}