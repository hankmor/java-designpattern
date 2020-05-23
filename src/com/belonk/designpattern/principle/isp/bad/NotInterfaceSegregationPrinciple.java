package com.belonk.designpattern.principle.isp.bad;

/**
 * 未遵守接口隔离原则，每个实现Interface接口的类，都需要实现它的每一个方法。
 * <p>
 * Created by sun on 2020/5/23.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NotInterfaceSegregationPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods


}

interface Interface {
	default void fun1() {
		System.out.println("调用fun1...");
	}

	default void fun2() {
		System.out.println("调用fun2...");
	}

	default void fun3() {
		System.out.println("调用fun3...");
	}

	default void fun4() {
		System.out.println("调用fun4...");
	}
}

class A implements Interface {

}

class B implements Interface {

}

class C implements Interface {

}

class D implements Interface {

}