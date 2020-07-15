package com.belonk.designpattern.prototype;

/**
 * Created by sun on 2020/7/14.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class BasicPrototypeDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) throws CloneNotSupportedException {
		// 猴王能够分身成多个猴子
		// 猴王本体，原型对象，基于该原型对象来创建复制对象
		MonkeyKing wukong = new MonkeyKing();
		wukong.setName("孙悟空");
		wukong.setAddress("花果山");
		wukong.setSkillStrength(MonkeyKing.HIGH_SKILL_STRENGTH);
		wukong.setLifetime(Integer.MAX_VALUE);
		System.out.println("大圣归来：" + wukong);
		System.out.println("====================");

		// 现在要分身，创建10个，假设除了技能强度不一致，其他属性完全一致
		for (int i = 0; i < 10; i++) {
			// 调用原型对象的clone方法实现对象复制
			MonkeyKing replicaMonkey = wukong.clone();
			replicaMonkey.setSkillStrength(MonkeyKing.NORMAL_SKILL_STRENGTH);
			System.out.println("分身创建了第 " + i + " 只猴子猴孙：" + replicaMonkey);
		}
	}
}

class MonkeyKing implements Cloneable {
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

	/**
	 * 按照约定，实现Cloneable接口的类需要覆盖Object的clone方法，实现自身clone逻辑
	 *
	 * @return 复制的对象
	 * @throws CloneNotSupportedException 未实现Cloneable接口则会抛出该异常
	 */
	@Override
	protected MonkeyKing clone() throws CloneNotSupportedException {
		return (MonkeyKing) super.clone();
	}

	@Override
	public String toString() {
		return "name: " + name + "," +
				"address: " + address + "," +
				"skillStrength: " + skillStrength + "," +
				"lifetime: " + lifetime;
	}
}