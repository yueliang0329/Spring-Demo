package com.gzj.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,//使用isolation指定事务的隔离级别，最常用的取值为READ_COMMITTED 读已提交
	//		noRollbackFor= {OrderItemException.class},//针对某个异常不进行回滚
			readOnly=false,//指定事务是否是只读 ，若是一个只读取数据库的方法应设置readonly=true
			timeout=3) //使用timeout指定强制回滚之前事务可以占用的时间
	public void editOrder(int id,int user_id)
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double price=dao.findOrderPriceById(id);
		
		dao.changeBalance(user_id, price);
		
		dao.updateOrderPrice(id);
		
	}
}
