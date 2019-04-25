package elisha.project.controller;


import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import elisha.project.entity.Item;
import elisha.project.entity.OrderItem;
import elisha.project.entity.User;
import elisha.project.service.ItemService;
import elisha.project.service.OrderService;
import elisha.project.service.UserService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String getOrdersPage(Model model) {
		
		List<OrderItem> orders = orderService.findAll();
		model.addAttribute("orderList", orders);
		return "orders";
	}
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String getAddOrder(Model model) {

		//List<User> users = userService.findAll();
		//model.addAttribute("usersList", users);
		List<Item> items = itemService.findAll();
		model.addAttribute("itemList", items);
		return "addOrder";
	}

	@RequestMapping(value = { "/addOrder" }, method = RequestMethod.POST)
	public ModelAndView makeOrder(@RequestParam("item") String item, Principal principal, Model model)
	{
		String email = principal.getName();
		User user = userService.findByEmail(email);
		
		int i = Integer.parseInt(item);
		Item item1 = itemService.findById(i);
		
		double price = item1.getPrice();
		System.out.println("PRICE IS " + price);
		
		Set<Item> items = new HashSet<>();
		items.add(item1);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setUser(user);
		orderItem.setItems(items);
		orderItem.setTotal(price);
		
		
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("orderItem", orderItem);
		orderService.save(orderItem);
		
		
		return  mv;
	
	}
	
	@RequestMapping(value="/userOrder", method = RequestMethod.GET)
	public String showUserOrder(Principal principal, Model model)
	{
		
		String email = principal.getName();
		User user = userService.findByEmail(email);
		
		
		System.out.println("user id: " + user.getFirstName());
		OrderItem orders = orderService.findByUserId(user.getId());
		System.out.println("MY order: " + orders);
		model.addAttribute("orders", orders);
		
		return "myOrder";
	}
}
