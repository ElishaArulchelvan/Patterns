package elisha.project.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import elisha.project.entity.Category;
import elisha.project.entity.Item;
import elisha.project.entity.User;
import elisha.project.service.ItemService;
import elisha.project.service.UserService;

@Controller
public class SearchController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/searchByCategory")
	public String searchByCategory(@RequestParam("category") Category category, Model model, Principal principal)
	{
		if(principal != null)
		{
			String email = principal.getName();
			User user  = userService.findByEmail(email);
			model.addAttribute("user", user);
		}
		
		List<Item> itemList = itemService.findByCategory(category);
		if(itemList.isEmpty())
		{
			model.addAttribute("emptyList", true);
			return "viewItems";
		}
		
		model.addAttribute("itemList", itemList);
		return "viewItems";
	}
	
	@RequestMapping("/searchByMan")
	public String seachByMan(@ModelAttribute("manufacturer") String manufacturer, Principal principal, Model model)
	{
		List<Item> itemList = itemService.searchByManufacturer(manufacturer);
		if(itemList.isEmpty())
		{
			model.addAttribute("emptyList", true);
			return "viewItems";
		}
		model.addAttribute("itemList", itemList);
		return "viewItems";
	}
	
	@RequestMapping("/searchByTitle")
	public String searchByTitle(@ModelAttribute("title") String title, Principal principal, Model model)
	{
		List<Item> itemList = itemService.searchByTitle(title);
		if(itemList.isEmpty())
		{
			model.addAttribute("emptyList", true);
			return "viewItems";
		}
		model.addAttribute("itemList", itemList);
		return "viewItems";
	
	}

}
