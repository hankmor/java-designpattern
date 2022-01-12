package com.belonk.designpattern.memento;

/**
 * 原发器，保存自身某一个时刻的状态，并可以恢复。
 * <p>
 * Created by sun on 2022/1/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class OriginatorWithInnerClass {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private State state;
	private InnerMemento innerMemento;
	// 名称
	private final String name;
	// 称号
	private String title;

	//~ Constructors

	public OriginatorWithInnerClass(String name) {
		this.name = name;
	}

	//~ Methods

	public void createMemento() {
		this.innerMemento = new InnerMemento(this.state);
	}

	public void recover() {
		this.state = this.innerMemento.getState();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return this.name + "[" + this.title + "] : " + this.state.toString();
	}

	private class InnerMemento {
		//~ Static fields/constants/initializer


		//~ Instance fields

		private final State state;

		//~ Constructors

		InnerMemento(State state) {
			this.state = state;
		}

		//~ Methods

		State getState() {
			return state;
		}
	}
}
