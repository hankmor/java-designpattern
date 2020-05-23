package com.belonk.designpattern.principle.singleresponsibility;

/**
 * 单一职责原则：即一个类应该只负责一项职责，如类 A 负责两个不同职责:职责 1，职责 2。
 * 当职责 1 需求变更 而改变 A 时，可能造成职责 2 执行错误， 所以需要将类 A 的粒度分解为 A1，A2
 * <p>
 * Created by sun on 2020/5/23.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class SingleResponsibility {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		// 小鸟可以飞行
		Bird bird = new Bird();
		bird.fly();
		// 大雁可以飞行
		WildGoose wildGoose = new WildGoose();
		wildGoose.fly();
		// 狗能在陆地上跑
		Dog dog = new Dog();
		dog.runOnLand();
		// 鱼可以在水中游
		Fish fish = new Fish();
		fish.swimInWater();
		// 乌龟既可以在水中游，也可以在陆地上跑
		Tortoise tortoise = new Tortoise();
		tortoise.runOnLandAndSwimInWater();
	}
}

abstract class Animal {
	protected abstract String getName();
}

// 飞行动物
abstract class FlyAnimal extends Animal {
	protected void fly() {
		System.out.println(getName() + "能够飞行");
	}
}

// 陆生动物
abstract class LandAnimal extends Animal {
	protected void runOnLand() {
		System.out.println(getName() + "能在陆地上跑");
	}
}

// 水生动物
abstract class WaterAnimal extends Animal {
	protected void swimInWater() {
		System.out.println(getName() + "能在水中游");
	}
}

// 两栖动物
abstract class AmphibiousAnimal extends Animal {
	protected void runOnLandAndSwimInWater() {
		System.out.println(getName() + "既能在陆地跑，也能在水中游");
	}
}

// 小鸟
class Bird extends FlyAnimal {
	@Override
	public String getName() {
		return "小鸟";
	}
}

// 大雁
class WildGoose extends FlyAnimal {
	@Override
	public String getName() {
		return "大雁";
	}
}

// 狗
class Dog extends LandAnimal {
	@Override
	public String getName() {
		return "狗";
	}
}

// 鱼
class Fish extends WaterAnimal {
	@Override
	protected String getName() {
		return "鱼";
	}
}

// 乌龟
class Tortoise extends AmphibiousAnimal {
	@Override
	protected String getName() {
		return "乌龟";
	}
}