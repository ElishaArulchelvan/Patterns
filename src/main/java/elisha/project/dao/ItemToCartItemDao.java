package elisha.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elisha.project.entity.CartItem;
import elisha.project.entity.ItemToCartItem;

@Repository
public interface ItemToCartItemDao extends JpaRepository<ItemToCartItem, Long>{
	
	void deleteByCartItem(CartItem cartItem);

}
