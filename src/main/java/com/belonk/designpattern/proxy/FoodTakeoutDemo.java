package com.belonk.designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sun on 2020/12/29.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class FoodTakeoutDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		 * 案例：外卖点餐，可以自己去餐厅取餐，也可以让外卖小哥去餐厅取餐配送。外卖小哥作为代理，动态生成
		 */
		// 不使用代理
		System.out.println("1、不使用代理，需要自己到餐厅取餐");
		TakeoutCourier resturant = new TakeoutCourier("你自己");
		resturant.takeout("牛肉面");
		// 使用代理
		System.out.println("2、使用代理，外卖小哥负责配送");
		resturant = new TakeoutCourier("外卖小哥");
		TakeoutCourierFactory courierFactory = new TakeoutCourierFactory(resturant);
		courierFactory.getProxy().takeout("牛肉面");
		courierFactory.setProxyType(TakeoutCourierFactory.ProxyType.CGLIB).getProxy().takeout("牛肉面");
	}
}

// 食物外送：抽象主题
interface FoodTakeout {
	String getName();

	void takeout(String food);
}

// 外送人员：具体主题实现
class TakeoutCourier implements FoodTakeout {
	private String name;

	public TakeoutCourier() {

	}

	public TakeoutCourier(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void takeout(String food) {
		System.out.println(this.name + "正在餐厅取餐：" + food);
	}
}

// 送餐小哥：代理工厂动态创建
class TakeoutCourierFactory {
	public enum ProxyType {
		JDK, CGLIB;
	}

	private final FoodTakeout foodTakeout;
	// 默认使用jdk代理
	private ProxyType proxyType = ProxyType.JDK;

	public TakeoutCourierFactory(FoodTakeout takeout) {
		this.foodTakeout = takeout;
	}

	public TakeoutCourierFactory setProxyType(ProxyType proxyType) {
		this.proxyType = proxyType;
		return this;
	}

	public FoodTakeout getProxy() {
		FoodTakeout proxyObject = null;
		switch (proxyType) {
			case JDK:
				System.out.println("> 使用jdk代理");
				JdkTakeoutCourierProxy jdkTakeoutCourierProxy = new JdkTakeoutCourierProxy(foodTakeout, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(foodTakeout.getName() + "进入餐厅...");
						Object result = method.invoke(foodTakeout, args);
						System.out.println(foodTakeout.getName() + "送达餐品");
						return result;
					}
				});
				proxyObject = (FoodTakeout) jdkTakeoutCourierProxy.getProxy();
				break;
			case CGLIB:
				System.out.println("> 使用CGLIB代理");
				CglibTakeoutCourierProxy cglibTakeoutCourierProxy = new CglibTakeoutCourierProxy(foodTakeout, new MethodInterceptor() {
					@Override
					public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
						System.out.println(foodTakeout.getName() + "进入餐厅...");
						Object result = method.invoke(foodTakeout, args);
						System.out.println(foodTakeout.getName() + "送达餐品");
						return result;
					}
				});
				proxyObject = (FoodTakeout) cglibTakeoutCourierProxy.getProxy();
				break;
			default:
		}
		return proxyObject;
	}

	// 基于JDK的代理实现
	private static class JdkTakeoutCourierProxy {
		// 被代理对象
		private final Object target;
		// 方法执行时拦截处理器
		private final InvocationHandler invocationHandler;

		JdkTakeoutCourierProxy(Object target, InvocationHandler invocationHandler) {
			this.target = target;
			this.invocationHandler = invocationHandler;
		}

		public Object getProxy() {
			return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this.invocationHandler);
		}
	}

	// 基于cglib的代理实现
	private static class CglibTakeoutCourierProxy {
		// 被代理对象
		private final Object target;
		// 方法执行时拦截处理器
		private final MethodInterceptor invocationHandler;

		CglibTakeoutCourierProxy(Object target, MethodInterceptor invocationHandler) {
			this.target = target;
			this.invocationHandler = invocationHandler;
		}

		public Object getProxy() {
			return Enhancer.create(target.getClass(), target.getClass().getInterfaces(), this.invocationHandler);
		}
	}
}