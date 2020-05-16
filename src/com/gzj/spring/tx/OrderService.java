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
	
	//��������ע��
	//ʹ��propagation ָ������Ĵ�����Ϊ������ǰ���񷽷�����һ�����񷽷�����ʱ���ʹ������
	//Ĭ��ȡֵΪREQUIRED����ʹ�õ��÷���������
//	@Transactional(propagation=Propagation.REQUIRED)
	//REQUIRES_NEW ʹ���Լ������񣬵��÷��������񱻹���
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,
			isolation=Isolation.READ_COMMITTED,//ʹ��isolationָ������ĸ��뼶����õ�ȡֵΪREAD_COMMITTED �����ύ
	//		noRollbackFor= {OrderItemException.class},//���ĳ���쳣�����лع�
			readOnly=false,//ָ�������Ƿ���ֻ�� ������һ��ֻ��ȡ���ݿ�ķ���Ӧ����readonly=true
			timeout=3) //ʹ��timeoutָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ��
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
