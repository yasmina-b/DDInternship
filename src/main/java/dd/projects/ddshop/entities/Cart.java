package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    @OneToOne
    @JoinColumn(name = "user_id")
    public User userId;

    @Column(name = "total_price", nullable = false)
    public double totalPrice;

    @OneToMany(mappedBy = "cartId")
    public List <CartEntry> cartEntry;

}
