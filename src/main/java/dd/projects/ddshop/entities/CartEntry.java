package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="cart_entry")
public class CartEntry {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name = "quantity", nullable = false)
    public int quantity;

    @Column(name = "price_per_piece", nullable = false)
    public double pricePerPiece;

    @Column(name = "total_price_per_entry", nullable = false)
    public double totalPricePerEntry;

    @OneToOne
    @JoinColumn(name = "variant_id")
    public Variant variantId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    public Cart cartId;



}
