package elisha.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import elisha.project.entity.OrderItem;

public interface OrderDao extends JpaRepository<OrderItem, Long>{
	
	OrderItem findById(int id);
	OrderItem findByUserId(Long id);

}
