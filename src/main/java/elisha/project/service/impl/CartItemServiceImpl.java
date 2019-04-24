package elisha.project.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elisha.project.dao.CartItemDao;
import elisha.project.entity.Cart;
import elisha.project.entity.CartItem;
import elisha.project.entity.Item;
import elisha.project.entity.User;
import elisha.project.service.CartItemService;

@Service("cartItemService")
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public List<CartItem> findByCartId(int cartId) {
		
		return cartItemDao.findByCartId(cartId);
	}

	@Override
	public CartItem findByItemId(Long itemId) {
		
		return cartItemDao.findByItemId(itemId);
	}

	@Override
	public void saveCartItems(CartItem cartItems) {
		
		cartItemDao.save(cartItems);
		
	}
	
	
	
	

}
