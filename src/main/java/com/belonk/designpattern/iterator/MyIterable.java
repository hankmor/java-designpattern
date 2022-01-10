package com.belonk.designpattern.iterator;

/**
 * 聚集对象接口，可以返回一个迭代器。
 * <p>
 * Created by sun on 2022/1/10.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public interface MyIterable<T> {
	//~ Constants/Initializer


	//~ Interfaces

	// 返回迭代器
	MyIterator<T> iterator();
}
