package com.belonk.designpattern.principle.srp.bad;

/**
 * 未遵守单一职责原则，一个类负责多个事情。
 * <p>
 * Created by sun on 2020/5/23.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NotSingleResponsibility {
	public static void main(String[] args) {
		// 小鸟可以飞行
		Bird bird = new Bird();
		bird.fly();
		// 大雁可以飞行
		WildGoose wildGoose = new WildGoose();
		wildGoose.fly();
		// 狗不能飞行，但是狗也具有fly方法，如果调用者调用fly，则会出现逻辑错误
		Dog dog = new Dog();
		dog.runOnLand();
		// 逻辑错误
		// dog.fly();
		// dog.swimInWater();
		// 鱼可以在水中游
		Fish fish = new Fish();
		fish.swimInWater();
		// 乌龟既可以在水中游，也可以在陆地上跑
		Tortoise tortoise = new Tortoise();
		tortoise.runOnLand();
		tortoise.swimInWater();
		// 但是乌龟不能飞行，调用会导致逻辑错误
		// tortoise.fly();
	}
}

// 一个类负责动物的飞行方法
abstract class Animal {
	public void fly() {
		System.out.println(getName() + "能够飞行");
	}

	public void runOnLand() {
		System.out.println(getName() + "能在陆地上跑");
	}

	public void swimInWater() {
		System.out.println(getName() + "能在水中游");
	}

	protected abstract String getName();
}

// 小鸟
class Bird extends Animal {
	@Override
	public String getName() {
		return "小鸟";
	}
}

// 大雁
class WildGoose extends Animal {
	@Override
	public String getName() {
		return "大雁";
	}
}

// 狗
class Dog extends Animal {
	@Override
	public String getName() {
		return "狗";
	}
}

// 鱼
class Fish extends Animal {
	@Override
	protected String getName() {
		return "鱼";
	}
}

// 乌龟
class Tortoise extends Animal {
	@Override
	protected String getName() {
		return "乌龟";
	}
}