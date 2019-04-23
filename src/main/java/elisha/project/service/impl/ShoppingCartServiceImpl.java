package elisha.project.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elisha.project.dao.ShoppingCartDao;
import elisha.project.entity.CartItem;
import elisha.project.entity.Item;
import elisha.project.entity.ShoppingCart;
import elisha.project.service.CartItemService;
import elisha.project.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Autowired
	private CartItemService cartItemService;
	

	@Override
	public ShoppingCart update(ShoppingCart shoppingCart) {
		
		BigDecimal total = new BigDecimal(0);
		List<CartItem> cartItems = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem: cartItems)
		{
			cartItemService.updateCartItem(cartItem);
			total = total.add(cartItem.getSubTotal());
		}
		
		shoppingCart.setTotal(total);
		shoppingCartDao.save(shoppingCart);
		
		return shoppingCart;
	}

	@Override
	public void clearShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
	
		
	}

	

}
