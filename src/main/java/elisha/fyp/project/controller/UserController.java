package elisha.fyp.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import elisha.fyp.project.entity.User;
import elisha.fyp.project.service.UserService;

@Controller
@Transactional
@EnableWebMvc
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public String showUsers(Model model)
	{
		List<User> users = userService.findAll();
		model.addAttribute("usersList", users);
		return "users";
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage() {

		return "register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String registerConfirm(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/login";	

	}

	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.POST)
	public String deleteUser(@PathVariable Long id) {

		userService.delete(id);

		return "redirect:/users";
	}

}