package com.gzj.spring.tx.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class OrderDaoImpl implements OrderDao {

	private JdbcTemplate jdbcTemplate;
	
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
	
	@Override
	public double findOrderPriceById(int orderId) {
		// TODO Auto-generated method stub
		String sql = "select order_price from tbl_order where order_id = ?";
		return jdbcTemplate.queryForObject(sql, Double.class, orderId);
	}

	@Override
	public void updateOrderPrice(int orderId) {
		// TODO Auto-generated method stub
		// 检查i_id 大于1 
		String sql2="select i_id from tbl_order where  order_id = ?";
		int i_id = jdbcTemplate.queryForObject(sql2, Integer.class, orderId);
		if(i_id>1)
		{
			throw new OrderItemException("非法item——id");
		}
		String sql = "update tbl_order set order_price=order_price-0.1 where order_id = ?";
		jdbcTemplate.update(sql, orderId);
	}

	@Override
	public void changeBalance(int user_id,double peice) {
		// TODO Auto-generated method stub
		String sql = "update tbl_balance set balance=balance-"+peice+" where user_id = ?";
		System.out.println(sql);
		jdbcTemplate.update(sql, user_id);
	}
	
	

}
