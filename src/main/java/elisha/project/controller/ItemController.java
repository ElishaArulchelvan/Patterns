package elisha.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import elisha.project.entity.Category;
import elisha.project.entity.Item;
import elisha.project.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = {"/addItem"}, method = RequestMethod.GET)
	public String getAddItemPage(Model model)
	{
		Item item = new Item();
		Category[] categoryList = Category.values();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("itemForm", item);
		return "addItem";
	}
	
	/*@RequestMapping(value = {"/addItem"}, method = RequestMethod.POST)
	public ModelAndView addItem(@RequestParam("title") String title, @RequestParam("manufacturer") String manufacturer, @RequestParam("price") double price, @RequestParam("category") Category category )
	{
		Item item = new Item();
		item.setPrice(price);
		item.setTitle(title);
		item.setManufacturer(manufacturer);
		item.setCategory(category);
		
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("item", item);
		
		itemService.save(item);
		return mv;
	
	}*/
	
	@RequestMapping(value= {"/addItem"}, method = RequestMethod.POST)
	@Transactional(propagation = Propagation.NEVER)
	public String addItem(@ModelAttribute("itemForm") @Valid Item item, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addItem";
		}
		try {
			System.out.println("MANU " + item.getManufacturer());
			itemService.save(item);
			return "success";
		}
		catch(Exception e)
		{
			return "addItem";
		}
		
	}
	
	@RequestMapping(value="/viewItems", method = RequestMethod.GET)
	public String showItems(Model model, Long id)
	{
		
		List<Item> items = itemService.findAll();
		model.addAttribute("itemList", items);
		return "viewItems";
	}
	
	
	
	@RequestMapping(value = {"/delete/{itemId}"}, method = RequestMethod.GET)
	public String deleteItem(@PathVariable Long itemId, Model model)
	{
		
		Item item = itemService.findById(itemId);
		itemService.delete(item);
		return "success";
	}
	
	@RequestMapping(value = "/ascendingPrice", method = RequestMethod.GET)
	public String ascendingPriceManu(Model model, @RequestParam(value = "manufacturer", defaultValue = "") String name)
	{
		List<Item> itemList = itemService.findAscendingPrice();
		model.addAttribute("itemList", itemList);
		return "viewItems";
	}
	
	@RequestMapping(value = "/descendingPrice", method = RequestMethod.GET)
	public String descendingPrice(Model model, @RequestParam(value = "manufacturer", defaultValue = "") String name)
	{
		List<Item> itemList = itemService.findDescendingPrice();
		model.addAttribute("itemList", itemList);
		return "viewItems";
	}
	
	@RequestMapping(value = {"/edit/{itemId}"}, method = RequestMethod.GET)
	public String editItem(Model model, @PathVariable Long itemId)
	{
		Item item = itemService.findById(itemId);
		model.addAttribute("itemForm", item);
		return "addItem";
	}
	
	@RequestMapping(value = "/item/{itemId}")
	public String showBookById(@PathVariable("itemId") Long itemId, Model model) {

		
		Item item = itemService.findById(itemId);
		model.addAttribute("item", item);

		return "item";
	}

	

}
