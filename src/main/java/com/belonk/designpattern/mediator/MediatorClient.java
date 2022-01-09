package com.belonk.designpattern.mediator;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class MediatorClient {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/*
	 * 中介者模式：同事类之间不直接通信，而是都去找中介，通过中介对象进行转发
	 *
	 * 典型的例子：消息队列，房产中介等等
	 */

	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
		ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
		mediator.setColleague1(colleague1);
		mediator.setColleague2(colleague2);

		colleague1.sendMessage("我是同事1");
		colleague2.sendMessage("我是同事2");

		/*
		ConcreteColleague1 发送了消息: 我是同事1
		ConcreteColleague2 收到了消息: 我是同事1
		ConcreteColleague2 发送了消息: 我是同事2
		ConcreteColleague1 收到了消息: 我是同事2
		 */
	}
}