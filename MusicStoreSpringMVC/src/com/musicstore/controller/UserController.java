package com.musicstore.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.musicstore.entities.Album;
import com.musicstore.entities.Cart;
import com.musicstore.entities.Genre;
import com.musicstore.entities.Order;
import com.musicstore.entities.OrderDetail;
import com.musicstore.entities.Users;
import com.musicstore.model.AlbumModel;
import com.musicstore.model.GenreModel;
import com.musicstore.model.OrderDetailModel;
import com.musicstore.model.OrdersModel;
import com.musicstore.model.ShoppingCartModel;
import com.musicstore.model.UserModel;
import com.musicstore.model.UserRoleModel;

@Controller
@RequestMapping("/Account")
public class UserController {

	@Resource(name = "genreService")
	private GenreModel genreModel;
	
	@Resource(name = "userService")
	private UserModel userModel;

	@Resource(name = "userRoleService")
	private UserRoleModel userRoleModel;

	@Resource(name = "ordersService")
	private OrdersModel ordersModel;

	@Resource(name = "shoppingCartService")
	private ShoppingCartModel shoppingCartModel;

	@Resource(name = "ordersService")
	private OrdersModel orderModel;

	@Resource(name = "albumService")
	private AlbumModel albumModel;

	@Resource(name = "orderDetailService")
	private OrderDetailModel orderDetailModel;

	/**
	 * Get to the Login page - GET
	 * 
	 * @param error
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getToLoginPage(
			@RequestParam(value = "error", required = false) String error,
			ModelMap model) {

		Users tempUser = new Users();

		model.addAttribute("login", tempUser);
		return "Login";
	}

	/**
	 * Get to the Login page - POST
	 * 
	 * @param error
	 * @param loginUser
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyAccount(
			@RequestParam(value = "error", required = false) boolean error,
			@ModelAttribute("login") Users loginUser, ModelMap model) {

		boolean checkLoginUser = false;
		String destination = "";
		String username = loginUser.getUsername();
		String password = loginUser.getPassword();

		System.out.println("In veryAccount method !");
		if (checkLoginUser = userModel.verifyUser(username, password)) {

			System.out.println("PRINT VALID USER ");
			// Get the number of albums in cart
			int totalAlbum = shoppingCartModel.getAlbumInCart().size();

			Users tempUser = userModel.retrieveUser(loginUser.getUsername());
			Order addedOrder = orderModel.findOrderByUserId(loginUser
					.getUserId());

			Date today = new Date();
			OrderDetail tempOrderDetail = new OrderDetail();
			Album tempAlbum = null;
			Cart tempCart = new Cart();

			List<Album> albumList = shoppingCartModel.getAlbumInCart();
			
			for (int i = 0; i < totalAlbum; i++) {
				tempAlbum = albumModel.findAlbumById(albumList.get(i)
						.getAlbumId());
				tempOrderDetail.setAlbum(tempAlbum);
				tempOrderDetail.setOrder(addedOrder);
				tempOrderDetail.setQuantity(i);
				tempOrderDetail.setPrice(tempAlbum.getPrice());
				orderDetailModel.create(tempOrderDetail);
				
				// Create Cart
				tempCart.setCartId(shoppingCartModel.getCurrentCartNumber());
				tempCart.setAlbum(albumList.get(i));
				tempCart.setCount(1);
				tempCart.setDateCreated(today);
				shoppingCartModel.create(tempCart);
			}

			
			// Put the information into the Checkout page
			model.put("error", "");
			model.put("myCartId", shoppingCartModel.getCurrentCartNumber());
			model.put("itemNumbers", shoppingCartModel.getAlbumInCart().size());
			
			//Store it into the side-bar
			List<Genre> myGenreList = genreModel.findAllGenre();
			model.put("genreList", myGenreList);
			
			destination = "Checkout";
		} else {
			model.put("error",
					"You've entered an invalid username or password !");
			destination = "Login";
		}

		return destination;
	}

	/**
	 * Get to the register page - GET
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView getToRegisterPage(ModelMap model) {
		return new ModelAndView("Register", "userModel", userModel);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model, HttpServletRequest request) {

		Users myUser = new Users();
		String username, password, firstname, lastname;
		int myUserRole = 2;

		System.out.println("In the Register page 	- POST");
		
		// Create new user account
		// Get information of an user object from the view page
		username = request.getParameter("username");
		password = request.getParameter("password");
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");

		if (checkUserExist(username)) {
			
			// put info into new user object
			myUser.setFirstName(firstname);
			myUser.setLastName(lastname);
			myUser.setUsername(username);
			myUser.setPassword(password);
			myUser.setUserRole(userRoleModel
					.findUserRoleByUserRoleId(myUserRole));

			userModel.create(myUser);
			model.put("error", "");

			// Create new shipping information - references to Order object
			Order myOrder = new Order();

			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String postalCode = request.getParameter("postalCode");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");

			Date today = new Date();
			double total = 0.00;

			// Put it into the new Order object
			myOrder.setAddress(address);
			myOrder.setCity(city);
			myOrder.setState(state);
			myOrder.setCountry(country);
			myOrder.setZipCode(postalCode);
			myOrder.setPhone(phone);
			myOrder.setEmail(email);
			myOrder.setOrderDate(today);
			myOrder.setTotal(total);
			myOrder.setUser(myUser);

			ordersModel.create(myOrder);

			return new ModelAndView("storeindex", "userModel", "userModel");
		} else {
			model.put("error",
					"Please choose another username. This has been used");
		}

		return new ModelAndView("Register", "userModel", "userModel");
	}

	/**
	 * Check whether the user is existed or not in the DB
	 * 
	 * @param username
	 * @return
	 */
	private boolean checkUserExist(String username) {
		boolean result = true;

		List<Users> usersFromDB = userModel.retrieveAllUsers();

		for (Users user : usersFromDB) {
			if (user.getUsername().equals(username))
				result = false;
		}

		return result;
	}
	
	
}