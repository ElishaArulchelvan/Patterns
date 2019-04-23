package elisha.project.service;

import java.util.List;

import elisha.project.entity.ShoppingCart;

public interface ShoppingCartService {
	
	ShoppingCart update(ShoppingCart shoppingCart);
	void clearShoppingCart(ShoppingCart shoppingCart);
	
	//void save(ShoppingCart shoppingCart);
	//List<ShoppingCart> findItems();

}
