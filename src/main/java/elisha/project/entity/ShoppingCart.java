package elisha.project.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="ShoppingCart")
@Entity
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shoppingCartId")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItem> cartItems;
	
	@OneToMany(mappedBy="shoppingCart", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> items;
	
	private BigDecimal total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
	

}
