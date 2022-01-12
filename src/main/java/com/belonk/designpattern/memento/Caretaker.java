package com.belonk.designpattern.memento;

/**
 * 备忘录管理者，负责存储备忘录，但自身不能访问和修改它。
 * <p>
 * Created by sun on 2022/1/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class Caretaker {
	//~ Static fields/constants/initializer


	//~ Instance fields

	private Memento memento;

	//~ Constructors


	//~ Methods

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
