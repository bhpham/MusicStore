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

import com.musicstore.entities.Genre;

@Component
@Service("genreService")
public class GenreModel {

	@Autowired
	SessionFactory sessionFactory;
	
	//private Session session = sessionFactory.getCurrentSession();
	
	@Transactional
	public void create(Genre genre) {
		Session session = sessionFactory.getCurrentSession();
		session.save(genre);
	}
	
	@Transactional
	public List<Genre> findAllGenre() {
		Session session = sessionFactory.getCurrentSession();
		List<Genre> genreList = new ArrayList<Genre>();
		
		try {
			Query query = session.createQuery("from Genre");

			genreList = query.list();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Can't find the genres !");
		}
			
		return genreList;
	}
	
	@Transactional
	public Genre findGenreById(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Genre> genreList = new ArrayList<Genre>();
		
		try {
			Query query = session.createQuery("from Genre where genreId = :id");
			query.setParameter("id", id);
			genreList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't find this particular genre by Id: " + id);
		}
		
		return genreList.get(0);
	}
	
}