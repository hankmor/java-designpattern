package com.belonk.designpattern.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sun on 2021/6/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class CommandPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		命令模式：将一个请求封装为一个对象，从而可以用不同的请求对客户进行参数化，并且可以对请求排队或记录日志，还支持可以撤销的操作。
		命令模式典型案例：餐厅吃饭，服务员点餐，然后记录点的菜品，交给厨师，厨师负责做菜
		 */
		Cook cook = new Cook();
		ConcreteOrderCommand orderCommand = new ConcreteOrderCommand();
		orderCommand.setCook(cook);
		Waiter waiter = new Waiter();
		waiter.setOrderCommand(orderCommand);

		System.out.println("= 客户：服务员，我要开始点菜了...");
		System.out.println("= 服务员：欢迎光临，请点菜，这是菜单");
		waiter.orderService("回锅肉");
		waiter.orderService("青椒土豆丝");
		waiter.orderService("水煮肉片");
		waiter.orderService("蚂蚁上树");
		waiter.orderService("水煮白菜");
		waiter.orderService("翠玉珍珠");
		waiter.orderService("双龙戏珠");
		System.out.println("= 服务员（暗）：猪啊，吃这么多，管他呢，完事！");
		waiter.orderFinished();

		System.out.println("= 客户（暗）：遭了，点多了");
		System.out.println("= 客户：服务员，我要取消这几个菜！");
		waiter.cancelOrder("回锅肉");
		waiter.cancelOrder("蚂蚁上树");
		waiter.cancelOrder("双龙戏珠");
		waiter.cancelFinished();
		System.out.println("= 厨师（暗）：你大爷，做好了又不要，瞎折腾！");
	}
}

// 餐厅服务员
class Waiter {
	private OrderCommand orderCommand;
	private final List<String> names = new ArrayList<>();
	private final List<String> canceledNames = new ArrayList<>();

	public void setOrderCommand(OrderCommand orderCommand) {
		this.orderCommand = orderCommand;
	}

	// 点菜服务
	void orderService(String name) {
		System.out.println("客户点了菜品：" + name);
		names.add(name);
	}

	// 取消点菜
	void cancelOrder(String name) {
		System.out.println("客户取消菜品：" + name);
		canceledNames.add(name);
	}

	// 通知点餐完成
	void orderFinished() {
		System.out.println("点餐完成，交给厨房做菜");
		this.orderCommand.order(names.toArray(new String[]{}));
	}

	// 通知取消点餐
	void cancelFinished() {
		System.out.println("通知厨房客户取消了菜品：" + names);
		this.orderCommand.cancel(canceledNames.toArray(new String[]{}));
	}
}

// 点餐命令
interface OrderCommand {
	// 点餐
	void order(String... names);

	// 取消点餐
	void cancel(String... names);
}

// 具体点餐命令
class ConcreteOrderCommand implements OrderCommand {
	private Cook cook;

	public void setCook(Cook cook) {
		this.cook = cook;
	}

	@Override
	public void order(String... names) {
		// 厨师按顺序做菜
		for (String name : names) {
			this.cook.cooking(name);
		}
	}

	@Override
	public void cancel(String... names) {
		this.cook.knownCancel(names);
	}
}

// 厨师
class Cook {
	void cooking(String name) {
		System.out.println("厨师正在做菜: " + name);
	}

	void knownCancel(String... names) {
		System.out.println("知道客户取消了，不再做：" + Arrays.toString(names));
	}
}

