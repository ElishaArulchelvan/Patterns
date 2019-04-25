package elisha.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cart")
public class Cart {
	

	@Id
	@Column(name = "cartId")
	private int id;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "cart")
	private Set<CartItem> cartItem;

	//private double totalPrice;
	
	public Cart()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public double total()
	{
		double total = 0;
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.addAll(this.getCartItem());

        for (int i = 0; i < cartItems.size(); i++) {
            //Item item = cartItems.get(i).getItem();
            //total += item.getPrice() * cartItems.get(i).getQuantity();
        }

        return total;
	}
	
	

}
