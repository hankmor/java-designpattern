package com.belonk.designpattern.mediator;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ConcreteColleague2 implements Colleague {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private Mediator mediator;

	//~ Constructors

	public ConcreteColleague2(Mediator mediator) {
		this.mediator = mediator;
	}

	//~ Methods

	@Override
	public void sendMessage(String msg) {
		System.out.println(this.getClass().getSimpleName() + " 发送了消息: " + msg);
		this.mediator.sendMessage(this, msg);
	}

	@Override
	public void receiveMessage(String msg) {
		System.out.println(this.getClass().getSimpleName() + " 收到了消息: " + msg);
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public Mediator getMediator() {
		return this.mediator;
	}
}