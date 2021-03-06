package elisha.project.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "user")
public class User {

	public enum Role {
		USER, ADMIN
	}

	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private long id;
	
	@Column(name = "FirstName", nullable=false)
	private String firstName;

	@Column(name = "LastName", nullable=false)
	private String lastName;

	@Column(name = "Email", nullable=false, unique= true)
	@Email
	private String email;

	@Column(name="Active")
	private boolean active;

	@Column(name="Password", nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role = Role.USER;
	
	/*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy ="user")
	private Cart cart; */
	
	@OneToMany
    @JoinColumn(name = "userId")
    private Set<OrderItem> orders;
	
	public User()
	{
		
	}
	
	public User(String firstName, String lastName, String email, boolean active, String password, Role role)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.password = password;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	/*public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	} */

	public Set<OrderItem> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderItem> orders) {
		this.orders = orders;
	}
	
	
	
	
	

}
