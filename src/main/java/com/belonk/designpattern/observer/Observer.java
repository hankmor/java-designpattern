package com.belonk.designpattern.observer;

/**
 * 抽象观察者，当主体状态变化时，会被通知然后用{@link #update()}方法进行更新。
 * <p>
 * Created by sun on 2022/1/9.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public interface Observer {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	void update();
}