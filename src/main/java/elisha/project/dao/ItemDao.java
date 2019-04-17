package elisha.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elisha.project.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
	
	

}
