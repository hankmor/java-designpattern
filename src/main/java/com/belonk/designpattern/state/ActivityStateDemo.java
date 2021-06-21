package com.belonk.designpattern.state;

/**
 * Created by sun on 2021/6/21.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ActivityStateDemo {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {

	}
}

//~ 传统的方式实现状态变化

enum ActivityStateEnum {
	NORMAL, STARTED, FINISHED, DISABLED, TERMINATED
}

class NormalActivityStateChange {
	public ActivityStateEnum change(ActivityStateEnum state) {
		ActivityStateEnum retState = null;
		switch (state) {
			case NORMAL:
				// 可以禁用任务
				// retState = ActivityStateEnum.DISABLED;
				// 时间到，开启任务
				retState = ActivityStateEnum.STARTED;
				break;
			case STARTED:
				// 可能结束，也可能终止
				// retState = ActivityStateEnum.TERMINATED;
				retState = ActivityStateEnum.FINISHED;
				break;
			case DISABLED:
				// 可以启用，变为正常状态
				retState = ActivityStateEnum.NORMAL;
			case TERMINATED:
			case FINISHED:
			default:
				// 什么都不做
		}
		return retState;
	}
}

//~ 使用状态设计模式实现状态变化

