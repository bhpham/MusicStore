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

import com.musicstore.entities.Album;
import com.musicstore.entities.Artist;
import com.musicstore.entities.Genre;

@Component
@Service("albumService")
public class AlbumModel {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	private GenreModel genreModel;
	
	@Autowired
	private ArtistModel artistModel;
	
	@Transactional
	public void create(Album album) {
		Session session = sessionFactory.getCurrentSession();
		session.save(album);
	}
	
	@Transactional
	public List<Album> findAllAlbums() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Album> albumList = new ArrayList<Album>();
		try {
			Query query = session.createQuery("from Album");
			albumList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return albumList;
	}
	
	@Transactional
	public Album findAlbumById(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Album> albumList = new ArrayList<Album>();
		
		try {
			Query query = session.createQuery("from Album where albumId = :id");
			query.setParameter("id", id);
			albumList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't find this particular album by Id: " + id);
		}
		
		return albumList.get(0);
	}
	
	/**
	 * Find a genre when we know its ID
	 * @param id
	 * @return
	 */
	@Transactional
	public Genre findGenreByIdFromAlbumDao(int id) {
		return (genreModel.findGenreById(id));
	}
	
	/**
	 * Find an Artist when we know its ID
	 * @param id
	 * @return
	 */
	@Transactional
	public Artist findArtistByIdFromAlbumDao(int id) {
		return (artistModel.findArtistById(id));
	}

	@Transactional
	public void edit(Album album) {
		Session session = sessionFactory.getCurrentSession();
		// TODO Auto-generated method stub
		Album newAlbum = findAlbumById(album.getAlbumId());
		newAlbum.setGenre(album.getGenre());
		newAlbum.setArtist(album.getArtist());
		newAlbum.setTitle(album.getTitle());
		newAlbum.setPrice(album.getPrice());
		newAlbum.setAlbumArtUrl(album.getAlbumArtUrl());
		
		session.merge(newAlbum);
	}

	@Transactional
	public void delete(Album album) {
		Session session = sessionFactory.getCurrentSession();
		Album myAlbum = findAlbumById(album.getAlbumId());
		session.delete(myAlbum);
	}
	
}
