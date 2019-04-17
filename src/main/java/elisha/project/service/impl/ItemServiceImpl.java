package elisha.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elisha.project.dao.ItemDao;
import elisha.project.entity.Item;
import elisha.project.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public void save(Item item) {
		itemDao.save(item);
		
	}

	@Override
	public void delete(Item item) {
		itemDao.delete(item);
		
	}

	@Override
	public List<Item> findAll() {
		
		return itemDao.findAll();
	}

	@Override
	public Item findById(Long id) {
		
		return itemDao.findOne(id);
	}
	
	

}
