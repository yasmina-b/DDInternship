package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "subcategory")
@NoArgsConstructor
public class Subcategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;

  @Column(name = "name", length = 256, nullable = false)
  public String name;

  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  public Category categoryId;

  @OneToMany (mappedBy = "subcategoryId")
  public List<Product> products;

  @ManyToMany(mappedBy = "subcategories", cascade = CascadeType.ALL)
  public List <ProductAttribute> productAttributes;

  public Subcategory(String name, Category category) {
    this.name = name;
    this.categoryId = category;
  }
}
