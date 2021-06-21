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
		// 状态模式测试
		new Client().invoke();
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

class Client {
	public void invoke() {
		// 通过调用context的业务方法实现状态转换
		ActivityContext context = new ActivityContext(new ActivityNormalState());
		context.disable();
		context.enable();
		context.start();
		context.finish();

		context = new ActivityContext(new ActivityNormalState());
		context.disable();
		context.enable();
		context.start();
		context.terminate();

		/*
		当前状态：正常
		当前状态：已禁用
		当前状态：正常
		当前状态：已开始
		当前状态：已结束
		当前状态：正常
		当前状态：已禁用
		当前状态：正常
		当前状态：已开始
		当前状态：已终止
		 */
	}
}

class ActivityContext {
	private ActivityState state;

	public ActivityContext(ActivityState initState) {
		this.state = initState;
		this.state.setActivityContext(this);
		print();
	}

	public void changeState(ActivityState state) {
		this.state = state;
		this.state.setActivityContext(this);
	}

	// 为了简单，下边的业务非法省略了当前状态的检查

	public void disable() {
		((ActivityNormalState) this.state).disable();
		print();
	}

	public void enable() {
		((ActivityDisabledState) this.state).enable();
		print();
	}

	public void start() {
		((ActivityNormalState) this.state).start();
		print();
	}

	public void finish() {
		((ActivityStartedState) this.state).finish();
		print();
	}

	public void terminate() {
		((ActivityStartedState) this.state).terminate();
		print();
	}

	private void print() {
		System.out.println("当前状态：" + this.state.name());
	}
}

interface ActivityState {
	void setActivityContext(ActivityContext context);

	String name();

	ActivityState currentState();

	void nextState(ActivityState state);
}

// 抽象状态类
abstract class AbstractActivityState implements ActivityState {
	protected ActivityContext context;

	@Override
	public void setActivityContext(ActivityContext context) {
		this.context = context;
	}

	@Override
	public ActivityState currentState() {
		return this;
	}

	@Override
	public void nextState(ActivityState state) {
		this.context.changeState(state);
	}

	@Override
	public abstract String name();
}

// 正常状态
class ActivityNormalState extends AbstractActivityState {
	@Override
	public String name() {
		return "正常";
	}

	public void disable() {
		this.nextState(new ActivityDisabledState());
	}

	public void start() {
		this.nextState(new ActivityStartedState());
	}
}

// 开始状态
class ActivityStartedState extends AbstractActivityState {
	@Override
	public String name() {
		return "已开始";
	}

	public void finish() {
		this.nextState(new ActivityFinishedState());
	}

	public void terminate() {
		this.nextState(new ActivityTerminatedState());
	}
}

// 结束状态
class ActivityFinishedState extends AbstractActivityState {
	@Override
	public String name() {
		return "已结束";
	}
}

// 禁用状态
class ActivityDisabledState extends AbstractActivityState {
	@Override
	public String name() {
		return "已禁用";
	}

	public void enable() {
		this.nextState(new ActivityNormalState());
	}
}

// 终止状态
class ActivityTerminatedState extends AbstractActivityState {
	@Override
	public String name() {
		return "已终止";
	}
}