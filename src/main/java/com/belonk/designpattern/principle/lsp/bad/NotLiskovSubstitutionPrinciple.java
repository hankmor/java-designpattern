package com.belonk.designpattern.principle.lsp.bad;

/**
 * Created by sun on 2020/5/24.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class NotLiskovSubstitutionPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		 * 违反了里氏替换原则，Math换成子类Calc，计算结果错误
		 */

		int a = 10, b = 2, c = 8;

		Minus minus = new Minus();
		int   res   = minus.calc(a, b);
		// 8
		System.out.println(res);
		res = minus.minusThenPlus(a, b, c);
		// 16
		System.out.println(res);

		minus = new Plus();
		// 期望得到减法的结果8，实际上子类覆盖了父类的计算方法，得到的是12
		res = minus.calc(a, b);
		System.out.println(res);
		// 期望得到16，实际上是20
		res = minus.minusThenPlus(a, b, c);
		System.out.println(res);
	}
}

class Minus {
	// 求减法
	public int calc(int a, int b) {
		return a - b;
	}

	// 求减法然后在求和
	public int minusThenPlus(int a, int b, int c) {
		return calc(a, b) + c;
	}
}

class Plus extends Minus {
	// 改为求和，覆盖了父类的方法
	@Override
	public int calc(int a, int b) {
		return a + b;
	}
}