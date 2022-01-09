package com.belonk.designpattern.observer.sample;

/**
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class WechatGroupClient {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		WechatGroup wechatGroup = new WechatGroup("聊天群");
		User zs = new User(wechatGroup, "张三");
		User ls = new User(wechatGroup, "李四");
		User ww = new User(wechatGroup, "王五");
		wechatGroup.attach(zs);
		wechatGroup.attach(ls);
		wechatGroup.attach(ww);

		zs.sendMessage("大家好，我是张三!");

		/*
		张三 > 张三 发送了消息：大家好，我是张三!
		李四 > 张三 发送了消息：大家好，我是张三!
		王五 > 张三 发送了消息：大家好，我是张三!
		 */
	}
}