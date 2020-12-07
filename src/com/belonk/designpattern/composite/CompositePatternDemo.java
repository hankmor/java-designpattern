package com.belonk.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 2020/11/8.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class CompositePatternDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		// 学校、学院、系，如果用继承来解决管理问题，那么并不是那么灵活，并且他们之间真的有继承的关系吗？继承关系是从这些结构的大小而言的，如果将他们都看做
		// 学校的组织机构，可以将其看做树型结构，称为组织机构树，这属于整体和部分的关系，可以用组合模式来解决管理问题
		Organization university = new University("四川大学");

		Organization college1 = new College("计算机学院");
		Organization college2 = new College("信息工程学院");
		university.add(college1);
		university.add(college2);

		Organization dept1 = new Department("计算机科学与技术");
		Organization dept2 = new Department("软件工程");
		college1.add(dept1);
		college1.add(dept2);
		Organization dept3 = new Department("通信网络工程");
		Organization dept4 = new Department("通信设备");
		college2.add(dept3);
		college2.add(dept4);

		// 打印整个组织机构
		university.print();

		System.out.println();
		// 打印某一个学院
		college1.print();
	}
}

// 抽象组件
interface Organization {
	void add(Organization org);

	void remove(Organization org);

	void print();
}

// 学校
class University implements Organization {
	private final String name;
	private final List<Organization> colleges = new ArrayList<>();

	public University(String name) {
		this.name = name;
	}

	@Override
	public void add(Organization org) {
		this.colleges.add(org);
	}

	@Override
	public void remove(Organization org) {
		this.colleges.remove(org);
	}

	@Override
	public void print() {
		System.out.println(this.name);
		for (Organization college : colleges) {
			college.print();
		}
	}
}

// 学院
class College implements Organization {
	private final String name;
	private final List<Organization> depts = new ArrayList<>();

	public College(String name) {
		this.name = name;
	}

	@Override
	public void add(Organization org) {
		this.depts.add(org);
	}

	@Override
	public void remove(Organization org) {
		this.depts.remove(org);
	}

	@Override
	public void print() {
		System.out.println("--" + this.name);
		for (Organization dept : depts) {
			dept.print();
		}
	}
}

// 系
class Department implements Organization {
	private final String name;

	public Department(String name) {
		this.name = name;
	}

	@Override
	public void add(Organization org) {
		throw new UnsupportedOperationException("系不能进行添加操作");
	}

	@Override
	public void remove(Organization org) {
		throw new UnsupportedOperationException("系不能进行删除操作");
	}

	@Override
	public void print() {
		System.out.println("----" + this.name);
	}
}

