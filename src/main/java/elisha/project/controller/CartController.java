package elisha.project.controller;


import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import elisha.project.entity.Cart;
import elisha.project.entity.CartItem;
import elisha.project.entity.Item;
import elisha.project.entity.User;
import elisha.project.service.CartItemService;
import elisha.project.service.ItemService;
import elisha.project.service.CartService;
import elisha.project.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;


	@RequestMapping("/ShoppingCart/addtocart/{id}")
    public ModelAndView addToCart(@PathVariable("id") Long id)
	{
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());

        Cart cart = cartService.findByUserId(user.getId());
        System.out.println("CART IS " + cart.getCartItem() );
        Item item = itemService.findById(id);
        String itemName = item.getTitle();
        System.out.println("Item title " + itemName);

        ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.addAll(cart.getCartItem());
        boolean exist = true;

        for (int i = 0; i < cartItems.size(); i++) {
            CartItem current = cartItems.get(i); 
            if (current.getItem() == item) {

                int temp = cartItems.get(i).getQuantity();
                cartItems.get(i).setQuantity(temp+1);

                cartItemService.saveCartItems(cartItems.get(i));
                Set<CartItem> updatedList = new HashSet<>(cartItems);
                cart.setCartItem(updatedList);
                exist = false;
            }
        }

        if (exist) 
        {
            CartItem carts = new CartItem(cart, item, 1);
            cartItemService.saveCartItems(carts);
            cartItems.add(carts);

            Set<CartItem> updatedList = new HashSet<>(cartItems);

            
            cart.setCartItem(updatedList);
        }

        cartService.saveCart(cart);

        String successMessage = "";
        model.addObject("successMessage", successMessage);

        ArrayList<Item> items = itemService.findByTitle(itemName);
        model.addObject("items", items);
        model.setViewName("viewItems");

        return model;
    }
	
	@RequestMapping("/Cart")
    public ModelAndView Cart() 
	{
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        Cart cart = cartService.findByUserId(user.getId());

        ArrayList<CartItem> cart_items = new ArrayList<CartItem>();
        cart_items.addAll(cart.getCartItem());

        double total = cart.total();

        model.addObject("cart", cart);
        model.addObject("cartitems", cart_items);
        model.addObject("total", total);
        model.setViewName("Cart");

        return model;
    }
	
	
	

}
