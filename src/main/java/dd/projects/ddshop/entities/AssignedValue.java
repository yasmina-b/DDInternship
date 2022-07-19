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
@Table(name="assigned_value")
@NoArgsConstructor
public class AssignedValue {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @OneToOne
    @JoinColumn(name = "product_attribute_id")
    public ProductAttribute productAttributeId;

    @OneToOne
    @JoinColumn(name = "attribute_value_id")
    public AttributeValue attributeValueId;

    @ManyToMany(mappedBy = "assignedValues")
    public List<Variant> variant;

    public AssignedValue(AttributeValue value, ProductAttribute productAttribute) {
        this.attributeValueId = value;
        this.productAttributeId = productAttribute;
        this.variant = new ArrayList<>();
    }
}
