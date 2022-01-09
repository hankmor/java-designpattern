package com.belonk.designpattern.mediator;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ConcreteMediator implements Mediator {
	//~ Static fields/constants/initializer


	//~ Instance fields

	// 需要知道所有的同事对象
	private ConcreteColleague1 colleague1;
	private ConcreteColleague2 colleague2;

	//~ Constructors


	//~ Methods

	@Override
	public void sendMessage(Colleague colleague, String msg) {
		// 协调不同的同事，使得他们可以间接通信
		if (colleague == colleague1) {
			colleague2.receiveMessage(msg);
		} else if (colleague == colleague2) {
			colleague1.receiveMessage(msg);
		}
	}

	public void setColleague1(ConcreteColleague1 colleague1) {
		this.colleague1 = colleague1;
	}

	public void setColleague2(ConcreteColleague2 colleague2) {
		this.colleague2 = colleague2;
	}
}