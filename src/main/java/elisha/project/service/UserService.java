package elisha.project.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import elisha.project.entity.User;

public interface UserService extends UserDetailsService{

	void save(User user);
	User findByEmail(String email);
	
}
