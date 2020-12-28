package com.belonk.designpattern.prototype;

/**
 * Created by sun on 2020/7/14.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ShallowCopyDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) throws CloneNotSupportedException {
		MonkeyKing1 wukong = new MonkeyKing1();
		wukong.setName("孙悟空");
		wukong.setAddress("花果山");
		wukong.setSkillStrength(MonkeyKing.HIGH_SKILL_STRENGTH);
		wukong.setLifetime(Integer.MAX_VALUE);

		Weapon1 weapon = new Weapon1();
		weapon.setName("如意金箍棒");
		weapon.setWeight(15000);
		wukong.setWeapon(weapon);

		System.out.println("大圣归来：" + wukong);
		System.out.println("====================");

		//~ 浅拷贝(对象内部对象没有拷贝)

		// 现在要分身，创建10个，假设除了技能强度不一致，其他属性完全一致
		for (int i = 0; i < 10; i++) {
			// 调用原型对象的clone方法实现对象复制
			MonkeyKing1 replicaMonkey = wukong.clone();
			// 假设复制的猴子的武器要轻一些, 修改重量
			// 但是，修改过后，原型实例的武器重量也改变了
			replicaMonkey.getWeapon().setWeight(10000);
			/*
			 * 这是因为引用对象（Weapon）clone的时候其实是引用传递，需改过后所有的引用都会改变
			 * 这就是浅拷贝带来的问题：被拷贝对象内部的对象没有进行拷贝
			 *
			 * Object对象上的clone方法就是浅拷贝实现。
			 */
			// System.out.println(wukong);
			replicaMonkey.setSkillStrength(MonkeyKing.NORMAL_SKILL_STRENGTH);
			System.out.println("分身创建了第 " + i + " 只猴子猴孙：" + replicaMonkey);
		}
	}
}

// 武器对象
class Weapon1 {
	// 名称
	private String name;
	// 重量
	private int    weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "[" +
				"name: '" + name + '\'' +
				", weight: " + weight +
				']';
	}
}

class MonkeyKing1 implements Cloneable {
	// 高强度
	static int HIGH_SKILL_STRENGTH   = 10;
	// 普通强度
	static int NORMAL_SKILL_STRENGTH = 5;

	// 姓名
	private String  name;
	// 地址
	private String  address;
	// 能力强度
	private int     skillStrength;
	// 寿命
	private int     lifetime;
	// 武器
	private Weapon1 weapon;

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

	public Weapon1 getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon1 weapon) {
		this.weapon = weapon;
	}

	/**
	 * 按照约定，实现Cloneable接口的类需要覆盖Object的clone方法，实现自身clone逻辑
	 *
	 * @return 复制的对象
	 * @throws CloneNotSupportedException 未实现Cloneable接口则会抛出该异常
	 */
	@Override
	protected MonkeyKing1 clone() throws CloneNotSupportedException {
		return (MonkeyKing1) super.clone();
	}

	@Override
	public String toString() {
		return "基础信息：[name: " + name + "," +
				"address: " + address + "," +
				"skillStrength: " + skillStrength + "," +
				"lifetime: " + lifetime + "], "
				+ "武器信息：" + weapon.toString();
	}
}