package com.belonk.designpattern.memento;

/**
 * 原发器，保存自身某一个时刻的状态，并可以恢复。
 * <p>
 * Created by sun on 2022/1/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class PrototypeOriginator implements Cloneable {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private State state;
	// 名称
	private final String name;
	// 称号
	private String title;

	//~ Constructors

	public PrototypeOriginator(String name) {
		this.name = name;
	}

	//~ Methods

	public PrototypeOriginator createMemento() {
		return this.clone();
	}

	public void recover(PrototypeOriginator memento) {
		this.setState(memento.getState());
		this.setTitle(memento.getTitle());
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

	@Override
	protected PrototypeOriginator clone() {
		PrototypeOriginator originator = new PrototypeOriginator(this.name);
		originator.setState(this.getState());
		originator.setTitle(this.getTitle());
		return originator;
	}
}
