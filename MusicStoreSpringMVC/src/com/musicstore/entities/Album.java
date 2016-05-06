package com.musicstore.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlbumIDKey")
	@SequenceGenerator(name = "seqAlbumIDKey", sequenceName = "SEQ_ALBUMID_KEY", allocationSize = 1)
	private int albumId;
	
	@Column
	private String title;
	
	@Column
	private double price;
	
	@Column
	private String albumArtUrl;
	
	@ManyToOne
	private Cart cart;
	
	@ManyToOne
	private Genre genre;
	
	@ManyToOne
	private Artist artist;
	
	@OneToMany(mappedBy="album", targetEntity=OrderDetail.class, cascade=CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	public Album() { }


	public Album(String title, double price, String albumArtUrl, Genre genre,
			Artist artist) {
		super();
		this.title = title;
		this.price = price;
		this.albumArtUrl = albumArtUrl;
		this.genre = genre;
		this.artist = artist;
	}


	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAlbumArtUrl() {
		return albumArtUrl;
	}

	public void setAlbumArtUrl(String albumArtUrl) {
		this.albumArtUrl = albumArtUrl;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	
	
}
