package elisha.project.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elisha.project.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Long>{

	Cart findById(int id);

    Cart findByUserId(Long userId);
}
