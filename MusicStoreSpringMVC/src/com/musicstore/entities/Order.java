package com.musicstore.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MUSICORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOrderIDKey")
	@SequenceGenerator(name = "seqOrderIDKey", sequenceName = "SEQ_ORDERID_KEY", allocationSize = 1)
	private int orderId;
	
	@Column
	private String address;
	
	@Column
	private Date orderDate;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zipCode;
	
	@Column
	private String country;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column
	private double total;
	
	@ManyToOne
	private Users user;
	
	@OneToMany(mappedBy="order", targetEntity=OrderDetail.class, cascade=CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	public Order() {}

	public Order(int orderId, String address, Date orderDate, String city,
			String state, String zipCode, String country, String phone,
			double total, Users user) {
		super();
		this.orderId = orderId;
		this.address = address;
		this.orderDate = orderDate;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.phone = phone;
		this.total = total;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	};
	
	
}
