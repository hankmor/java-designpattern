package com.belonk.designpattern.principle.ocp;

/**
 * Created by sun on 2020/5/25.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class OpenClosedPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/**
	 * 开闭原则：软件的模块、类、方法等应该对自身扩展开放，对客户端修改关闭。即：自身可扩展，客户端不可修改。
	 */
	public static void main(String[] args) {
		Client client = new Client();
		client.sound(new Bird());
		client.sound(new Dog());
		client.sound(new Cat());
	}
}


// 客户端
class Client {
	// 听动物的叫声，新增动物不影响客户端代码
	public void sound(AnimalCall animal) {
		animal.call();
	}
}

// 功能提供方，提供动物的叫声
abstract class AnimalCall {
	abstract void call();
}

// 小鸟
class Bird extends AnimalCall {
	public void call() {
		System.out.println("小鸟叫声叽叽");
	}
}

// 小狗
class Dog extends AnimalCall {
	public void call() {
		System.out.println("小狗叫声汪汪");
	}
}

// 小猫
class Cat extends AnimalCall {
	public void call() {
		System.out.println("小猫叫声喵喵");
	}
}