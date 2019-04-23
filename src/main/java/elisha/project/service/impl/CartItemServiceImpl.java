package elisha.project.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elisha.project.dao.CartItemDao;
import elisha.project.dao.ItemToCartItemDao;
import elisha.project.entity.CartItem;
import elisha.project.entity.Item;
import elisha.project.entity.ItemToCartItem;
import elisha.project.entity.ShoppingCart;
import elisha.project.entity.User;
import elisha.project.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private ItemToCartItemDao itemToCartItemDao;

	@Override
	public CartItem addItem(Item item, User user) {
		
		List<CartItem> cartItems = findByShoppingCart(user.getShoppingCart());
		
		for(CartItem cartItem: cartItems)
		{
			if(item.getItemId() == cartItem.getItem().getItemId())
			{
				cartItem.setSubTotal(new BigDecimal(item.getPrice()));
				cartItemDao.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setItem(item);
		cartItem.setSubTotal(new BigDecimal(item.getPrice()));
		
		cartItem = cartItemDao.save(cartItem);
		
		ItemToCartItem itemToCartItem = new ItemToCartItem();
		itemToCartItem.setItem(item);
		itemToCartItem.setCartItem(cartItem);
		itemToCartItemDao.save(itemToCartItem);
		
		return cartItem;
	}

	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		
		return cartItemDao.findByShoppingCart(shoppingCart);
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		
		BigDecimal price = new BigDecimal(cartItem.getItem().getPrice());
		price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubTotal(price);
		
		cartItemDao.save(cartItem);
		return cartItem;
	}

	@Override
	public CartItem findById(Long id) {
		
		return cartItemDao.findOne(id);
	}

	@Override
	public CartItem save(CartItem cartItem) {
		
		return cartItemDao.save(cartItem);
	}

	@Override
	public List<CartItem> findAll() {
		// TODO Auto-generated method stub
		return cartItemDao.findAll();
	}

}
