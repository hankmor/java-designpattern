package com.belonk.designpattern.memento;

/**
 * 备忘录，存储原发器的状态。
 * <p>
 * Created by sun on 2022/1/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class Memento {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private State state;

	//~ Constructors

	public Memento() {
	}

	public Memento(State state) {
		this.state = state;
	}

	//~ Methods

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
