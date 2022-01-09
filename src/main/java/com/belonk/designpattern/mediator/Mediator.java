package com.belonk.designpattern.mediator;

/**
 * 抽象中介者，依据抽象同事类定义中介者的通用方法。
 * <p>
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public interface Mediator {
	//~ Constants/Initializer


	//~ Interfaces

	void sendMessage(Colleague colleague, String msg);
}
