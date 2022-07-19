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
@Table(name="product_attribute")
@NoArgsConstructor
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name = "name", length = 256, nullable = false)
    public String name;

    @OneToMany(mappedBy = "productAttributeId", cascade = CascadeType.ALL)
    public List <AttributeValue> attributeValue;

    @ManyToMany
    @JoinTable(name = "subcategory_product_attribute",
            joinColumns = @JoinColumn(name = "product_attribute_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id",
                    referencedColumnName = "id"))
    private List<Subcategory> subcategories;

    public ProductAttribute(String name) {
        this.name = name;
        this.attributeValue = new ArrayList<>();
        this.subcategories = new ArrayList<>();
    }
}
