package com.belonk.designpattern.factory.simplefactory.bad;

/**
 * Created by sun on 2020/5/26.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NoFactoryPattern {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/**
	 * 需求：店铺订购各种类型的牛奶
	 */
	public static void main(String[] args) {
		Store store = new Store();
		Milk  milk  = store.orderMilk("pure");
		System.out.println("店铺订购了" + milk.getName());
		milk = store.orderMilk("yogurt");
		System.out.println("店铺订购了" + milk.getName());
		milk = store.orderMilk("highCalcium");
		System.out.println("店铺订购了" + milk.getName());

		// 生产鲜奶，无法生产
		milk = store.orderMilk("freshMilk");
		System.out.println("店铺订购了" + milk.getName());
	}
}

/**
 * 这种设计，违背了开闭原则，每次增加生产的牛奶，客户端也要变动
 */
class Store {
	public Milk orderMilk(String name) {
		if ("pure".equals(name)) {
			return new PureMilk();
		} else if ("yogurt".equals(name)) {
			return new Yogurt();
		} else if ("highCalcium".equals(name)) {
			return new HighCalciumMilk();
		} else {
			throw new RuntimeException("无法订购牛奶：" + name);
		}
	}
}

// 牛奶抽象类
abstract class Milk {
	abstract String getName();
}

// 纯牛奶
class PureMilk extends Milk {
	@Override
	String getName() {
		return "纯牛奶";
	}
}

// 酸奶
class Yogurt extends Milk {
	@Override
	String getName() {
		return "酸奶";
	}
}

// 高钙奶
class HighCalciumMilk extends Milk {
	@Override
	String getName() {
		return "高钙奶";
	}
}