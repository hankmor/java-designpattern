package com.belonk.designpattern.prototype;

/**
 * 重写clone方法实现深拷贝。
 * <p>
 * 缺点：需要编码实现深拷贝，工作量大
 * <p>
 * Created by sun on 2020/7/14.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class CustomDeepCopyDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) throws CloneNotSupportedException {
		MonkeyKing2 wukong = new MonkeyKing2();
		wukong.setName("孙悟空");
		wukong.setAddress("花果山");
		wukong.setSkillStrength(MonkeyKing.HIGH_SKILL_STRENGTH);
		wukong.setLifetime(Integer.MAX_VALUE);

		Weapon2 weapon = new Weapon2();
		weapon.setName("如意金箍棒");
		weapon.setWeight(15000);
		wukong.setWeapon(weapon);

		System.out.println("大圣归来：" + wukong);
		System.out.println("====================");

		//~ 深拷贝（拷贝整个对象，包括内部对象的引用）
		/*
		 * 深拷贝通常有两种方式：
		 * 1、所有引用对象也实现克隆，并且在clone方法中进行递归拷贝
		 * 2、通过序列化反序列化的方式实现深拷贝
		 */

		//~ 通过对象的层层clone实现深拷贝

		// 现在要分身，创建10个，假设除了技能强度不一致，其他属性完全一致
		for (int i = 0; i < 10; i++) {
			// 调用原型对象的clone方法实现对象复制，这里是深拷贝
			MonkeyKing2 replicaMonkey = wukong.clone();
			// 假设复制的猴子的武器要轻一些, 修改重量
			// 修改过后，原型实例的武器重量不会改变
			replicaMonkey.getWeapon().setWeight(10000);
			// System.out.println(wukong);
			replicaMonkey.setSkillStrength(MonkeyKing.NORMAL_SKILL_STRENGTH);
			System.out.println("分身创建了第 " + i + " 只猴子猴孙：" + replicaMonkey);
		}
	}
}

// 武器对象，也实现克隆
class Weapon2 implements Cloneable {
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class MonkeyKing2 implements Cloneable {
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
	private Weapon2 weapon;

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

	public Weapon2 getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon2 weapon) {
		this.weapon = weapon;
	}

	/**
	 * 按照约定，实现Cloneable接口的类需要覆盖Object的clone方法，实现自身clone逻辑
	 *
	 * @return 复制的对象
	 * @throws CloneNotSupportedException 未实现Cloneable接口则会抛出该异常
	 */
	@Override
	protected MonkeyKing2 clone() throws CloneNotSupportedException {
		MonkeyKing2 monkeyKing = (MonkeyKing2) super.clone();
		// 调用Weapon2对象的clone方法，拷贝一个新对象
		Weapon2 weapon       = monkeyKing.getWeapon();
		Weapon2 clonedWeapon = (Weapon2) weapon.clone();
		// 将新的Weapon2对象设置给复制的monkeyKing
		monkeyKing.setWeapon(clonedWeapon);
		return monkeyKing;
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