package com.belonk.designpattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sun on 2020/12/15.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class FlyweightPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		WebsiteFactory websiteFactory = new WebsiteFactory();
		String type = "博客";
		Website website = websiteFactory.getWebsite(type);
		website.use(new User("张三"));

		website = websiteFactory.getWebsite(type);
		website.use(new User("李四"));

		website = websiteFactory.getWebsite(type);
		website.use(new User("王二"));

		type = "新闻";
		website = websiteFactory.getWebsite(type);
		website.use(new User("孙大"));

		website = websiteFactory.getWebsite(type);
		website.use(new User("赵二"));

		System.out.println("当前网站实例数：" + websiteFactory.count());
	}
}

// 网站用户，外部状态
class User {
	private final String name;

	User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

// 网站，flyweight对象
interface Website {
	void use(User user);
}

// 具体网站，ConcreteFlyweight
class ConcreteWebsite implements Website {
	private final String type;

	public ConcreteWebsite(String type) {
		this.type = type;
	}

	@Override
	public void use(User user) {
		System.out.println("网站类型：" + type + ", 网站站长：" + user.getName());
	}
}

// 网站工厂，FlyWeightFactory
class WebsiteFactory {
	private final Map<String, Website> websites = new ConcurrentHashMap<>();

	public Website getWebsite(String type) {
		websites.putIfAbsent(type, new ConcreteWebsite(type));
		return websites.get(type);
	}

	public int count() {
		return websites.size();
	}
}