package com.belonk.designpattern.memento;

/**
 * 原发器，保存自身某一个时刻的状态，并可以恢复。
 * <p>
 * Created by sun on 2022/1/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class Originator {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private State state;

	//~ Constructors


	//~ Methods

	public Memento createMemento() {
		return new Memento(this.state);
	}

	public void recover(Memento memento) {
		this.state = memento.getState();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return this.state.toString();
	}
}
