package com.musicstore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musicstore.entities.Album;
import com.musicstore.entities.Cart;

@Component
@Service("shoppingCartService")
public class ShoppingCartModel {

	@Autowired
	SessionFactory sessionFactory;
	
	private Integer currentCartNumber = 0;
	private List<Album> albumInCart = new ArrayList<Album>();
	
	@Transactional
	public void create(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cart);
	}
	
	@Transactional
	public void delete(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cart);
	}
	
	/***
	 * Create random cart ID
	 */
	public void generateCartId() {
		if (currentCartNumber == 0) {
			Random rand = new Random();
			currentCartNumber = rand.nextInt(999999999);
		}
	}
	
	@Transactional
	public Cart findCartById(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Cart> cartList = new ArrayList<Cart>();
		
		try {
			Query query = session.createQuery("from Cart where cartId = :id");
			query.setParameter("id", id);
			cartList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't find this particular album by Id: " + id);
		}
		
		return cartList.get(0);
	}

	
	public boolean remove(Album album) {
		for (Album a : getAlbumInCart()){
			if (a.getTitle().equals(album.getTitle())) {
				getAlbumInCart().remove(a);
				return true;
			}
		}
		return false;
	}
	
	public Integer getCurrentCartNumber() {
		return currentCartNumber;
	}

	public void setCurrentCartNumber(Integer currentCartNumber) {
		this.currentCartNumber = currentCartNumber;
	}

	public List<Album> getAlbumInCart() {
		return albumInCart;
	}

	public void setAlbumInCart(List<Album> albumInCart) {
		this.albumInCart = albumInCart;
	}
	
	/***
	 * Calculate the total price by adding up all the albums' price
	 * @return
	 */
	public double getTotalPrice() {
		double price = 0.0;
		
		List<Album> albumList = getAlbumInCart();
		for (Album album : albumList) {
			price += album.getPrice();
		}
		
		return price;
	}
	
}
