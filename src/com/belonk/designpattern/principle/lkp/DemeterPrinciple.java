package com.belonk.designpattern.principle.lkp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sun on 2020/5/25.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class DemeterPrinciple {
	//~ Static fields/constants/initializer


	//~ Instance fields


	//~ Constructors


	//~ Methods

	/**
	 * 迪米特法则：类对其依赖的类所知道的越少越好，只与直接的朋友通信：成员变量、方法参数、方法返回值都是直接的朋友，局部变量不是
	 */
	public static void main(String[] args) {
		OrderService orderService = new OrderService();

		PayService payService = new PayService();
		payService.setOrderService(orderService);
		String orderNo = "1";
		payService.paidSuccessfully(orderNo);

		System.out.println(orderService.queryAllOrder());
	}
}

class OrderService {
	private static Map<String, Order> orders = new HashMap<>();

	{
		orders.put("1", new Order("1", "CREATED"));
		orders.put("2", new Order("2", "CREATED"));
	}

	public Collection<Order> queryAllOrder() {
		return orders.values();
	}

	// 返回值Order是直接的朋友
	public Order getOrder(String orderNo) {
		return orders.get(orderNo);
	}

	// 更新订单状态
	public void updateOrderStatus(String orderNo, String status) {
		Order order = getOrder(orderNo);
		order.setStatus(status);
		System.out.println("update pay record status");
	}

	public boolean updateOrder(Order order) {
		System.out.println("update order");
		return true;
	}
}

class PayService {
	// 成员变量，是PayService的直接朋友
	private OrderService orderService;

	public boolean updatePayRecordStatus() {
		System.out.println("update pay record status");
		return true;
	}

	// 支付成功：更新支付状态，更新订单状态
	public void paidSuccessfully(String orderNo) {
		updatePayRecordStatus();
		// 改进：将更新订单状态的方法放到OrderService中
		orderService.updateOrderStatus(orderNo, "PAID");
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
}


class Order {
	private String orderNo;
	private String status;

	public Order(String orderNo, String status) {
		this.orderNo = orderNo;
		this.status = status;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderNo='" + orderNo + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}