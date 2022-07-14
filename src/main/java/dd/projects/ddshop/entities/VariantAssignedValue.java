package dd.projects.ddshop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name="variant_assigned_value")
public class VariantAssignedValue {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    public Variant variantId;

    @ManyToOne
    @JoinColumn(name = "assigned_value_id")
    public AssignedValue assignedValueId;
}
