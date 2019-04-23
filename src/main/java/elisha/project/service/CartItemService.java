package elisha.project.service;

import java.util.List;

import elisha.project.entity.CartItem;
import elisha.project.entity.Item;
import elisha.project.entity.ShoppingCart;
import elisha.project.entity.User;

public interface CartItemService {
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	CartItem addItem(Item item, User user);
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem findById(Long id);
	CartItem save(CartItem cartItem);
	List<CartItem> findAll();

}
