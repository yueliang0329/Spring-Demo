package com.gzj.spring.tx.xml.service;

import java.util.List;

public interface Cashier {
	public void checkout(int user_id,List<Integer> order_ids );
}
