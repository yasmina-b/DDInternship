package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="assigned_value")
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

    @OneToMany(mappedBy = "assignedValueId")
    public List<VariantAssignedValue> variantAssignedValue;
}
