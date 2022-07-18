package dd.projects.ddshop.entities;

import dd.projects.ddshop.dtos.SubcategoryDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name = "name", length = 256, nullable = false)
    public String name;

    @Column(name = "description", length = 256, nullable = false)
    public String description;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    public Subcategory subcategoryId;

    @OneToMany (mappedBy = "productId")
    public List<Variant> variant;

}
