package com.belonk.designpattern.singleton;

/**
 * 饿汉式，静态常量，在类初始化时就创建实例
 * <p>
 * 优点：简单，没有线程安全问题
 * 缺点：没有实现懒加载，如果类不用到会造成资源浪费
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class AvailableEagerSingleton1 {
	//~ Static fields/constants/initializer


	private static final AvailableEagerSingleton1 INSTANCE = new AvailableEagerSingleton1();

	//~ Instance fields


	//~ Constructors

	private AvailableEagerSingleton1() {
	}

	//~ Methods

	public static AvailableEagerSingleton1 getInstance() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		AvailableEagerSingleton1 singleton1 = AvailableEagerSingleton1.getInstance();
		AvailableEagerSingleton1 singleton2 = AvailableEagerSingleton1.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}