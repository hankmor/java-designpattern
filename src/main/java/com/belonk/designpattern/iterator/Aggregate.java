package com.belonk.designpattern.iterator;

import java.util.Iterator;

/**
 * 聚集对象。
 * <p>
 * Created by sun on 2022/1/10.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class Aggregate<T> implements MyIterable<T> {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private final int capacity;
	private final Object[] elements;
	private int current;

	//~ Constructors

	public Aggregate(int capacity) {
		this.capacity = capacity;
		elements = new Object[size()];
	}

	public int size() {
		return capacity;
	}

	public T add(T item) {
		if (current++ > capacity) {
			throw new IllegalStateException("Capacity overflow!");
		}
		elements[current] = item;
		return item;
	}

	//~ Methods

	@Override
	public MyIterator<T> iterator() {
		return new MyIteratorImpl<T>();
	}

	private static class MyIteratorImpl<T> implements MyIterator<T> {
		private int current;

		@Override
		public T next() {
			return null;
		}

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public boolean first() {
			return false;
		}

		@Override
		public boolean last() {
			return false;
		}
	}
}