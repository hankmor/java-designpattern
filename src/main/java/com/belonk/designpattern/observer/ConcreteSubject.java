package com.belonk.designpattern.observer;

/**
 * 具体主题对象，通常会具有状态属性，状态变化后会通知观察者更新。
 * <p>
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ConcreteSubject extends Subject {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private String state;

	//~ Constructors


	//~ Methods

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String name() {
		return "具体观察者";
	}
}