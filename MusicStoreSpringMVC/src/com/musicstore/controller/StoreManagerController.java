package com.musicstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.musicstore.entities.Album;
import com.musicstore.entities.Artist;
import com.musicstore.entities.Genre;
import com.musicstore.model.AlbumModel;
import com.musicstore.model.ArtistModel;
import com.musicstore.model.GenreModel;

@Controller
@RequestMapping("/StoreManager")
public class StoreManagerController {

	@Resource(name = "genreService")
	private GenreModel genreModel;

	@Resource(name = "albumService")
	private AlbumModel albumModel;

	@Resource(name = "artistService")
	private ArtistModel artistModel;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getStoreManagerPage(HttpServletRequest request,
			HttpSession session, ModelMap model) {

		List<Album> albumList = new ArrayList<Album>();
		model.put("albumList", albumList);

		return new ModelAndView("StoreManager", "albumModel", albumModel);
	}

	/**
	 * Map to CreateAlbum.jsp to create the new albums
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/CreateAlbum", method = RequestMethod.GET)
	public String getCreateAlbumPage(ModelMap model) {
		Album myAlbum = new Album();

		List<Genre> genreList = genreModel.findAllGenre();
		List<Artist> artistList = artistModel.findAllArtists();

		model.put("genres", genreList);
		model.put("artists", artistList);
		model.addAttribute("createAlbum", myAlbum);

		return "CreateAlbum";
	}

	/***
	 * Map the Create Album - POST
	 * @param genreSelected
	 * @param artistSelected
	 * @param createAlbum
	 * @return
	 */
	@RequestMapping(value="/CreateAlbum", method=RequestMethod.POST)
	public String setCreateAlbumPage(
			@RequestParam("genreSelected") Integer genreSelected,
			@RequestParam("artistSelected") Integer artistSelected,
			@ModelAttribute("createAlbum") Album createAlbum) {
		
		System.out.println("IN the Create Album Page - POST");
		Genre myGenre = genreModel.findGenreById(genreSelected);
		Artist myArtist = artistModel.findArtistById(artistSelected);

		createAlbum.setGenre(myGenre);
		createAlbum.setArtist(myArtist);

		albumModel.create(createAlbum);
		
		return "redirect:";
	}

	/***
	 * Map the Album Detail for the Store manager Page
	 * 
	 * @param detailsAlbumId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/DetailsAlbum", method = RequestMethod.GET)
	public String getDetailsAlbumPage(
			@RequestParam("detailsAlbumId") Integer detailsAlbumId,
			ModelMap model) {
		System.out.println("IN THE DETAILS ALBUm");
		// Logger.debug("Just got Details Album Page - GET");
		Album myAlbum = albumModel.findAlbumById(detailsAlbumId);

		model.put("detailsAlbumId", detailsAlbumId);
		model.put("detailsAlbum", myAlbum);

		return "DetailsAlbum";
	}

	/***
	 * Mapping Edit Album - Get to the EditAlbum.jsp page
	 * 
	 * @param editAlbumId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/EditAlbum", method = RequestMethod.GET)
	public String getEditAlbumPage(
			@RequestParam("editAlbumId") Integer editAlbumId, ModelMap model) {
		System.out.println("In the Edit album");

		Album myAlbum = albumModel.findAlbumById(editAlbumId);
		List<Genre> genreList = genreModel.findAllGenre();
		List<Artist> artistList = artistModel.findAllArtists();

		model.put("genres", genreList);
		model.put("artists", artistList);

		model.put("selectedGenre", myAlbum.getGenre().getName());
		model.put("selectedArtist", myAlbum.getArtist().getArtistName());

		model.addAttribute("editAlbum", myAlbum);

		return "EditAlbum";
	}

	/***
	 * Mapping Edit Album - POST
	 * 
	 * @param albumArtUrl
	 * @param price
	 * @param txtTitle
	 * @param genreSelected
	 * @param artistSelected
	 * @param editAlbumId
	 * @param editAlbum
	 * @return
	 */
	@RequestMapping(value = "/EditAlbum", method = RequestMethod.POST)
	public String setEditAlbumPage(
			@RequestParam("albumArtUrl") String albumArtUrl,
			@RequestParam("price") String price,
			@RequestParam("title") String txtTitle,
			@RequestParam("genreSelected") Integer genreSelected,
			@RequestParam("artistSelected") Integer artistSelected,
			@RequestParam("editAlbumId") Integer editAlbumId,
			@ModelAttribute("editAlbum") Album editAlbum) {
		System.out.println("In the POST Album Page");
		Album myAlbum = albumModel.findAlbumById(editAlbumId);

		Genre myGenre = genreModel.findGenreById(genreSelected);
		myAlbum.setGenre(myGenre);

		myAlbum.setTitle(txtTitle);
		Artist myArtist = artistModel.findArtistById(artistSelected);

		myAlbum.setArtist(myArtist);
		myAlbum.setPrice(Double.parseDouble(price));

		myAlbum.setAlbumArtUrl(albumArtUrl);

		albumModel.edit(myAlbum);

		return "redirect:";
	}
	
	/***
	 * Mapping to deleteAlbumpage - GET
	 * @param deleteAlbumId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/DeleteAlbum", method=RequestMethod.GET)
	public String deleteAlbumPage(@RequestParam("deleteAlbumId") Integer deleteAlbumId, ModelMap model) {
	
		Album myAlbum = albumModel.findAlbumById(deleteAlbumId);
		
		model.put("deleteThisAlbum", myAlbum);
		model.addAttribute("deleteAlbum", myAlbum);
		
		return "DeleteAlbum";
	}
	
	/***
	 * Set to the DeleteAlbum Page
	 * @param deleteAlbumId
	 * @param deleteAlbum
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/DeleteAlbum", method = RequestMethod.POST)
	public String setDeleteAlbumPage(@RequestParam("deleteAlbumId") Integer deleteAlbumId,@ModelAttribute("deleteAlbum") Album deleteAlbum, ModelMap model) {
		
		Album myAlbum = albumModel.findAlbumById(deleteAlbumId);
		
		model.put("deleteThisAlbum", myAlbum);
		
		albumModel.delete(myAlbum);
		
		return "redirect:";
		
	}
}
