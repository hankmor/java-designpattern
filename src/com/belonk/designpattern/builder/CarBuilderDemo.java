package com.belonk.designpattern.builder;

/**
 * 建造者模式，解决复杂对象创建过程，将创建过程进行抽象，产品与创建过程分离，以满足不同产品的相似创建过程的需求。
 * <p>
 * 优点：
 * 1、各个具体的建造者相互独立，有利于系统的扩展。
 * 2、客户端不必知道产品内部组成的细节，便于控制细节风险。
 * <p>
 * 缺点：
 * 1、产品的组成部分必须相同，这限制了其使用范围。
 * 2、如果产品的内部变化复杂，该模式会增加很多的建造者类。
 * <p>
 * 四个角色：
 * 1、产品(Product：包含多个组成部件的复杂对象，由具体建造者来创建其各个滅部件
 * 2、抽象建造者（Builder）：产品创建过程的抽象，包含创建所需的各个产品部件的抽象方法
 * 3、具体建造者（Concrete Builder）：继承（或实现）抽象建造者，实现具体的产品部件创建方法
 * 4、指挥者（Director）：调用建造者的部件创建方法，完成产品的组装
 * <p>
 * Created by sun on 2020/8/17.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class CarBuilderDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	// 客户端
	public static void main(String[] args) {
		// 国产车间，开始组装纯国产汽车
		ChineseCarWorkShop chineseCarWorkShop = new ChineseCarWorkShop();
		CarDirector carDirector = new CarDirector(chineseCarWorkShop);
		Car chineseCar = carDirector.buildCar();
		System.out.println(chineseCar);

		// 国外车间，组装进口汽车
		ForeignCarWorkShop foreignCarWorkShop = new ForeignCarWorkShop();
		carDirector = new CarDirector(foreignCarWorkShop);
		Car importCar = carDirector.buildCar();
		System.out.println(importCar);

		// 基于接口构建器
		ChineseCarWorkShop1 chineseCarWorkShop1 = new ChineseCarWorkShop1();
		CarDirector1 carDirector1 = new CarDirector1(chineseCarWorkShop1);
		Car car = carDirector1.buildCar();
		System.out.println(car);
	}
}

// 产品
class Car {
	// 发动机
	private String motor;
	// 变速箱
	private String gearbox;
	// 底盘
	private String chassis;
	// 车架
	private String frame;

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	@Override
	public String toString() {
		return "Car{" +
				"motor='" + motor + '\'' +
				", gearbox='" + gearbox + '\'' +
				", chassis='" + chassis + '\'' +
				", frame='" + frame + '\'' +
				'}';
	}
}

// 抽象构建器
abstract class CarBuilder {
	protected Car car = new Car();

	abstract void buildMotor();

	abstract void buildGearbox();

	abstract void buildChassis();

	abstract void buildFrame();

	public Car build() {
		return car;
	}
}

// 具体构建器，国产汽车车间
class ChineseCarWorkShop extends CarBuilder {
	@Override
	public void buildMotor() {
		car.setMotor("国产发动机");
	}

	@Override
	public void buildGearbox() {
		car.setGearbox("国产变速箱");
	}

	@Override
	public void buildChassis() {
		car.setChassis("国产底盘");
	}

	@Override
	public void buildFrame() {
		car.setFrame("国产车架");
	}
}

// 具体构建器，国外汽车车间
class ForeignCarWorkShop extends CarBuilder {
	@Override
	public void buildMotor() {
		car.setMotor("进口发动机");
	}

	@Override
	public void buildGearbox() {
		car.setGearbox("进口变速箱");
	}

	@Override
	public void buildChassis() {
		car.setChassis("进口底盘");
	}

	@Override
	public void buildFrame() {
		car.setFrame("进口车架");
	}
}

// 指挥者
class CarDirector {
	private CarBuilder carBuilder;

	public CarDirector(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	public void setCarBuilder(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	// 指挥者决定最终如何组装产品
	public Car buildCar() {
		// 组装底盘
		carBuilder.buildChassis();
		// 组装变速箱
		carBuilder.buildGearbox();
		// 组装发动起
		carBuilder.buildMotor();
		// 组装车架
		carBuilder.buildFrame();
		return carBuilder.build();
	}
}

//===== 抽象构建器为接口

// 抽象构建器
interface ICarBuilder {
	void buildMotor();

	void buildGearbox();

	void buildChassis();

	void buildFrame();

	Car build();
}

class CarDirector1 {
	private ICarBuilder carBuilder;

	public CarDirector1(ICarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	public void setCarBuilder(ICarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	// 指挥者决定最终如何组装产品
	public Car buildCar() {
		// 组装底盘
		carBuilder.buildChassis();
		// 组装变速箱
		carBuilder.buildGearbox();
		// 组装发动起
		carBuilder.buildMotor();
		// 组装车架
		carBuilder.buildFrame();
		return carBuilder.build();
	}
}

class ChineseCarWorkShop1 implements ICarBuilder {
	private Car car;

	public ChineseCarWorkShop1() {
		this.car = new Car();
	}

	@Override
	public void buildMotor() {
		car.setMotor("国产发动机");
	}

	@Override
	public void buildGearbox() {
		car.setGearbox("国产变速箱");
	}

	@Override
	public void buildChassis() {
		car.setChassis("国产底盘");
	}

	@Override
	public void buildFrame() {
		car.setFrame("国产车架");
	}

	@Override
	public Car build() {
		return car;
	}
}