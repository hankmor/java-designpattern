package com.belonk.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题
 * <p>
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public abstract class Subject implements Observable {
	//~ Static fields/constants/initializer

	private static final List<Observer> OBSERVERS = new ArrayList<>();

	//~ Instance fields


	//~ Constructors


	//~ Methods

	@Override
	public void attach(Observer observer) {
		OBSERVERS.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		OBSERVERS.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : OBSERVERS) {
			observer.update();
		}
	}

	public abstract String name();

	@Override
	public long count() {
		return OBSERVERS.size();
	}
}