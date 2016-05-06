package com.musicstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrderDetailIDKey")
	@SequenceGenerator(name = "seqOrderDetailIDKey", sequenceName = "SEQ_ORDERDETAILID_KEY", allocationSize = 1)
	private int odId;
	
	@Column
	private int quantity;
	
	@Column
	private double price;
	
	@ManyToOne
	private Album album;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Order order;
	
	public OrderDetail() {}

	public OrderDetail(int odId, int quantity, double price, Album album,
			Order order) {
		super();
		this.odId = odId;
		this.quantity = quantity;
		this.price = price;
		this.album = album;
		this.order = order;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	};
	
}
