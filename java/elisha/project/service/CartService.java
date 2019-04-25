package elisha.project.service;

import java.util.List;

import elisha.project.entity.Cart;




public interface CartService {
	
	Cart findById(int id);

    Cart findByUserId(long id);

    void saveCart(Cart cart);

} 
