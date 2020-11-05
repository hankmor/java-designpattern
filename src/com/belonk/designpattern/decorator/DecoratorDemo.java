package com.belonk.designpattern.decorator;

/**
 * Created by sun on 2020/11/5.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class DecoratorDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		 * 案例：物品的包装，贵重物品需要防止磕碰，内部要填充泡沫、充气袋等东西，非贵重物品如衣服等，可以简易包装
		 *
		 * 装饰模式：
		 *      四个角色：构件，实现原有的功能，包括抽象构件、具体构件；装饰器，扩展原有构件的功能，包括抽象装饰器、具体装饰器
		 *      抽象构件不需要知道装饰器的存在，客户端知道并使用装饰器即可
		 */

		System.out.println("商家打包一件衣服，不值钱，简单包装了事...");
		Clothes clothes = new Clothes();
		// 直接放入塑料袋就可以了
		PlasticBag plasticBag = new PlasticBag(clothes);
		plasticBag.display();

		System.out.println("商家打包一台电脑，有点贵，还是做个良心商家好好包装一番...");
		Computer computer = new Computer();
		// 先用充气袋填充
		DunnageBag dunnageBag = new DunnageBag(computer);
		// 再用泡沫材料填充
		FoamMaterial foamMaterial = new FoamMaterial(dunnageBag);
		// 最后在装入纸箱，完成
		Carton carton = new Carton(foamMaterial);
		carton.display();
	}
}

//// 原有组件

// 物品接口
interface Item {
	void display();
}

// 电脑
class Computer implements Item {
	@Override
	public void display() {
		System.out.println("一台电脑");
	}
}

// 衣服
class Clothes implements Item {
	@Override
	public void display() {
		System.out.println("一件衣服");
	}
}

//// 装饰器

// 快递包装，装饰者
abstract class GoodsDecorator implements Item {
	// 被装饰者
	protected Item item;

	public GoodsDecorator(Item item) {
		this.item = item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public void display() {
		this.item.display();
		this.wrap();
	}

	// 包装快递
	protected abstract void wrap();
}

// 塑料袋
class PlasticBag extends GoodsDecorator {
	public PlasticBag(Item item) {
		super(item);
	}

	@Override
	protected void wrap() {
		System.out.println("装入塑料袋");
	}
}

// 泡沫材料
class FoamMaterial extends GoodsDecorator {
	public FoamMaterial(Item item) {
		super(item);
	}

	@Override
	protected void wrap() {
		System.out.println("填充泡沫材料");
	}
}

// 纸板箱
class Carton extends GoodsDecorator {
	public Carton(Item item) {
		super(item);
	}

	@Override
	protected void wrap() {
		System.out.println("装入纸箱");
	}
}

// 充气袋
class DunnageBag extends GoodsDecorator {
	public DunnageBag(Item item) {
		super(item);
	}

	@Override
	protected void wrap() {
		System.out.println("填充充气袋");
	}
}