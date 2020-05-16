package com.gzj.spring.tx.xml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gzj.spring.tx.xml.OrderDao;


public class OrderService {


	private OrderDao dao;
	
	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	
	public void editOrder(int id,int user_id)
	{
		double price=dao.findOrderPriceById(id);
		
		dao.changeBalance(user_id, price);
		
		dao.updateOrderPrice(id);
		
	}
}
