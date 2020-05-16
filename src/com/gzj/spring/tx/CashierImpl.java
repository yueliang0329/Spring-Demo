package com.gzj.spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private OrderService service;
	
	@Transactional
	@Override
	public void checkout(int user_id, List<Integer> order_ids) {
		// TODO Auto-generated method stub
		for(int oid : order_ids )
		{
			service.editOrder(oid, user_id);
		}
	}

}
