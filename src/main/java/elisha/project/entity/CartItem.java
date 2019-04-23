package elisha.project.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CartItemId")
	private Long id;
	
	@OneToOne
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="shoppingCartId")
	private ShoppingCart shoppingCart;
	
	@OneToMany(mappedBy = "cartItem")
	private List<ItemToCartItem> itemToCartItemList;
	
	private BigDecimal subTotal;
	
	private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<ItemToCartItem> getItemToCartItemList() {
		return itemToCartItemList;
	}

	public void setItemToCartItemList(List<ItemToCartItem> itemToCartItemList) {
		this.itemToCartItemList = itemToCartItemList;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
