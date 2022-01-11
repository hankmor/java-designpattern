package com.belonk.designpattern.iterator;

import java.util.NoSuchElementException;

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

	private final int maxCapacity;
	private final Object[] elements;
	private int size;

	//~ Constructors

	public Aggregate(int capacity) {
		this.maxCapacity = capacity;
		elements = new Object[capacity];
	}

	public int size() {
		return size;
	}

	public T add(T item) {
		if (size > maxCapacity - 1) {
			throw new IllegalStateException("Capacity overflow!");
		}
		elements[size++] = item;
		return item;
	}

	public T remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T removed = (T) elements[index];
		if (index < size - 1) {
			// 删除，重新拷贝数组
			System.arraycopy(elements, index + 1, elements, index, size - index - 1);
		}
		elements[--size] = null;
		return removed;
	}

	//~ Methods

	@Override
	public MyIterator<T> iterator() {
		return new MyIteratorImpl<T>();
	}

	private class MyIteratorImpl<T> implements MyIterator<T> {
		// 游标位置
		private int cursor;

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (T) elements[cursor++];
		}

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public boolean first() {
			return cursor == 1;
		}

		@Override
		public boolean last() {
			return cursor == size;
		}
	}
}
