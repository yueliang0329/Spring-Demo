package com.gzj.spring.tx;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTxTest {

	private ApplicationContext ctx = null;
	
	private OrderDao dao = null;
	
	private OrderService service=null;
	
	private Cashier cashier=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext-tx.xml");
		dao= (OrderDao) ctx.getBean("orderDao");
		service=(OrderService) ctx.getBean("orderService");
		cashier=  (Cashier) ctx.getBean("cashier");
	}
	
	@Test
	public void test()
	{
		dao.updateOrderPrice(13);
		System.out.println(dao.findOrderPriceById(13));
		//System.out.println(orderDao.findOrderPriceById(11));
	}
	
	//测试单个事务
	@Test  
	public void test2()
	{
		service.editOrder(11, 1);
	}
	
	//测试事务传递
	@Test
	public void test3()
	{
		List<Integer> oids=new ArrayList<>();
		oids.add(11);
		oids.add(12);
		cashier.checkout(1, oids);
	}

}
