package com.musicstore.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCartIDKey")
	@SequenceGenerator(name = "seqCartIDKey", sequenceName = "SEQ_CARTID_KEY", allocationSize = 1)
	private int recordId;
	
	@Column
	private int cartId;
	
	@Column
	private int count;
	
	@Column
	private Date dateCreated;
	
	@ManyToOne
	private Album album;
	
	public Cart() {}

	public Cart(int cartId, int count, Date dateCreated,
			Album album) {
		super();
		this.cartId = cartId;
		this.count = count;
		this.dateCreated = dateCreated;
		this.album = album;
	}


	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	};
	
}
