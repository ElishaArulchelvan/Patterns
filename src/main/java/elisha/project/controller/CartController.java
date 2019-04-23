package elisha.project.controller;


import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import elisha.project.entity.Cart;
import elisha.project.entity.CartItem;
import elisha.project.entity.Item;
import elisha.project.entity.ShoppingCart;
import elisha.project.entity.User;
import elisha.project.service.CartItemService;
import elisha.project.service.ItemService;
import elisha.project.service.ShoppingCartService;
import elisha.project.service.UserService;

@Controller
@Transactional
public class CartController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private Cart cart;
	
	
	@RequestMapping("/addItem")
	private String addItem(@ModelAttribute("item") Item item, Model model, Principal principal)
	{
		String email = principal.getName();
		User user = userService.findByEmail(email);
		item = itemService.findById(item.getItemId());
		
		cartItemService.addItem(item, user);
		model.addAttribute("success", true);
		return "redirect:/viewItems";
		
	}
	
	@RequestMapping("/newCart/{itemId}")
	public String newCart(@PathVariable("itemId") Long itemId, Model model, Principal principal)
	{
		String email = principal.getName();
		User user = userService.findByEmail(email);
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItems = cartItemService.findAll();
		Item item = itemService.findById(itemId);
		cart.addItem(item,1);
		System.out.println("Cart item list " + cartItems);
		
		model.addAttribute("cartItemList", cartItems);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}
	
	/*@RequestMapping(value="/shoppingCart", method = RequestMethod.GET)
	public String getCart(Model model)
	{

		model.addAttribute(cart);
		return "shoppingCart";
	}*/
	
	@RequestMapping(value="/add/{itemId}")
	public String addItem(@PathVariable("itemId") Long itemId, Model model, Principal principal)
	{
		
		Item item = itemService.findById(itemId);
		System.out.println("Item is " + item.getTitle());
		cart.addItem(item, 1);
		System.out.println("THE CART IS " + cart.getContents());
		
		return "shoppingCart";
	}

	
	
	/*@RequestMapping(value="/add/{itemId}")
	public String addItem(@PathVariable("itemId") Long itemId, Model model)
	{
		Item item = itemService.findById(itemId);
		shoppingCart.addItem(item);
		List<ShoppingCart> cartItems = shoppingCartService.findItems();
		model.addAttribute("cartItems", cartItems);
		return "shoppingCart";
	}*/
	

	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public String showCart(Model model){
		model.addAttribute(cart);
		return "shoppingCart";
	}

}
