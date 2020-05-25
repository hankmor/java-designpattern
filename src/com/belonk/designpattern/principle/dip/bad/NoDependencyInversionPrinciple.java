package com.belonk.designpattern.principle.dip.bad;

/**
 * Created by sun on 2020/5/24.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class NoDependencyInversionPrinciple {
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
// 面向实现变成，每当有新消息类型，客户端都需要改动，不符合依赖倒置原则
class Client {
    public void receiveMessage(WechatMessage wm) {
        System.out.println("收到消息：" + wm.getMsg());
    }

    public void receiveMessage(EmailMessage em) {
        System.out.println("收到消息：" + em.getMsg());
    }

    public void receiveMessage(SmsMessage sm) {
        System.out.println("收到消息：" + sm.getMsg());
    }
}

// 微信消息
class WechatMessage {
    public String getMsg() {
        return "这是微信消息";
    }
}

// 邮件消息
class EmailMessage {
    public String getMsg() {
        return "这是邮件消息";
    }
}

// 每次添加消息，客户端都需要改动

// 短信消息
class SmsMessage {
    public String getMsg() {
        return "这是短信消息";
    }
}