package elisha.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elisha.project.entity.Category;
import elisha.project.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
	
	List<Item> findByCategory(Category category);

}
