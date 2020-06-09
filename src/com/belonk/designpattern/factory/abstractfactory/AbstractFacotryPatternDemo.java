package com.belonk.designpattern.factory.abstractfactory;

import java.util.Date;

/**
 * Created by sun on 2020/6/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class AbstractFacotryPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		Client client = new Client();

		System.out.println("电器工厂A开始生产……");
		client.setFactory(new ElectricFactoryA());
		Television      blackWhiteTelevision   = client.newTelevision();
		AirConditioning hangingAirConditioning = client.newAirConditioning();
		Fan             dryDesktopFan          = client.newFan();
		System.out.println(blackWhiteTelevision);
		System.out.println(hangingAirConditioning);
		System.out.println(dryDesktopFan);

		System.out.println("电器工厂B开始生产……");
		client.setFactory(new ElectricFactoryB());
		Television      colorTelevision        = client.newTelevision();
		AirConditioning cabinetAirConditioning = client.newAirConditioning();
		Fan             wetDesktopFan          = client.newFan();
		System.out.println(colorTelevision);
		System.out.println(cabinetAirConditioning);
		System.out.println(wetDesktopFan);

		// 新加了同类型产品

		System.out.println("电器工厂C开始生产");
		client.setFactory(new ElectricFactoryC());
		Television      someTelevision         = client.newTelevision();
		AirConditioning centralAirConditioning = client.newAirConditioning();
		Fan             wetStandingFan         = client.newFan();
		System.out.println(someTelevision);
		System.out.println(centralAirConditioning);
		System.out.println(wetStandingFan);
	}
}

class Client {
	private ElectricFactory factory;

	// 生产电视
	public Television newTelevision() {
		return factory.createTelevision();
	}

	// 生产空调
	public AirConditioning newAirConditioning() {
		return factory.createAirConditioning();
	}

	// === 产品簇新添加了新产品

	// 生产风扇
	public Fan newFan() {
		return factory.createFan();
	}

	public void setFactory(ElectricFactory factory) {
		this.factory = factory;
	}
}

// 顶层抽象工厂：电器生产工厂
interface ElectricFactory {
	// 生产电视
	Television createTelevision();

	// 生产空调
	AirConditioning createAirConditioning();

	// === 产品簇新添加了新产品

	// 生产风扇
	Fan createFan();
}

// 抽象产品1：电视机
interface Television {
	int BLACK_WHITE = 1;
	int COLOR       = 2;

	// 类型
	int type();

	// 生产时间
	default Date createTime() {
		return new Date();
	}
}

// 抽象产品2：空调
interface AirConditioning {
	int HANGING = 1;
	int CABINET = 2;

	// 类型
	int type();

	// 生产时间
	default Date createTime() {
		return new Date();
	}
}

// 具体工厂1：生产黑白电视和挂式空调
class ElectricFactoryA implements ElectricFactory {
	@Override
	public Television createTelevision() {
		System.out.println("生产黑白电视");
		return new BlackWhiteTelevision();
	}

	@Override
	public AirConditioning createAirConditioning() {
		System.out.println("生产挂式空调");
		return new HangingAirConditioning();
	}

	@Override
	public Fan createFan() {
		System.out.println("生产干式台式风扇");
		return new DryDesktopFan();
	}
}

// 具体工厂2：生产彩色电视和柜式空调
class ElectricFactoryB implements ElectricFactory {
	@Override
	public Television createTelevision() {
		System.out.println("生产彩色电视");
		return new ColorTelevision();
	}

	@Override
	public AirConditioning createAirConditioning() {
		System.out.println("生产柜式空调");
		return new CabinetAirConditioning();
	}

	@Override
	public Fan createFan() {
		System.out.println("生产加湿台式风扇");
		return new WetDesktopFan();
	}
}

// 具体产品：黑白电视
class BlackWhiteTelevision implements Television {
	@Override
	public int type() {
		return BLACK_WHITE;
	}

	@Override
	public String toString() {
		return "黑白电视机，生产时间：" + createTime();
	}
}

// 具体产品：彩色电视
class ColorTelevision implements Television {
	@Override
	public int type() {
		return COLOR;
	}

	@Override
	public String toString() {
		return "彩色电视机，生产时间：" + createTime();
	}
}

// 具体产品：挂式空调
class HangingAirConditioning implements AirConditioning {
	@Override
	public int type() {
		return HANGING;
	}

	@Override
	public String toString() {
		return "挂式空调，生产时间：" + createTime();
	}
}

// 具体产品：柜式空调
class CabinetAirConditioning implements AirConditioning {
	@Override
	public int type() {
		return CABINET;
	}

	@Override
	public String toString() {
		return "柜式空调，生产时间：" + createTime();
	}
}

// === 新增同类型产品，源代码不修改，只需要新加具体产品和具体工厂

// 新产品：中央空调
class CentralAirConditioning implements AirConditioning {
	@Override
	public int type() {
		return 3;
	}

	@Override
	public String toString() {
		return "中央空调，生产时间：" + createTime();
	}
}

class ElectricFactoryC implements ElectricFactory {
	@Override
	public Television createTelevision() {
		System.out.println("此工厂暂时不生产电视");
		return null;
	}

	@Override
	public AirConditioning createAirConditioning() {
		System.out.println("生产中央空调");
		return new CentralAirConditioning();
	}

	@Override
	public Fan createFan() {
		System.out.println("生产加湿立式风扇");
		return new WetStandingFan();
	}
}

// === 产品簇中添加新产品，那么原来的工厂需要新添加生产方法

// 新增新产品：电风扇
interface Fan {
	int type();

	default Date createTime() {
		return new Date();
	}

	// 加湿功能
	boolean canWet();
}

// 台式不带加湿功能的风扇
class DryDesktopFan implements Fan {
	@Override
	public int type() {
		return 1;
	}

	@Override
	public boolean canWet() {
		return false;
	}

	@Override
	public String toString() {
		return "干式台式风扇，生产时间：" + createTime();
	}
}

// 台式带加湿功能的风扇
class WetDesktopFan implements Fan {
	@Override
	public int type() {
		return 2;
	}

	@Override
	public boolean canWet() {
		return true;
	}

	@Override
	public String toString() {
		return "加湿台式风扇，生产时间：" + createTime();
	}
}

// 加湿立式风扇
class WetStandingFan implements Fan {
	@Override
	public int type() {
		return 3;
	}

	@Override
	public boolean canWet() {
		return true;
	}

	@Override
	public String toString() {
		return "加湿立式风扇，生产时间：" + createTime();
	}
}