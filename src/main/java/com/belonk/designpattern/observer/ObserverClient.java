package com.belonk.designpattern.observer;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ObserverClient {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		// 一个主体
		ConcreteSubject subject = new ConcreteSubject();
		subject.setState("原始状态");
		// 两个观察者
		ConcreteObserver observer1 = new ConcreteObserver(subject);
		ConcreteObserver observer2 = new ConcreteObserver(subject);
		subject.attach(observer1);
		subject.attach(observer2);
		// 状态变化了，通知更新
		subject.setState("状态更改");
		subject.notifyObservers();

		/*
		观察者 0: 主体 [具体观察者] 状态变成了：状态更改
		观察者 1: 主体 [具体观察者] 状态变成了：状态更改
		 */
	}
}