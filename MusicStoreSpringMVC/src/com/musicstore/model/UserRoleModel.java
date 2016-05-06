package com.musicstore.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.entities.UserRole;


@Component
@Service("userRoleService")
public class UserRoleModel {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void create(UserRoleModel userRoleModel) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userRoleModel);
	}

	@Transactional
	public List<UserRole> findAllUserRoles() {
		Session session = sessionFactory.getCurrentSession();
		List<UserRole> userRoleList = null;
		try {
			Query query = session.createQuery("from UserRole");
			userRoleList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRoleList;
	}
	
	@Transactional
	public UserRole findUserRoleByUserRoleId(int myUserRole) {
		Session session = sessionFactory.getCurrentSession();
		List<UserRole> userRoleList = null;
		
		
		try {
			Query query = session.createQuery("from UserRole where userRoleId = :id");
			query.setParameter("id", myUserRole);
			userRoleList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't find this particular userRole by Id: " + myUserRole);
		}
		
		return userRoleList.get(0);
	}
	
	
}
