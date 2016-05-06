package com.musicstore.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArtistIDKey")
	@SequenceGenerator(name = "seqArtistIDKey", sequenceName = "SEQ_ARTISTID_KEY", allocationSize = 1)
	private int artistId;
	
	@Column
	private String artistName;
	
	@OneToMany(mappedBy="artist", targetEntity=Album.class, cascade=CascadeType.ALL)
	private Set<Album> albums;
	
	public Artist(String artistName) {
		super();
		this.artistName = artistName;
	}
	
	public Artist() {}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	};
	
	
	
}
