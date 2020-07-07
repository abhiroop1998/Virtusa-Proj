package com.clothstore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clothstore.domain.CartItem;
import com.clothstore.domain.Cloth;
import com.clothstore.domain.ShoppingCart;
import com.clothstore.domain.User;
import com.clothstore.service.CartItemService;
import com.clothstore.service.ClothService;
import com.clothstore.service.ShoppingCartService;
import com.clothstore.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ClothService clothService;

	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();

		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

		shoppingCartService.updateShoppingCart(shoppingCart);

		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);

		return "shoppingCart";
	}
	
	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("cloth") Cloth cloth,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		cloth = clothService.findById(cloth.getId());
		
		if (Integer.parseInt(qty) > cloth.getStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/clothDetail?id="+cloth.getId();
		}
		
		CartItem cartItem = cartItemService.addClothToCartItem(cloth, user, Integer.parseInt(qty));
		model.addAttribute("addClothSuccess", true);
		
		return "forward:/clothDetail?id="+cloth.getId();
	}
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(
			@ModelAttribute("id") Long cartItemId,
			@ModelAttribute("qty") int qty
			) {
		CartItem cartItem = cartItemService.findById(cartItemId);
		cartItem.setQty(qty);
		cartItemService.updateCartItem(cartItem);
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) {
		cartItemService.removeCartItem(cartItemService.findById(id));
		
		return "forward:/shoppingCart/cart";
	}

}
