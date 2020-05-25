package com.belonk.designpattern.principle.lsp;

/**
 * Created by sun on 2020/5/24.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class LiskovSubstitutionPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/**
	 * 里氏替换原则：所有引用父类的地方，都可以换成子类。
	 */
	public static void main(String[] args) {
		int a = 10, b = 2, c = 8;

		// 创建子类实例
		Minus minus = new Minus();
		int   res   = minus.calc(a, b);
		// 8
		System.out.println(res);
		res = minus.minusThenPlus(a, b, c);
		// 16
		System.out.println(res);

		// 创建子类实例
		Plus plus = new Plus();
		plus.setMinus(minus);
		// 12
		res = plus.calc(a, b);
		System.out.println(res);
		// 16
		res = plus.minusThenPlus(a, b, c);
		System.out.println(res);
	}
}

abstract class Math {
	protected abstract int calc(int a, int b);

	protected abstract int minusThenPlus(int a, int b, int c);
}

class Minus extends Math {
	// 求减法
	@Override
	public int calc(int a, int b) {
		return a - b;
	}

	// 求减法然后在求和
	@Override
	public int minusThenPlus(int a, int b, int c) {
		return calc(a, b) + c;
	}
}

class Plus extends Math {
	// 依赖Minus类来求减法
	private Minus minus;

	// 求和实现
	@Override
	public int calc(int a, int b) {
		return a + b;
	}

	// 求减法再求和
	@Override
	public int minusThenPlus(int a, int b, int c) {
		return this.minus.calc(a, b) + c;
	}

	public void setMinus(Minus minus) {
		this.minus = minus;
	}
}