package elisha.fyp.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elisha.fyp.project.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);

}