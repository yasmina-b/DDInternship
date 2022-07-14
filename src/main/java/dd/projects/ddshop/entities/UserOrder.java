package dd.projects.ddshop.entities;

import dd.projects.ddshop.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="user_order")
public class UserOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User userId;

    @OneToOne
    @JoinColumn(name = "cart_id")
    public Cart cartId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    public PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "delivery_address")
    public Address deliveryAddress;

    @OneToOne
    @JoinColumn(name = "invoice_address")
    public Address invoiceAddress;

    @Column(name = "total_price", nullable = false)
    public double totalPrice;

    @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date orderDate;

}
