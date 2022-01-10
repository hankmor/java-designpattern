package com.belonk.designpattern.iterator;

/**
 * 迭代器接口。
 * <p>
 * Created by sun on 2022/1/10.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public interface MyIterator<T> {
	//~ Constants/Initializer


	//~ Interfaces

	// 下一个元素
	T next();

	// 是否有下一个元素
	boolean hasNext();

	// 是否是第一个元素
	boolean first();

	// 是否是最后一个元素
	boolean last();
}
