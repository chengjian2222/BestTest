package day07.homework.Topic2;

import java.math.BigDecimal;

/*
 *  *    order_id,  唯一
 *    order_amount(订单金额),
 *    order_user_id(订单付款人id),
 *    order_user_name(订单付款人名字),
 *    order_merchant_id(订单商家id)
 *    order_merchant_name(订单商家名称)
 * */
public class Order {
	private int orderId;
	private BigDecimal orderAmount;
	private int orderUserId;
	private String orderUserName;
	private double orderMerchantId;
	private String orderMerchantName;

	public Order() {
		super();
	}

	public Order(int orderId, BigDecimal orderAmount, int orderUserId, String orderUserName, double orderMerchantId,
			String orderMerchantName) {
		super();
		this.orderId = orderId;
		this.orderAmount = orderAmount;
		this.orderUserId = orderUserId;
		this.orderUserName = orderUserName;
		this.orderMerchantId = orderMerchantId;
		this.orderMerchantName = orderMerchantName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}

	public String getOrderUserName() {
		return orderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	public double getOrderMerchantId() {
		return orderMerchantId;
	}

	public void setOrderMerchantId(double orderMerchantId) {
		this.orderMerchantId = orderMerchantId;
	}

	public String getOrderMerchantName() {
		return orderMerchantName;
	}

	public void setOrderMerchantName(String orderMerchantName) {
		this.orderMerchantName = orderMerchantName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderUserId=" + orderUserId
				+ ", orderUserName=" + orderUserName + ", orderMerchantId=" + orderMerchantId + ", orderMerchantName="
				+ orderMerchantName + "]";
	}

}
