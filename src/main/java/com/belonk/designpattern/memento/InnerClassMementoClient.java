package com.belonk.designpattern.memento;

/**
 * Created by sun on 2022/1/12.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class InnerClassMementoClient {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	public static void main(String[] args) {
		// 初始状态
		String name = "李逍遥";
		State initState = new State(10, 10, 100, 100);
		OriginatorWithInnerClass originator = new OriginatorWithInnerClass(name);
		originator.setState(initState);
		originator.setTitle("出生小菜鸟");
		System.out.println(originator);

		// 打怪升级一段时间后
		State state = new State(40, 50, 40, 10);

		originator.setState(state);
		originator.setTitle("江湖小虾米");
		System.out.println(originator);

		// 弄了一套装备，准备打boss
		State beforeBoss = new State(90, 80, 100, 100);
		originator.setState(beforeBoss);
		originator.setTitle("武林高手");
		System.out.println(originator);
		// 存档
		originator.createMemento();
		// 打BOSS之后，挂了，需要恢复存档
		State afterBoss = new State(90, 80, 0, 0);
		originator.setState(afterBoss);
		System.out.println("挑战boss失败：" + originator);
		originator.recover();
		System.out.println("恢复存档：" + originator);
	}
}
