package com.gzj.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
public class OrderService {

	@Autowired
	private OrderDao dao;
	
	//��������ע��
	//ʹ��propagation ָ������Ĵ�����Ϊ������ǰ���񷽷�����һ�����񷽷�����ʱ���ʹ������
	//Ĭ��ȡֵΪREQUIRED����ʹ�õ��÷���������
//	@Transactional(propagation=Propagation.REQUIRED)
	//REQUIRES_NEW ʹ���Լ������񣬵��÷��������񱻹���
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void editOrder(int id,int user_id)
	{
		double price=dao.findOrderPriceById(id);
		
		dao.changeBalance(user_id, price);
		
		dao.updateOrderPrice(id);
		
	}
}
