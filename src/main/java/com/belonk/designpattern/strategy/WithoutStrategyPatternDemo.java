package com.belonk.designpattern.strategy;

/**
 * Created by sun on 2021/6/7.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class WithoutStrategyPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		BackhomeService backhomeService = new BackhomeService();
		backhomeService.backHome(BackhomeService.BUS);
	}
}

class BackhomeService {
	// 地铁
	public static final int RAILWAY = 1;
	public static final int BUS = 2;
	public static final int ONLINE_CAR = 3;
	public static final int DRIVE = 4;

	void backHome(int type) {
		if (type == RAILWAY) {
			System.out.println("乘坐地铁回家");
		} else if (type == BUS) {
			System.out.println("乘坐公交回家");
		} else if (type == ONLINE_CAR) {
			System.out.println("乘坐网约车回家");
		} else if (type == DRIVE) {
			System.out.println("开车回家");
		}
	}
}