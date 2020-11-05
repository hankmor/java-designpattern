package com.belonk.designpattern.decorator;

/**
 * Created by sun on 2020/11/5.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class DecoratorDemo2 {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		 * 案例：大头去面馆吃面，由于大头饭量大，面没吃完觉得不够，有点了两个卤蛋，一会儿再叫了一份青菜，最后时刻又加了一碗豆浆。面我们
		 *      称为主食，必须要点，其他称为小吃，可以点可不点，假如面的价格是8元，卤蛋2元一个，青菜5元一份，豆浆3元一碗，现在要计算总
		 *      共价格，如何设计？
		 */

		System.out.println("大头来到面馆吃面...");
		System.out.println("第一版：");
		NoodleRestaurant noodleRestaurant = new NoodleRestaurant();
		noodleRestaurant.orderNoodles(1);
		noodleRestaurant.addEggs(2);
		noodleRestaurant.addVegetables(1);
		noodleRestaurant.addSoySauce(1);
		System.out.println("大头总共花费：" + noodleRestaurant.getTotalPrice() + "元");

		System.out.println("第二版：");
		// 点了一碗面
		Noodle noodle = new Noodle();
		// 加两个鸡蛋
		Egg egg = new Egg(noodle, 2);
		// 加一份青菜
		Vegetable vegetable = new Vegetable(egg);
		// 加一份豆浆
		SoySauce soySauce = new SoySauce(vegetable);
		// 计算价格
		int cost = soySauce.cost();
		System.out.println("大头总共花费：" + cost + "元");
	}

}

// 最容易想到的方式
// 如果要增加其他小吃，需要修改原代码，不可取，违背开闭原则
@Deprecated
class NoodleRestaurant {
	private int totalPrice;

	void orderNoodles(int count) {
		System.out.println("点了" + count + "份面");
		totalPrice += 8 * count;
	}

	void addEggs(int count) {
		System.out.println("点了" + count + "份鸡蛋");
		totalPrice += 2 * count;
	}

	void addVegetables(int count) {
		System.out.println("点了" + count + "份青菜");
		totalPrice += 5 * count;
	}

	void addSoySauce(int count) {
		System.out.println("点了" + count + "份豆浆");
		totalPrice += 3 * count;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
}


/*
 食物构件，计算食物的价格
 */

// 抽象构件：食物
interface Food {
	// 计算食物的价格
	int cost();
}

// 主食：面条
class Noodle implements Food {
	private int count = 1;

	public Noodle() {
		System.out.println("点了1份面");
	}

	public Noodle(int count) {
		System.out.println("点了" + count + "份面");
		this.count = count;
	}

	// 价格
	@Override
	public int cost() {
		return 8 * this.count;
	}
}

/*
装饰器，将附属的小吃添加到主食中
 */

abstract class FoodDecorator implements Food {
	protected Food food;

	public FoodDecorator(Food food) {
		this.food = food;
	}

	@Override
	public int cost() {
		return food.cost();
	}
}

// 卤蛋
class Egg extends FoodDecorator {
	private int count = 1;

	public Egg(Food food) {
		super(food);
		System.out.println("点了" + count + "份鸡蛋");
	}

	public Egg(Food food, int count) {
		super(food);
		System.out.println("点了" + count + "份鸡蛋");
		this.count = count;
	}

	@Override
	public int cost() {
		return super.cost() + 2 * this.count;
	}
}

// 青菜
class Vegetable extends FoodDecorator {
	private int count = 1;

	public Vegetable(Food food) {
		super(food);
		System.out.println("点了" + count + "份青菜");
	}

	public Vegetable(Food food, int count) {
		super(food);
		System.out.println("点了" + count + "份青菜");
		this.count = count;
	}

	@Override
	public int cost() {
		return super.cost() + 5 * this.count;
	}
}

// 豆浆
class SoySauce extends FoodDecorator {
	private int count = 1;

	public SoySauce(Food food) {
		super(food);
		System.out.println("点了" + count + "份豆浆");
	}

	public SoySauce(Food food, int count) {
		super(food);
		System.out.println("点了" + count + "份豆浆");
		this.count = count;
	}

	@Override
	public int cost() {
		return super.cost() + 3 * count;
	}
}