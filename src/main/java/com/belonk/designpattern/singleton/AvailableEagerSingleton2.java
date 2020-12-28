package com.belonk.designpattern.singleton;

/**
 * 饿汉式，静态代码块，在类初始化时就创建实例
 * <p>
 * 优点：简单，没有线程安全问题
 * 缺点：没有实现懒加载，如果类不用到会造成资源浪费
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class AvailableEagerSingleton2 {
	//~ Static fields/constants/initializer

	private static AvailableEagerSingleton2 INSTANCE;

	{
		INSTANCE = new AvailableEagerSingleton2();
	}

	//~ Instance fields


	//~ Constructors

	private AvailableEagerSingleton2() {
	}

	//~ Methods

	public static AvailableEagerSingleton2 getInstance() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		AvailableEagerSingleton2 singleton1 = AvailableEagerSingleton2.getInstance();
		AvailableEagerSingleton2 singleton2 = AvailableEagerSingleton2.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}