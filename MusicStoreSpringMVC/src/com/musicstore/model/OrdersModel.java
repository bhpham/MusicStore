package com.musicstore.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.entities.Order;


@Component
@Service("ordersService")
public class OrdersModel {

	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void create(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
	
	@Transactional
	public List<Order> findAllOrders() {
		List<Order> ordersList = null;
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Query query = session.createQuery("from Order");
			ordersList = query.list();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Can't find any orders !!!");
		}
		
		return ordersList; 
	}
	
	@Transactional
	public Order findOrderByOrderId(int id) {
		List<Order> orderList = null;
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Query query = session.createQuery("from Order where orderId = :id");
			query.setParameter("id", id);
			orderList = query.list();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Can't find any order with this orderId");
		}
		
		return orderList.get(0);
	}
	
	@Transactional
	public Order findOrderByUserId(int id) {
		List<Order> orderList = findAllOrders();
		
		Order returnOrder = null;
		for (Order order : orderList) {
			if (order.getUser().getUserId() == id) {
				returnOrder = order;
			}
		}
		
		return returnOrder;
	}
}
