package elisha.project.service;

import java.util.ArrayList;
import java.util.List;

import elisha.project.entity.Category;
import elisha.project.entity.Item;

public interface ItemService {
	
	void save(Item item);
	void delete(Item item);
	List<Item> findAll();
	Item findById(int id);
	
	List<Item> findByCategory(Category category);
	List<Item> searchByManufacturer(String manufacturer);
	List<Item> searchByTitle(String title);
	List<Item> findAscendingPrice();
	List<Item> findDescendingPrice();
	
	ArrayList<Item> findByTitle(String itemName);
	

}
