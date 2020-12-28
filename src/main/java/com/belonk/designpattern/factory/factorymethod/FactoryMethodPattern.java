package com.belonk.designpattern.factory.factorymethod;

/**
 * Created by sun on 2020/6/5.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class FactoryMethodPattern {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		Store store = new Store();
		// 买纯牛奶
		store.setMilkFactory(new PureMilkFactory());
		store.sale();

		// 买酸奶
		store.setMilkFactory(new YogurtFactory());
		store.sale();

		// 买高钙奶
		store.setMilkFactory(new HighCalciumMilkFactory());
		store.sale();
	}
}

// 商店

class Store {
	private MilkFactory milkFactory;

	public Milk sale() {
		System.out.println("顾客购买牛奶");
		System.out.println("  > 生产牛奶");
		Milk milk = milkFactory.createMilk();
		System.out.println("  > 收款");
		System.out.println("  > 拿货");
		System.out.println("成功售出了" + milk.getName());
		return milk;
	}

	public void setMilkFactory(MilkFactory milkFactory) {
		this.milkFactory = milkFactory;
	}
}

// 产品 ============

// 抽象产品
interface Milk {
	String getName();
}

// 纯牛奶
class PureMilk implements Milk {
	@Override
	public String getName() {
		return "伊利纯牛奶";
	}
}

// 酸奶
class Yogurt implements Milk {
	@Override
	public String getName() {
		return "伊利酸奶";
	}
}

// 高钙奶
class HighCalciumMilk implements Milk {
	@Override
	public String getName() {
		return "伊利高钙奶";
	}
}

// 工厂类 ===========

// 抽象工厂

interface MilkFactory {
	Milk createMilk();
}

class PureMilkFactory implements MilkFactory {
	@Override
	public Milk createMilk() {
		return new PureMilk();
	}
}

class YogurtFactory implements MilkFactory {
	@Override
	public Milk createMilk() {
		return new Yogurt();
	}
}

class HighCalciumMilkFactory implements MilkFactory {
	@Override
	public Milk createMilk() {
		return new HighCalciumMilk();
	}
}