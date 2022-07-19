package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.VariantDTO;
import dd.projects.ddshop.entities.AssignedValue;
import dd.projects.ddshop.entities.Variant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VariantMapper {

    public static VariantDTO trans (Variant variant) {
        List<Integer> ids = new ArrayList<>();
        for(AssignedValue assignedValue : variant.getAssignedValues())
            ids.add(assignedValue.getId());
        return new VariantDTO(variant.getPrice(),variant.getAvailableQuantity(),variant.getAddedDate(),variant.getProductId().getId(),ids);
    }

}
