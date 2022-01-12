package com.belonk.designpattern.memento;

/**
 * Created by sun on 2022/1/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public final class State {
	//~ Static fields/constants/initializer


	//~ Instance fields

	// 攻击力
	private final int ack;
	// 防御力
	private final int def;
	// 血量
	private final int hp;
	// 蓝量
	private final int mp;

	//~ Constructors

	public State(int ack, int def, int hp, int mp) {
		this.ack = ack;
		this.def = def;
		this.hp = hp;
		this.mp = mp;
	}

	//~ Methods


	@Override
	public String toString() {
		return "攻击力 " + ack + ", 防御力 " + def + ", 血量 " + hp + ", 蓝量 " + mp;
	}
}
