package elisha.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elisha.project.entity.ShoppingCart;

@Repository
public interface ShoppingCartDao  extends JpaRepository<ShoppingCart, Long>{

	//List<ShoppingCart> findItems();
}
