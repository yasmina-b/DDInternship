package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="attribute_value")
public class AttributeValue {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @Column(name = "value", length = 256, nullable = false)
    public String value;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    public ProductAttribute productAttributeId;

}

