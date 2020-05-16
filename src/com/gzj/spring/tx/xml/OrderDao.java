package com.gzj.spring.tx.xml;

public interface OrderDao {
	public double findOrderPriceById(int orderId);
	
	public void updateOrderPrice(int orderId);
	
	public void changeBalance(int user_id,double price);
}
