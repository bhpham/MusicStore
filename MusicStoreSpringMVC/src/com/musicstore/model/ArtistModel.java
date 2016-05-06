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

import com.musicstore.entities.Artist;
import com.musicstore.entities.Genre;

@Component
@Service("artistService")
public class ArtistModel {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void create(Artist artist) {
		Session session = sessionFactory.getCurrentSession();
		session.save(artist);
	}

	@Transactional
	public List<Artist> findAllArtists() {
		Session session = sessionFactory.getCurrentSession();
		List<Artist> artistList = new ArrayList<Artist>();
		
		try {
			Query query = session.createQuery("from Artist");

			artistList = query.list();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Can't find the artists !");
		}
			
		return artistList;
	}
	
	@Transactional
	public Artist findArtistById(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Artist> artistList = new ArrayList<Artist>();
		
		try {
			Query query = session.createQuery("from Artist where artistId = :id");
			query.setParameter("id", id);
			artistList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't find this particular artist by Id: " + id);
		}
		
		return artistList.get(0);
	}
	
	
}
