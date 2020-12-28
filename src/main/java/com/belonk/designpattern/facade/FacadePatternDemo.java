package com.belonk.designpattern.facade;

/**
 * Created by sun on 2020/12/8.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class FacadePatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		// 案例：智能家居
		SmartHouseKeeper smartHouseKeeper = new SmartHouseKeeper("samy");
		smartHouseKeeper.wakingUp();
		smartHouseKeeper.goodbyeForGoingToWork();
		smartHouseKeeper.welcomeBackHome();
		smartHouseKeeper.goodNightToSleep();
	}
}

// Facade类，管家
class SmartHouseKeeper {
	private final String name;
	private final SmartCurtain smartCurtain = new SmartCurtain();
	private final SmartLight smartLight = new SmartLight();
	private final AirConditioner airConditioner = new AirConditioner();
	private final SmartSoundBox smartSoundBox = new SmartSoundBox();

	public SmartHouseKeeper(String name) {
		this.name = name;
		this.sayHello();
	}

	public void sayHello() {
		System.out.println("你好，小主，我是你的智能语音机器人管家" + this.name + ", 你可以直接跟我语音交流哦！");
	}

	// 叫醒起床
	public void wakingUp() {
		System.out.println("小主，起床时间到了，一天之计在于晨，不要贪睡哦...");
		smartSoundBox.play();
		smartLight.open();
		smartCurtain.open();
	}

	// 出去工作
	public void goodbyeForGoingToWork() {
		System.out.println("小主，距离梦想又近了一步，加油...");
		smartSoundBox.stop();
		airConditioner.close();
		smartLight.close();
	}

	// 回家
	public void welcomeBackHome() {
		System.out.println("小主，工作一天辛苦了，欢迎回家...");
		smartLight.open();
		airConditioner.open();
		smartSoundBox.play();
	}

	// 睡觉
	public void goodNightToSleep() {
		System.out.println("小主，夜深了，早点休息哦...");
		smartCurtain.close();
		smartSoundBox.stop();
		smartLight.close();
	}
}

// 窗帘
class SmartCurtain {
	public void open() {
		System.out.println("打开窗帘");
	}

	public void close() {
		System.out.println("关闭窗帘");
	}
}

// 灯光
class SmartLight {
	public void open() {
		System.out.println("打开灯光");
	}

	public void close() {
		System.out.println("关闭灯光");
	}
}

// 空调
class AirConditioner {
	public void open() {
		System.out.println("打开空调");
	}

	public void close() {
		System.out.println("关闭空调");
	}
}

// 智能音响
class SmartSoundBox {
	public void play() {
		System.out.println("播放音乐");
	}

	public void stop() {
		System.out.println("停止播放音乐");
	}
}
