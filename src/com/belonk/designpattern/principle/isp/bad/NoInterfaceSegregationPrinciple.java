package com.belonk.designpattern.principle.isp.bad;

/**
 * Created by sun on 2020/5/23.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NoInterfaceSegregationPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		WildGoose wildGoose = new WildGoose();
		wildGoose.fly();
		// 调用该方法会产生逻辑错误，既然如此就不应该提供该方法
		// wildGoose.swimInWater(); // are you sure？

		Dog dog = new Dog();
		// dog.fly();// that's true？
		dog.runOnLand();
		// dog.swimInWater(); // maybe

		Fish fish = new Fish();
		// fish.fly(); // the fly-fish?
		// fish.runOnLand(); // maybe
		fish.swimInWater();

		Tortoise tortoise = new Tortoise();
		// tortoise.fly();// that's true?
		tortoise.runOnLand();
		tortoise.swimInWater();
	}
}

/**
 * 现在的设计，未遵守接口隔离原则，每个实现Animal接口的类，都可能需要实现接口定义的每一个方法，或者都可以调用接口的每一个方法。
 * 但是某些类只需要用到接口的很少几个方法。
 * <p>
 * 这里，Animal对于其实现类而言，都不是最小接口
 */
interface Animal {
	// 获取动物名称
	String getName();

	// 飞行
	default void fly() {
		System.out.println(getName() + "能够飞行");
	}

	// 陆行
	default void runOnLand() {
		System.out.println(getName() + "能在陆地上跑");
	}

	// 游水
	default void swimInWater() {
		System.out.println(getName() + "能在水中游");
	}
}

// 大雁，假设大雁仅能飞行，那么runOnLand、swimInWater方法对于它而言没有用处
class WildGoose implements Animal {
	@Override
	public String getName() {
		return "大雁";
	}
}

// 狗，假设狗仅能陆行，那么fly、swimInWater方法对于它而言没有用处
class Dog implements Animal {
	@Override
	public String getName() {
		return "狗";
	}
}

// 鱼，假设鱼仅能在水中，那么fly、runOnLand方法对于它而言没有用处
class Fish implements Animal {
	@Override
	public String getName() {
		return "鱼";
	}
}

// 乌龟，乌龟既能陆行，也能游水，那么fly方法对于它而言没有用处
class Tortoise implements Animal {
	@Override
	public String getName() {
		return "乌龟";
	}
}