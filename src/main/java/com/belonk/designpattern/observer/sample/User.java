package com.belonk.designpattern.observer.sample;

import com.belonk.designpattern.observer.Observer;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class User implements Observer {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private final WechatGroup wechatGroup;
	private final String name;

	//~ Constructors

	public User(WechatGroup wechatGroup, String name) {
		this.wechatGroup = wechatGroup;
		this.name = name;
	}

	//~ Methods

	@Override
	public void update() {
		System.out.println(this.name + " > " + wechatGroup.getNewMessage());
	}

	public void sendMessage(String msg) {
		msg = this.name + " 发送了消息：" + msg;
		wechatGroup.receivedNewMessage(msg);
	}

	public String getName() {
		return name;
	}
}