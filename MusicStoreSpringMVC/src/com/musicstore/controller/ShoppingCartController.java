package com.musicstore.controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.musicstore.entities.Album;
import com.musicstore.entities.Cart;
import com.musicstore.entities.Users;
import com.musicstore.model.AlbumModel;
import com.musicstore.model.ShoppingCartModel;

@Controller
public class ShoppingCartController {

	@Resource(name = "albumService")
	private AlbumModel albumModel;

	@Resource(name = "shoppingCartService")
	private ShoppingCartModel shoppingCartModel;

	@RequestMapping(value = "/ShoppingCart", method = RequestMethod.GET)
	public String getShoppingCartPage(
			@RequestParam(value = "deletedAlbumID", required = false) Integer deletedAlbumID,
			HttpServletRequest request, HttpSession session, ModelMap model) {

		// Format the Decimal number
		NumberFormat formatter = new DecimalFormat("#0.00");

		Album myAlbum = null;
		Cart myCart = new Cart();
		String totalPrice = "";

		/*
		 * If users want to delete the album, find the album by reference ID,
		 * remove it from the cart Otherwise,
		 * Add it into a new cart
		 */
		if (deletedAlbumID != null) {
			myAlbum = albumModel.findAlbumById(deletedAlbumID);
			
			if (shoppingCartModel.remove(myAlbum))
				model.addAttribute("removedAlbumInfo", myAlbum.getTitle()
						+ " has been removed from your shopping cart.");
				
		} else {

			// Generate shopping cart Id
			shoppingCartModel.generateCartId();

			// Find the album that user want to add into shopping cart
			int addedAlbumId = (Integer) request.getSession().getAttribute(
					"addedAlbumId");
			myAlbum = albumModel.findAlbumById(addedAlbumId);

			shoppingCartModel.getAlbumInCart().add(myAlbum);
		}

		// Format the price of the whole shopping cart
		totalPrice = formatter.format(shoppingCartModel.getTotalPrice());
		
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("albumList", shoppingCartModel.getAlbumInCart());
		model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size());
		model.addAttribute("myCart", myCart);

		return "ShoppingCart";
	}

	@RequestMapping(value = "/ShoppingCart", method = RequestMethod.POST)
	public String setShoppingCartPage(
			@RequestParam(value = "deletedAlbumID", required = false) Integer deletedAlbumID,
			@ModelAttribute("myCart") Cart myCart, ModelMap model) {

		model.addAttribute("myCartId", shoppingCartModel.getCurrentCartNumber());

		// Prepare information for login page
		Users tempUsers = new Users();
		model.addAttribute("login", tempUsers);

		return "Login";
	}

}
