package elisha.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itemId")
	private int id;
	
	@Column(nullable = false, unique = true)
	private String title;
	
	@Column(nullable = false, unique = true)
	private String manufacturer;
	
	@Column(nullable = false, unique = true)
	private double price;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private Category category;
	
	@Column(nullable = false, unique = true)
	private int quantity;
	
	
	
	//private byte[] image;
	
	public Item()
	{
		
	}
	
	public Item(String title, String manufacturer, double price, Category category, int quantity)
	{
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	/*public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}*/
	
	
	
	

}
