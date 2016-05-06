package com.musicstore.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.musicstore.entities.Genre;
import com.musicstore.model.GenreModel;
import com.musicstore.model.ShoppingCartModel;

@Controller
public class HomeController {

	@Resource(name = "genreService")
	private GenreModel genreModel;
	
	@Resource(name = "shoppingCartService")
	private ShoppingCartModel shoppingCartModel;
	
	/**
	 * Map Root of the Homepage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getIndexPage(ModelMap model) {
		
		List<Genre> myGenreList = genreModel.findAllGenre();
		model.put("genreList", myGenreList);		//Display all the available genres
		
		model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size()); //Display the current items in the Cart
		
		return "index";
	}
}
