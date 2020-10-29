package com.belonk.designpattern.bridge;

/**
 * Created by sun on 2020/10/29.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class BridgePatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		1、需求：手机打电话功能，手机有多个品牌、多个样式，如何设计？
		2、传统方案：采用继承的方式，一个手机抽象类，下边分手机样式继承手机，然后样式下再分各种品牌继承不同的样式，结构如下：
				手机样式：折叠、直板等
				手机品牌：华为、小米、vivo等
   				           手机
				           /   \
					折    叠    直    板
                   /  /   |		|  \   \
				华为 小米 vivo 华为 小米 vivo
				缺点：1、类爆炸，会形成大量的类
					 2、违反单一职责原则：增加手机类型时，下边要增加所有的手机品牌，增加品牌时，每个类型下边都要增加一个品牌
		3、使用桥接模式：
			手机有两个变化维度：样式、品牌，当然，每个手机都有打电话、发短信等功能。如果将品牌和样式分开，将手机先抽象出来，下边实现基本的样式，
			然后将品牌独立开，作为手机功能的实现，这样就可以分为两个维度，每个维度都可以独立变化，且易于扩展，类也不会太多。
		 */

		Phone phone = new FoldedPhone(new HuaweiPhone());
		System.out.println("样式：" + phone.typeName() + ", 打电话：" + phone.call());
		phone = new BarPhone(new XiaomiPhone());
		System.out.println("样式：" + phone.typeName() + ", 打电话：" + phone.call());
	}
}

/*
 * 传统设计方案
 */

// class Phone {
// }
//
// class FoldedPhone extends Phone {
//
// }
//
// class HuaweiFoldedPhone extends FoldedPhone {
//
// }
//
// class XiaomiFoldedPhone extends FoldedPhone {
//
// }

// …… 这里类为非常多，难以维护和扩展

/*
 * 使用桥接模式
 */

// 基础抽象类
abstract class Phone {
	// 手机类型名称
	abstract String typeName();

	// 手机的打电话功能
	abstract String call();

	// 获取手机品牌
	abstract PhoneBrand getBrand();
}

// 折叠手机
class FoldedPhone extends Phone {
	private PhoneBrand phoneBrand;

	// 聚合PhoneBrand，并且通过它实现打电话
	public FoldedPhone(PhoneBrand phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

	@Override
	String typeName() {
		return "折叠";
	}

	@Override
	String call() {
		// 转交给PhoneBrand来打电话
		return this.getBrand().call();
	}

	@Override
	PhoneBrand getBrand() {
		return this.phoneBrand;
	}
}

// 直板手机
class BarPhone extends Phone {
	private PhoneBrand phoneBrand;

	// 聚合PhoneBrand，并且通过它实现打电话
	public BarPhone(PhoneBrand phoneBrand) {
		this.phoneBrand = phoneBrand;
	}

	@Override
	String typeName() {
		return "直板";
	}

	@Override
	String call() {
		// 转交给PhoneBrand来打电话
		return this.getBrand().call();
	}

	@Override
	PhoneBrand getBrand() {
		return this.phoneBrand;
	}
}

// 手机品牌接口
interface PhoneBrand {
	// 获取品牌名称
	String getName();

	// 打电话
	default String call() {
		return "用" + this.getName() + "手机打电话";
	}
}

// 华为手机
class HuaweiPhone implements PhoneBrand {
	@Override
	public String getName() {
		return "华为";
	}
}

// 小米
class XiaomiPhone implements PhoneBrand {
	@Override
	public String getName() {
		return "小米";
	}
}

// Vivo

class VivoPhone implements PhoneBrand {
	@Override
	public String getName() {
		return "Vivo";
	}
}