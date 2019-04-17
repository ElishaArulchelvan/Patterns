package elisha.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
	
	@Id
	@GeneratedValue
	private Long itemId;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	@Column(nullable = false, unique = true)
	private String manufacturer;
	
	@Column(nullable = false, unique = true)
	private double price;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private Category category;
	
	//private byte[] image;
	
	public Item()
	{
		
	}
	
	public Item(String title, String manufacturer, double price, Category category)
	{
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
	}

	public Long getItemId()
	{
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/*public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}*/
	
	

}
