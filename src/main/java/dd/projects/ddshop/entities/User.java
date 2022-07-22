package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name", length = 256, nullable = false)
    public String firstName;

    @Column(name = "last_name", length = 256, nullable = false)
    public String lastName;

    @Column(name = "email", length = 256, nullable = false)
    public String email;

    @Column(name = "phone_number", length = 15, nullable = false)
    public String phoneNumber;

    @Column(name = "password", length = 256, nullable = false)
    public String password;

    @OneToOne
    @JoinColumn(name = "default_delivery_address")
    public Address defaultDeliveryAddress;

    @OneToOne
    @JoinColumn(name = "default_billing_address")
    public Address defaultBillingAddress;


}
