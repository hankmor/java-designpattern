package com.belonk.designpattern.adapter;

/**
 * 接口适配器模式: 提供了接口，但是不想让使用者实现接口的所有方法，可以提供接口适配器。
 * <p>
 * Created by sun on 2020/8/19.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class InterfaceAdapterPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/**
	 * 示例：
	 */
	public static void main(String[] args) {
		Client client = new Client();
		// 没有适配器，需要实现所有接口，即使有些方法用不到
		client.handle(new MyInterceptor() {
			@Override
			public void before() {
				System.out.println("处理前拦截");
			}

			@Override
			public void post() {
			}

			@Override
			public void after() {
			}
		});

		// 提供接口适配器，覆盖需要处理的方法即可
		client.handle(new MyInterceptorAdapter() {
			@Override
			public void before() {
				System.out.println("处理前拦截");
			}
		});
	}
}

/**
 * 目标接口，提供了一系列方法，但是不提供实现，需要使用者自己实现
 */
interface MyInterceptor {
	void before();

	void post();

	void after();
}

/**
 * 使用者
 */
class Client {
	void handle(MyInterceptor interceptor) {
		interceptor.before();
		interceptor.post();
		interceptor.after();
	}
}

/**
 * 接口适配器，实现接口，提供默认方法实现
 */
class MyInterceptorAdapter implements MyInterceptor {
	@Override
	public void before() {

	}

	@Override
	public void post() {

	}

	@Override
	public void after() {

	}
}