package elisha.project.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
public class OrderItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
    private int id;

    @Column(name = "total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "itemId"))
    private Set<Item> items;

    public OrderItem() {

    }

    public OrderItem(double total, User user, Set<Item> items) {
        this.total = total;
        this.user = user;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }



}
