package com.gzj.spring.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");	
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");	
		
		//更新单条数据		
		String sql="update tbl_user set user_name = ? where user_id = ?";
		//jdbcTemplate.update(sql, "dean",2);		
			
		//执行批量更新
		sql="insert into tbl_user(user_name,password) values (?,?)";
		List<Object[]>batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"jack1",555});
		batchArgs.add(new Object[]{"jack2",666});
		batchArgs.add(new Object[]{"jack3",777});
		batchArgs.add(new Object[]{"jack4",888});
		//jdbcTemplate.batchUpdate(sql, batchArgs);
		
		//查单个对象
		sql="select * from tbl_user where user_id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper,1);
		//System.out.println(user);
		
		//查对象集合
		sql="select * from tbl_user";
		List<User> useList = jdbcTemplate.query(sql, rowMapper);
		//System.out.println(useList);
		
		//获取单个列的值，或做统计查询
		sql="select count(user_id) from tbl_user";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(count);
		
		//namedParameterJdbcTemplate 可以给参数具名
		 sql="insert into  tbl_user (user_name,password) values (:userName,:password)";
//		 Map<String,Object> paramMap =new HashMap<>();
//		 paramMap.put("userName", "leo");
//		 paramMap.put("password", 888);
//		 namedParameterJdbcTemplate.update(sql, paramMap);
		 User u=new User();
		 u.setUserName("look");
		 u.setPassword("321654");
		 SqlParameterSource paramSource = new BeanPropertySqlParameterSource(u);
		// namedParameterJdbcTemplate.update(sql, paramSource);
	}
}
