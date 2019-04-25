package elisha.project.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elisha.project.dao.CartDao;
import elisha.project.entity.Cart;
import elisha.project.entity.Item;
import elisha.project.service.CartService;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	//@Autowired
	//private CartItemService cartItemService;

	@Override
	public Cart findById(int id) {
		
		return cartDao.findById(id);
	}


	@Override
	public void saveCart(Cart cart) {
		
		cartDao.save(cart);
		
	}

	@Override
	public Cart findByUserId(long id) {
		
		return cartDao.findByUserId(id);
	}

	
	

	

} 
