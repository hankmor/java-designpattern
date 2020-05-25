package com.belonk.designpattern.principle.ocp.bad;

/**
 * Created by sun on 2020/5/25.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NotOpenClosedPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		Client client = new Client();
		client.sound(1);
		client.sound(2);
		client.sound(3);
	}
}

// 客户端
class Client {
	// 听动物的叫声
	// 问题：每次新添加动物，都需要更改客户端代码，未被了开闭原则
	public void sound(int type) {
		if (type == 1) {
			new Bird().call();
		} else if (type == 2) {
			new Dog().call();
		} else if (type == 3) {
			new Cat().call();
		}
		// ……
	}
}

// 小鸟
class Bird {
	public void call() {
		System.out.println("小鸟叫声叽叽");
	}
}

// 小狗
class Dog {
	public void call() {
		System.out.println("小狗叫声汪汪");
	}
}

// 小猫
class Cat {
	public void call() {
		System.out.println("小猫叫声喵喵");
	}
}