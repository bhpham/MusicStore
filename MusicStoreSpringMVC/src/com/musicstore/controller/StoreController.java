package com.musicstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicstore.entities.Album;
import com.musicstore.entities.Genre;
import com.musicstore.model.AlbumModel;
import com.musicstore.model.GenreModel;
import com.musicstore.model.ShoppingCartModel;

@Controller
@RequestMapping("/Store")
public class StoreController {

	@Resource(name = "genreService")
	private GenreModel genreModel;

	@Resource(name = "albumService")
	private AlbumModel albumModel;
	
	@Resource(name = "shoppingCartService")
	private ShoppingCartModel shoppingCartModel;

	/**
	 * Map Root of the Store
	 * 
	 * @param model
	 * @return storeindex.jsp
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getStoreIndexPage(ModelMap model) {

		List<Genre> myGenreList = genreModel.findAllGenre();
		model.put("genreList", myGenreList);
		model.put("genreCount", myGenreList.size());
		model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size());
		

		return "storeindex";
	}

	/**
	 * Map the Details Page
	 * 
	 * @param albumId
	 * @param model
	 * @return Details.jsp
	 */
	@RequestMapping(value = "/Details", method = RequestMethod.GET)
	public String getStoreDetailsPage(
			@RequestParam(value = "albumId", required = false) Integer albumId,
			ModelMap model) {
		Album tempAlbum = albumModel.findAlbumById(albumId);

		model.put("albumId", albumId);
		model.put("detailedAlbum", tempAlbum);

		model.addAttribute("addedAlbum", tempAlbum);
		
		List<Genre> myGenreList = genreModel.findAllGenre();
		model.put("genreList", myGenreList);
		model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size());

		return "Details";
	}

	/**
	 * Map Details Page - POST
	 * @param albumId
	 * @param addedAlbum
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/Details", method = RequestMethod.POST)
	public String setStoreDetailPage(
			@RequestParam(value = "albumId", required = false) Integer albumId,
			@ModelAttribute("addedAlbum") Album addedAlbum,
			HttpServletRequest request, ModelMap model) {

		model.addAttribute("addedAlbum", addedAlbum);
		request.getSession().setAttribute("addedAlbumId", albumId);
		List<Genre> myGenreList = genreModel.findAllGenre();
		model.put("genreList", myGenreList);
		model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size());
		
		return "redirect:/ShoppingCart/";
	}

	/**
	 * Map the Browsing Page
	 * 
	 * @param genre
	 * @param model
	 * @return Browse.jsp
	 */
	@RequestMapping(value = "/Browse", method = RequestMethod.GET)
	public String getStoreBrowsePage(
			@RequestParam(value = "genre", required = false) String genre,
			ModelMap model) {
		List<Album> foundAlbum = new ArrayList<Album>();

		if (genre == null) {
			model.put("genre", "Empty");
		} else {
			List<Album> myAlbum = albumModel.findAllAlbums();
			for (Album tempAlbum : myAlbum) {

				if (tempAlbum.getGenre().getName().equals(genre)) {
					foundAlbum.add(tempAlbum);
				}
			}
		}

		List<Genre> myGenreList = genreModel.findAllGenre();
		model.put("genreList", myGenreList);
		model.put("genre", genre);
		model.put("foundAlbum", foundAlbum);
		model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size());

		return "Browse";
	}
}
