package com.belonk.designpattern.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sun on 2021/6/7.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class StrategyPatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		/*
		策略（Strategy）模式：定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。策略模式属
		于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。

		策略模式的主要优点：
		1、多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句，如 if...else 语句、switch...case 语句
		2、策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码
		3、策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的策略
		4、策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法
		5、策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离

		其主要缺点：
		1、客户端必须理解所有策略算法的区别，以便适时选择恰当的算法类
		2、策略模式造成很多的策略类，增加维护难度
		 */

		// 创建具体策略，可以做动态配置，而客户端代码不需要修改，符合开闭原则
		CacheStrategy<String, Object> cacheStrategy = new LocalCacheStrategy<>();
		// 创建环境类
		CacheService<String, Object> cacheService = new CacheService<>(cacheStrategy);
		cacheService.add("name", "张三");
		cacheService.add("age", 20);
		Object name = cacheService.get("name");
		Object age = cacheService.get("age");
		System.out.println(name);
		System.out.println(age);
	}
}

// 缓存策略接口
interface CacheStrategy<K, V> {
	// 添加缓存
	void add(K key, V value);

	// 删除缓存
	void remove(K key);

	// 查询缓存
	V get(K key);
}

// 本地缓存策略
class LocalCacheStrategy<K, V> implements CacheStrategy<K, V> {
	private final Map<K, V> cacheMap = new ConcurrentHashMap<>();

	@Override
	public void add(K key, V value) {
		cacheMap.put(key, value);
	}

	@Override
	public void remove(K key) {
		cacheMap.remove(key);
	}

	@Override
	public V get(K key) {
		return cacheMap.get(key);
	}
}

// 基于Redis的缓存策略
class RedisCacheStrategy<K, V> implements CacheStrategy<K, V> {
	private final RedisClient<K, V> redisClient = new RedisClient<>("127.0.0.1", "6379", null);

	@Override
	public void add(K key, V value) {
		redisClient.set(key, value);
	}

	@Override
	public void remove(K key) {
		redisClient.del(key);
	}

	@Override
	public V get(K key) {
		return redisClient.get(key);
	}

	// 模拟的redis客户端，内部什么都没实现
	private static class RedisClient<K, V> {
		public RedisClient() {
		}

		public RedisClient(String host, String port, String pwd) {
			// contect ...
		}

		public void set(K key, V value) {

		}

		public V get(K key) {
			return null;
		}

		public void del(K key) {

		}
	}
}

// 基于EHCache的缓存策略，未实现具体逻辑
class EhCacheStrategy<K, V> implements CacheStrategy<K, V> {
	@Override
	public void add(K key, V value) {

	}

	@Override
	public void remove(K key) {

	}

	@Override
	public V get(K key) {
		return null;
	}
}

// 策略使用环境
class CacheService<K, V> {
	// 持有策略引用
	private CacheStrategy<K, V> cacheStrategy;

	public CacheService() {
	}

	// 通过构造器传递引用
	public CacheService(CacheStrategy<K, V> cacheStrategy) {
		this.cacheStrategy = cacheStrategy;
	}

	// 通过方法传递引用
	public void setCacheStrategy(CacheStrategy<K, V> cacheStrategy) {
		this.cacheStrategy = cacheStrategy;
	}

	// 添加缓存
	public void add(K key, V value) {
		cacheStrategy.add(key, value);
	}

	// 删除缓存
	public void remove(K key) {
		cacheStrategy.remove(key);
	}

	// 查询缓存
	public V get(K key) {
		return cacheStrategy.get(key);
	}
}