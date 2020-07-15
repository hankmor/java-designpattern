package com.belonk.designpattern.prototype;

import java.io.*;

/**
 * 通过序列化实现对象的深拷贝，被序列的每个对象（包括引用的对象）都需要实现{@link Serializable}接口。
 * <p>
 * 深拷贝通常有两种方式：
 * 1、所有引用对象也实现克隆，并且在clone方法中进行递归拷贝
 * 2、通过序列化反序列化的方式实现深拷贝（推荐的方式）
 * <p>
 * Created by sun on 2020/7/14.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class SerializeDeepCopyDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) throws CloneNotSupportedException {
		MonkeyKing3 wukong = new MonkeyKing3();
		wukong.setName("孙悟空");
		wukong.setAddress("花果山");
		wukong.setSkillStrength(MonkeyKing.HIGH_SKILL_STRENGTH);
		wukong.setLifetime(Integer.MAX_VALUE);

		Weapon3 weapon = new Weapon3();
		weapon.setName("如意金箍棒");
		weapon.setWeight(15000);
		wukong.setWeapon(weapon);

		System.out.println("大圣归来：" + wukong);
		System.out.println("====================");

		//~ 深拷贝（拷贝整个对象，包括内部对象的引用）

		// 现在要分身，创建10个，假设除了技能强度不一致，其他属性完全一致
		for (int i = 0; i < 10; i++) {
			// 调用原型对象的clone方法实现对象复制，这里是深拷贝
			MonkeyKing3 replicaMonkey = wukong.clone();
			// 假设复制的猴子的武器要轻一些, 修改重量
			// 修改过后，原型实例的武器重量不会改变
			replicaMonkey.getWeapon().setWeight(10000);
			System.out.println(wukong);
			replicaMonkey.setSkillStrength(MonkeyKing.NORMAL_SKILL_STRENGTH);
			System.out.println("分身创建了第 " + i + " 只猴子猴孙：" + replicaMonkey);
		}
	}
}

// 武器对象，也实现克隆
class Weapon3 implements Serializable {
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

class MonkeyKing3 implements Serializable, Cloneable {
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
	private Weapon3 weapon;

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

	public Weapon3 getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon3 weapon) {
		this.weapon = weapon;
	}

	/**
	 * 通过序列化实现对象的深拷贝。
	 *
	 * @return 复制的对象
	 */
	@Override
	protected MonkeyKing3 clone() {
		ByteArrayInputStream  bis = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream    oos = null;
		ObjectInputStream     ois = null;
		try {
			// 序列化当前对象
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);

			// 反序列化对象，此时的对象已经是深拷贝对象了
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			return (MonkeyKing3) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (oos != null) {
					oos.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
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