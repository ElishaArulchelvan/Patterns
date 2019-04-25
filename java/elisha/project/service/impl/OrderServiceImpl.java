package elisha.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elisha.project.dao.OrderDao;
import elisha.project.entity.OrderItem;
import elisha.project.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderItem findById(int id) {
		
		return orderDao.findById(id);
	}

	@Override
	public OrderItem findByUserId(Long id) {
		
		return orderDao.findByUserId(id);
	}

	@Override
	public void save(OrderItem orderItem) {
		
		orderDao.save(orderItem);
		
	}

	@Override
	public List<OrderItem> findAll() {
		
		return orderDao.findAll();
	}

}
