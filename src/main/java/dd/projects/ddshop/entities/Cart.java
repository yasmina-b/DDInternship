package dd.projects.ddshop.entities;

import dd.projects.ddshop.dtos.CartEntryDTO;
import dd.projects.ddshop.dtos.UserDTO;
import dd.projects.ddshop.mappers.CartMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="cart")
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public User userId;

    @Column(name = "total_price", nullable = false)
    public double totalPrice;

    @OneToMany(mappedBy = "cartId")
    public List <CartEntry> cartEntry;

    public Cart(User userId, double totalPrice, List<CartEntryDTO> cartEntries) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.cartEntry = new ArrayList<>();
    }
}
