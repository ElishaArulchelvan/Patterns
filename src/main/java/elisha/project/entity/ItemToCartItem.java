package elisha.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ItemToCartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="itemToCartId")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="itemId")
	private Item item;

	@ManyToOne
	@JoinColumn(name="cartItemId")
	private CartItem cartItem;

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

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	
	
}
