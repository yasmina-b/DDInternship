package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "subcategory")
public class Subcategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;

  @Column(name = "name", length = 256, nullable = false)
  public String name;

  @ManyToOne
  @JoinColumn(name = "category_id")
  public Category categoryId;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "subcategory_product_attribute",
          joinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "product_attribute_id",
                  referencedColumnName = "id"))
  private List<ProductAttribute> productAttributeList;

}
