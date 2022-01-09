package com.belonk.designpattern.mediator;

/**
 * 抽象同事类，定义通用方法，需要支持聚合中介者。
 * <p>
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public interface Colleague {
	//~ Constants/Initializer


	//~ Interfaces

	// 想其他同事发送消息
	void sendMessage(String msg);

	// 接收其他同事发来的消息
	void receiveMessage(String msg);

	// 设置中介者
	void setMediator(Mediator mediator);

	// 获取中介者
	Mediator getMediator();
}
