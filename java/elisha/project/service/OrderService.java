package elisha.project.service;

import java.util.List;

import elisha.project.entity.OrderItem;

public interface OrderService {
	
	OrderItem findById(int id);
	OrderItem findByUserId(Long id);
	void save(OrderItem orderItem);
	List<OrderItem> findAll();

}
