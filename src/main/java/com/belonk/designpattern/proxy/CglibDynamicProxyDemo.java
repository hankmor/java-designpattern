package com.belonk.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by sun on 2020/12/27.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class CglibDynamicProxyDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		CglibSubject targetObject = new TargetObject();
		System.out.println("目标对象：" + targetObject.getClass());
		CglibDynamicProxyFactory proxyFactory = new CglibDynamicProxyFactory(targetObject);
		CglibSubject proxyInstance = proxyFactory.getProxyInstance();
		System.out.println("代理后对象: " + proxyInstance.getClass());
		proxyInstance.request1("请求1");
		proxyInstance.request2("请求2");

		/*~;输出
		目标对象：class com.belonk.designpattern.proxy.TargetObject
		代理后对象: class com.belonk.designpattern.proxy.TargetObject$$EnhancerByCGLIB$$6f621012
		before request...
		request1 : 请求1
		after request...
		before request...
		request2 : 请求2
		after request...
		 */
	}
}

// 抽象主题
interface CglibSubject {
	void request1(String s);

	void request2(String s);
}

// 真实主题
class TargetObject implements CglibSubject {
	@Override
	public void request1(String s) {
		System.out.println("request1 : " + s);
	}

	@Override
	public void request2(String s) {
		System.out.println("request2 : " + s);
	}
}

// 代理工厂
class CglibDynamicProxyFactory {
	// 目标对象，代理之前的原始对象
	private final CglibSubject target;

	public CglibDynamicProxyFactory(CglibSubject subject) {
		this.target = subject;
	}

	public CglibSubject getProxyInstance() {
		/*
		 * CGLIB动态代理，可以直接代理目标对象，它可以不实现接口，底层使用asm字节码处理框架来转换字节码生成新代理类
		 */
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(new MethodInterceptor() {
			/**
			 * 处理拦截回调，在目标对象执行前后拦截(around advice)。
			 *
			 * @param proxy 目标对象，代理之前的原始对象
			 * @param method 被拦截的方法
			 * @param args 方法执行参数
			 * @param methodProxy 方法代理，可以用来调用原始对象和代理对象的方法
			 * @return 方法调用返回值
			 * @throws Throwable 异常信息
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				System.out.println("before request...");
				Object result = method.invoke(target, args);
				System.out.println("after request...");
				return result;
			}
		});
		return (CglibSubject) enhancer.create();
	}

}