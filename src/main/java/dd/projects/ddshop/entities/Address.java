package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "street_line", length = 256, nullable = false)
    public String streetLine;

    @Column(name = "postal_code", nullable = false)
    public int postalCode;

    @Column(name = "city", length = 128, nullable = false)
    public String city;

    @Column(name = "county", length = 128, nullable = false)
    public String county;

    @Column(name = "country", length = 128, nullable = false)
    public String country;

}
