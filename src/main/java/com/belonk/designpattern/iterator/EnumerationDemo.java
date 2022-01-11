package com.belonk.designpattern.iterator;

import java.util.*;

/**
 * Created by sun on 2022/1/11.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class EnumerationDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		int size = 10;
		Vector<Integer> ints = new Vector<>();
		for (int i = 0; i < size; i++) {
			ints.add(i);
		}
		System.out.println("size: " + ints.size());
		// 增强for循环本身就是使用的迭代器来遍历
		// 任何实现了Iterable接口的对象都可以被增强for循环遍历
		for (Integer anInt : ints) {
			System.out.println(anInt);
		}

		// 使用Enumeration来遍历
		System.out.println("Use Enumeration");
		Enumeration<Integer> elements = ints.elements();
		while (elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}

		// 使用iterator来遍历
		System.out.println("Use Iterator");
		Iterator<Integer> iterator = ints.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// 使用 ListIterator 遍历
		System.out.println("Use listIterator");
		ListIterator<Integer> listIterator = ints.listIterator();
		// 先向后遍历一次
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		// 再向前遍历一次
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
	}
}
