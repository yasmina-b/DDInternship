package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="product")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name = "name", length = 256, nullable = false)
    public String name;

    @Column(name = "description", length = 256, nullable = false)
    public String description;

    @ManyToOne()
    @JoinColumn(name = "subcategory_id")
    public Subcategory subcategoryId;

    @OneToMany (mappedBy = "productId", cascade = CascadeType.ALL)
    public List<Variant> variant;

    public Product(String name, String description, Subcategory subcategory) {
        this.name = name;
        this.description = description;
        this.subcategoryId = subcategory;
        this.variant = new ArrayList<>();
    }

    public Product(Product toProduct, Subcategory subcategory) {
        this.id = toProduct.getId();
        this.name = toProduct.getName();
        this.description = toProduct.getDescription();
        this.subcategoryId = subcategory;

    }
}
