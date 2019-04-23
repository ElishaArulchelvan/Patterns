package elisha.project.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
	
	private Map<Item, Integer> contents = new HashMap<>();
	
	public void addItem(Item item, int count)
	{
		if(contents.containsKey(item))
		{
			contents.put(item, contents.get(item) + count);
		}
		else
		{
			contents.put(item, count);
		}
	}
	
	public void removeItem(Item item)
	{
		contents.remove(item);
	}
	
	public void clearCart()
	{
		contents.clear();
	}
	
	public double getTotal()
	{
		double total =0;
		for(Item item: contents.keySet())
		{
			total = item.getPrice();
		}
		return total;
	}

	public Map<Item, Integer> getContents() {
		return contents;
	}

	public void setContents(Map<Item, Integer> contents) {
		this.contents = contents;
	}
	
	

}
