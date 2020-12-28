package com.belonk.designpattern.prototype.bad;

/**
 * Created by sun on 2020/7/14.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NoPrototypePatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		// 猴王能够分身成多个猴子
		// 猴王本体
		MonkeyKing wukong = new MonkeyKing();
		wukong.setName("孙悟空");
		wukong.setAddress("花果山");
		wukong.setSkillStrength(MonkeyKing.HIGH_SKILL_STRENGTH);
		wukong.setLifetime(Integer.MAX_VALUE);
		System.out.println("大圣归来：" + wukong);
		System.out.println("====================");

		// 现在要分身，创建10个，假设除了技能强度不一致，其他属性完全一致
		for (int i = 0; i < 10; i++) {
			MonkeyKing replicaMonkey = new MonkeyKing();
			replicaMonkey.setName("孙悟空");
			replicaMonkey.setAddress("花果山");
			replicaMonkey.setSkillStrength(MonkeyKing.NORMAL_SKILL_STRENGTH);
			replicaMonkey.setLifetime(Integer.MAX_VALUE);
			System.out.println("分身创建了第 " + i + " 只猴子猴孙：" + replicaMonkey);
		}

		/*
		 这种方式的问题：
		 1、相同的属性，都需要设置一次值
		 2、需要重新创建和初始化对象，效率较低
		 3、对象运行时的状态无法获取
		 4、原型对象改动某个属性，所有新创建的复制对象都需要更改
		 */

	}
}

class MonkeyKing {
	// 高强度
	static int HIGH_SKILL_STRENGTH   = 10;
	// 普通强度
	static int NORMAL_SKILL_STRENGTH = 5;

	// 姓名
	private String name;
	// 地址
	private String address;
	// 能力强度
	private int    skillStrength;
	// 寿命
	private int    lifetime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSkillStrength() {
		return skillStrength;
	}

	public void setSkillStrength(int skillStrength) {
		this.skillStrength = skillStrength;
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	@Override
	public String toString() {
		return "name: " + name + "," +
				"address: " + address + "," +
				"skillStrength: " + skillStrength + "," +
				"lifetime: " + lifetime;
	}
}