package com.belonk.designpattern.principle.isp;

/**
 * Created by sun on 2020/5/23.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class InterfaceSegregationPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		WildGoose wildGoose = new WildGoose();
		wildGoose.fly();

		Dog dog = new Dog();
		dog.runOnLand();

		Fish fish = new Fish();
		fish.swimInWater();

		Tortoise tortoise = new Tortoise();
		tortoise.runOnLand();
		tortoise.swimInWater();
	}
}

/**
 * 接口隔离原则：类对于其他类的依赖应该建立在最小接口上。
 * <p>
 * 接口拆分，将Animal接口进行拆分，使得实现类依赖最小接口。
 */
interface Animal {
	// 获取动物名称
	String getName();
}

// 飞行动物
interface FlyAnimal extends Animal {
	// 飞行
	default void fly() {
		System.out.println(getName() + "能够飞行");
	}
}

// 陆生动物
interface LandAnimal extends Animal {
	// 陆行
	default void runOnLand() {
		System.out.println(getName() + "能在陆地上跑");
	}
}

// 水生动物
interface WaterAnimal extends Animal {
	// 游水
	default void swimInWater() {
		System.out.println(getName() + "能在水中游");
	}
}

// 两栖动物
interface AmphibiousAnimal extends LandAnimal, WaterAnimal {

}

// 大雁
class WildGoose implements FlyAnimal {
	@Override
	public String getName() {
		return "大雁";
	}
}

// 狗
class Dog implements LandAnimal {
	@Override
	public String getName() {
		return "狗";
	}
}

// 鱼
class Fish implements WaterAnimal {
	@Override
	public String getName() {
		return "鱼";
	}
}

// 乌龟
class Tortoise implements AmphibiousAnimal {
	@Override
	public String getName() {
		return "乌龟";
	}
}