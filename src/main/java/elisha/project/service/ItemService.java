package elisha.project.service;

import java.util.List;

import elisha.project.entity.Item;

public interface ItemService {
	
	void save(Item item);
	void delete(Item item);
	List<Item> findAll();
	Item findById(Long id);
	

}
