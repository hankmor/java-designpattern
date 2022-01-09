package com.belonk.designpattern.observer;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public interface Observable {
	//~ Constants/Initializer


	//~ Interfaces

	void attach(Observer observer);

	void detach(Observer observer);

	void notifyObservers();

	long count();
}
