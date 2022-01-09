package com.belonk.designpattern.observer;

/**
 * 具体观察者，通常会依赖具体主题对象，通过判断其状态实现不同的通知逻辑。
 * <p>
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ConcreteObserver implements Observer {
	//~ Static fields/constants/initializer

	private static int count = 0;
	private final int id = count++;

	//~ Instance fields

	private ConcreteSubject subject;

	//~ Constructors

	public ConcreteObserver(ConcreteSubject subject) {
		this.subject = subject;
	}


	//~ Methods

	@Override
	public void update() {
		System.out.println("观察者 " + id + ": 主体 [" + this.subject.name() + "] 状态变成了：" + this.subject.getState());
	}

	public ConcreteSubject getSubject() {
		return subject;
	}

	public void setSubject(ConcreteSubject subject) {
		this.subject = subject;
	}
}