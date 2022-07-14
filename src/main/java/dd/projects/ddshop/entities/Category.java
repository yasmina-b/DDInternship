package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name = "name", length = 256, nullable = false)
    public String name;

    @OneToMany (mappedBy = "categoryId")
    public List <Subcategory> subcategory;

}
