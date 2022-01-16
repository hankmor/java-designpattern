package com.belonk.designpattern.respchain.bad;

import java.util.Random;

/**
 * Created by sun on 2022/1/16.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class AskForLeave {
	//~ Static fields/constants/initializer


	//~ Instance fields

	static final Random random = new Random(47);

	//~ Constructors


	//~ Methods

	/*
	 * 请假需求：小于3天的假期，组长审批，4-7天，部门经理审批，7天以上，总经理审批
	 */

	public static void main(String[] args) {
		int times = 10;
		for (int i = 0; i < times; i++) {
			askForLeave();
		}
	}

	public static void askForLeave() {
		int days = random.nextInt(10) + 1;
		LeaveRequest request = new LeaveRequest(days, "张三");
		System.out.println("请假请求：" + request);
		GroupLeader groupLeader = new GroupLeader();
		DeptManager deptManager = new DeptManager();
		CompanyManager companyManager = new CompanyManager();
		if (groupLeader.canHandle(request)) {
			groupLeader.handle(request);
		} else if (deptManager.canHandle(request)) {
			deptManager.handle(request);
		} else if (companyManager.canHandle(request)) {
			companyManager.handle(request);
		} else {
			System.err.println("没有人能处理这个请求请求");
		}
	}
}

class LeaveRequest {
	// 请假天数
	private final int days;
	// 请假人名称
	private final String name;

	public LeaveRequest(int days, String name) {
		this.days = days;
		this.name = name;
	}

	public int getDays() {
		return days;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "days: " + this.days + ", name: " + this.name;
	}
}

// 领导接口
interface Leader {
	/**
	 * 审批
	 *
	 * @param request 请假请求
	 */
	default void handle(LeaveRequest request) {
		Random random = new Random(47);
		if (canHandle(request)) {
			if (random.nextBoolean()) {
				System.out.println(this.getClass() + " [通过] 了请假请求: " + request);
			} else {
				System.out.println(this.getClass() + " [拒绝] 了请假请求: " + request);
			}
			return;
		}
		throw new RuntimeException(this.getClass() + " 不能处理请假请求: " + request);
	}

	/**
	 * 是否可以处理
	 *
	 * @param request 请假请求
	 * @return 可以处理返回true，否则返回false
	 */
	boolean canHandle(LeaveRequest request);
}

// 组长
class GroupLeader implements Leader {
	@Override
	public boolean canHandle(LeaveRequest request) {
		return request.getDays() <= 3;
	}
}

// 部门经理
class DeptManager implements Leader {
	@Override
	public boolean canHandle(LeaveRequest request) {
		return request.getDays() >= 4 && request.getDays() <= 7;
	}
}

// 总经理
class CompanyManager implements Leader {
	@Override
	public boolean canHandle(LeaveRequest request) {
		return request.getDays() > 7;
	}
}


