package com.belonk.designpattern.adapter;

/**
 * 适配器模式：将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。
 * 适配器模式分为类适配器模式、对象适配器模式和接口适配器模式三种，类适配器模式类之间的耦合度比后者高，对象适配器模式满足合成复用原
 * 则，对象耦合度低；接口适配器模式作为一种特殊用途，在java8之后已经存在接口默认方法，所以接口适配器模式在旧的框架中使用较多，JAVA8
 * 之后使用较少。
 *
 * <p>
 * 优点：
 * 1、客户端通过适配器可以透明地调用目标接口。
 * 2、复用了现存的类，程序员不需要修改原有代码而重用现有的适配者类。
 * 3、将目标类和适配者类解耦，解决了目标类和适配者类接口不一致的问题
 * <p>
 * 角色：
 * 1、目标（Target）接口：当前系统业务所期待的接口，java中一般为接口；
 * 2、被适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口；
 * 3、适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 * <p>
 * <p>
 * Created by sun on 2020/8/19.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ClassAdapterPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/**
	 * 这里Demo使用类适配器模式：由于适配器采用继承的方式，耦合度较高
	 */
	public static void main(String[] args) {
		Phone phone = new Phone();
		// 给手机充电，手机充电器PhoneCharger适配了DirectCurrent，可以输出直流电
		phone.charging(new PhoneCharger());
	}
}

/*
 * 示例：给手机充电，需要使用手机充电器，将220v的交流电，转换为小于5V的直流电
 */

class Phone {
	/**
	 * 手机充电方法
	 */
	void charging(DirectCurrent directCurrent) {
		int voltage = directCurrent.outputVoltage();
		if (voltage <= 5) {
			System.out.println("正在为手机充电...");
		} else {
			System.out.println("电压过高，小心手机爆炸！");
		}
	}
}

/**
 * 交流电，提供220V电压
 * <p>
 * 被适配者，已经存在的组件，需要将其适配为新的接口
 */
class AlternatingCurrent {
	int outputVoltage() {
		return 220;
	}
}

/**
 * 目标接口，能够提供5V的直流电压
 * <p>
 * 新的所需的接口，与被适配者不能兼容，需要适配处理
 */
interface DirectCurrent {
	int outputVoltage();
}

/**
 * 手机充电器，电源适配器
 * <p>
 * 适配器，转换被适配者为新的目标接口
 */
class PhoneCharger extends AlternatingCurrent implements DirectCurrent {
	@Override
	public int outputVoltage() {
		int voltage = super.outputVoltage();
		// 电压转换处理
		return voltage / 44;
	}
}