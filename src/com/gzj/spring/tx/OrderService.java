package com.gzj.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderService {

	@Autowired
	private OrderDao dao;
	
	//配置事务注解
	//使用propagation 指定事务的传播行为，即当前事务方法被另一个事务方法调用时如何使用事务
	//默认取值为REQUIRED，即使用调用方法的事务
//	@Transactional(propagation=Propagation.REQUIRED)
	//REQUIRES_NEW 使用自己的事务，调用方法的事务被挂起
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void editOrder(int id,int user_id)
	{
		double price=dao.findOrderPriceById(id);
		
		dao.changeBalance(user_id, price);
		
		dao.updateOrderPrice(id);
		
	}
}
