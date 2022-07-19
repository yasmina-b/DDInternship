package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="variant")
public class Variant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product productId;

    @Column(name = "price", nullable = false)
    public double price;

    @Column(name = "available_quantity", nullable = false)
    public int availableQuantity;

    @Column(name = "added_date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date addedDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "variant_assigned_value",
            joinColumns = @JoinColumn(name = "variant_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "assigned_value_id",
                    referencedColumnName = "id"))
    private List<AssignedValue> assignedValues;



}
