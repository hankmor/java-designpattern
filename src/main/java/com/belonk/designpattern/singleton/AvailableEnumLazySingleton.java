package com.belonk.designpattern.singleton;

/**
 * 使用枚举的方式创建单例。
 * <p>
 * 优点：简单、性能高、无并发问题
 * 缺点：个人认为，违背枚举的定位，简单工具类可以，但是不好管理（如Spring管理的Bean），可能会收到一定限制
 * <p>
 * Effective Java中提倡的方式
 * <p>
 * Created by sun on 2020/5/26.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public enum AvailableEnumLazySingleton {
	//~ Elements

	INSTANCE;

	//~ Instance fields


	//~ Constructors


	//~ Methods

	public void sayHello() {
		System.out.println("hello");
	}

	public static void main(String[] args) {
		AvailableEnumLazySingleton singleton1 = AvailableEnumLazySingleton.INSTANCE;
		AvailableEnumLazySingleton singleton2 = AvailableEnumLazySingleton.INSTANCE;
		System.out.println(singleton1 == singleton2);
		singleton1.sayHello();
	}
}
