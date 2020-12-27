package com.belonk.designpattern.proxy;

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

	}
}

class TartObject {
	public void request1(String s) {
		System.out.println("request1 : " + s);
	}

	public void request2(String s) {
		System.out.println("request2 : " + s);
	}
}