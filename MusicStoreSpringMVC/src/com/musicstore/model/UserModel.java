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

import com.musicstore.entities.Users;

@Component
@Service("userService")
public class UserModel {

	
	@Autowired
	SessionFactory sessionFactory;
	
//	private Session session = sessionFactory.getCurrentSession();
	
	/**
	 * Add the new user into DB
	 * @param user
	 */
	@Transactional
	public void create(Users user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	/**
	 * Retrieve all the users from DB
	 * @return
	 */
	@Transactional
	public List<Users> retrieveAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Users> users = null;
		
		try {
			Query query = session.createQuery("from Users");
			users = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No users found !!!");
		}
		
		return users;
	}
	
	/**
	 * Retrieve the user based on the username
	 * @param username
	 * @return
	 */
	@Transactional
	public Users retrieveUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		List<Users> users = null; 
		
		try {
			Query query = session.createQuery("from Users where username = :usrname");
			query.setParameter("usrname", username);
			users = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't find any users with this usrID");
		}
		
		return users.get(0);
	}
	
	@Transactional
	public boolean verifyUser(String username, String password) {
		
		boolean result = false;
		List<Users> users = null;
		
		try {
			users = retrieveAllUsers();
			if (users == null) {
				System.out.println("LIST OF USERS IS EMPTY ");
				return false;
			}
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Our system currently doesn't have any users");
		}
		
		for (Users user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				result = true;
			}
		}
		
		return result;
	}
	


}
