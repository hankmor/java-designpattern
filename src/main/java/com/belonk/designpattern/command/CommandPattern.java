package com.belonk.designpattern.command;

/**
 * Created by sun on 2021/6/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class CommandPattern {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		Receiver receiver = new Receiver();
		ConcreteCommand concreteCommand = new ConcreteCommand();
		concreteCommand.setReceiver(receiver);
		invoker.setCommand(concreteCommand);
		invoker.executeCommand();
	}
}

// 命令接口
interface Command {
	void execute();
}

// 具体命令实现
class ConcreteCommand implements Command {
	private Receiver receiver;

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		this.receiver.action();
	}
}

// 调用者
class Invoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		this.command.execute();
	}
}

// 接收者
class Receiver {
	public void action() {
		System.out.println("执行命令");
	}
}