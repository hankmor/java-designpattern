package com.belonk.designpattern.state;

/**
 * Created by sun on 2021/6/21.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class StatePatternCode {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		Context context = new Context(new ConcreteState1());
		context.operation();
		context.operation();
		context.operation();
		context.operation();

		/*~:
		状态1完成一些逻辑后转换状态...
		状态2完成一些逻辑后转换状态...
		状态1完成一些逻辑后转换状态...
		状态2完成一些逻辑后转换状态...
		 */
	}
}

interface State {
	void setContext(Context context);

	void doSomething();
}

class Context {
	private State state;

	// 初始状态
	public Context(State state) {
		this.state = state;
		state.setContext(this);
	}

	// 状态转换
	public void changeState(State state) {
		this.state = state;
		this.state.setContext(this);
	}

	// 具体业务方法，委派给状态执行
	public void operation() {
		this.state.doSomething();
	}
}

class ConcreteState1 implements State {
	private Context context;

	@Override
	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public void doSomething() {
		System.out.println("状态1完成一些逻辑后转换状态...");
		// 发起状态转换，委派给context
		this.context.changeState(new ConcreteState2());
	}
}

class ConcreteState2 implements State {
	private Context context;

	@Override
	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public void doSomething() {
		System.out.println("状态2完成一些逻辑后转换状态...");
		// 发起状态转换，委派给context
		this.context.changeState(new ConcreteState1());
	}
}
