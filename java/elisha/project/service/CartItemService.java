package elisha.project.service;

import java.util.List;

import elisha.project.entity.CartItem;
import elisha.project.entity.Item;

import elisha.project.entity.User;

public interface CartItemService {
	
	List<CartItem> findByCartId(int cartId);

    CartItem findByItemId(Long itemId);

    void saveCartItems(CartItem cartItems);

} 
