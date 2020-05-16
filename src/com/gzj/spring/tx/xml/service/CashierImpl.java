package com.gzj.spring.tx.xml.service;

import java.util.List;


public class CashierImpl implements Cashier {

	
	private OrderService service;
	
	public void setService(OrderService service) {
		this.service = service;
	}
	
	@Override
	public void checkout(int user_id, List<Integer> order_ids) {
		// TODO Auto-generated method stub
		for(int oid : order_ids )
		{
			service.editOrder(oid, user_id);
		}
	}

}
