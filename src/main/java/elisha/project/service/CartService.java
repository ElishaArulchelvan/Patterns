package elisha.project.service;

import java.util.List;

import elisha.project.entity.Cart;


public interface CartService {
	
	Cart findById(int id);

    Cart findByUserId(long l);

    void saveCart(Cart cart);

}
