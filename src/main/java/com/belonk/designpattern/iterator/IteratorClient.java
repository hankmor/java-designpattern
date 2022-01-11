package com.belonk.designpattern.iterator;

/**
 * Created by sun on 2022/1/11.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class IteratorClient {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		int size = 10;
		Aggregate<Integer> aggregate = new Aggregate<>(size);
		for (int i = 0; i < size; i++) {
			aggregate.add(i);
		}

		// 移除最后两个
		aggregate.remove(size - 1);
		aggregate.remove(size - 2);

		System.out.println("size: " + aggregate.size());
		// 使用迭代器遍历
		MyIterator<Integer> iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			System.out.println("======");
			Integer item = iterator.next();
			System.out.println("next: " + item);
			System.out.println("first: " + iterator.first());
			System.out.println("last: " + iterator.last());
			System.out.println("hasNext: " + iterator.hasNext());
		}
	}
}
