package com.musicstore.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.entities.OrderDetail;

@Component
@Service("orderDetailService")
public class OrderDetailModel {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void create(OrderDetail orderDetail) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orderDetail);
	}
	
//	@Transactional
//	public List<Order> findAllOrders() {
//		List<Order> ordersList = null;
//		Session session = sessionFactory.getCurrentSession();
//		
//		try {
//			Query query = session.createQuery("from Order");
//			ordersList = query.list();
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("Can't find any orders !!!");
//		}
//		
//		return ordersList; 
//	}
//	
//	@Transactional
//	public Order findOrderByUserId(int id) {
//		List<Order> orderList = null;
//		Session session = sessionFactory.getCurrentSession();
//		
//		try {
//			Query query = session.createQuery("from Order where userId = :id");
//			query.setParameter("id", id);
//			orderList = query.list();
//		} catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("Can't find any order with this ID");
//		}
//		
//		return orderList.get(0);
//	}


}

