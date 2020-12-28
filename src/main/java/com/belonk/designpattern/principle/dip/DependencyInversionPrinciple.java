package com.belonk.designpattern.principle.dip;

/**
 * Created by sun on 2020/5/24.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class DependencyInversionPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		Client client = new Client();
		client.receiveMessage(new WechatMessage());
		client.receiveMessage(new EmailMessage());
		client.receiveMessage(new SmsMessage());
	}
}

// 消息接收客户端
// 面向接口编程，每当有新消息类型，客户端不需要改动，符合依赖倒置原则
class Client {
	public void receiveMessage(Message message) {
		System.out.println("收到消息：" + message.getMsg());
	}
}

// 抽象一个消息接口
interface Message {
	String getMsg();
}

// 微信消息
class WechatMessage implements Message {
	@Override
	public String getMsg() {
		return "这是微信消息";
	}
}

// 邮件消息
class EmailMessage implements Message {
	@Override
	public String getMsg() {
		return "这是邮件消息";
	}
}

// 添加消息时，客户端不需要改动

// 短信消息
class SmsMessage implements Message {
	@Override
	public String getMsg() {
		return "这是短信消息";
	}
}