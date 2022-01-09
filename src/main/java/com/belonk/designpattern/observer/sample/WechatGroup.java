package com.belonk.designpattern.observer.sample;

import com.belonk.designpattern.observer.Observable;
import com.belonk.designpattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class WechatGroup implements Observable {
	//~ Static fields/constants/initializer

	private static final List<Observer> OBSERVERS = new ArrayList<>();

	//~ Instance fields

	private final String name;
	private String newMessage;

	//~ Constructors

	public WechatGroup(String name) {
		this.name = name;
	}

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

	@Override
	public long count() {
		return OBSERVERS.size();
	}

	public String getName() {
		return name;
	}

	public void receivedNewMessage(String msg) {
		this.newMessage = msg;
		this.notifyObservers();
	}

	public String getNewMessage() {
		return newMessage;
	}
}