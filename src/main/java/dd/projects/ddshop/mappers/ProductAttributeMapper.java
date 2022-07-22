package dd.projects.ddshop.mappers;

import dd.projects.ddshop.dtos.ProductAttributeDTO;
import dd.projects.ddshop.entities.AttributeValue;
import dd.projects.ddshop.entities.ProductAttribute;
import dd.projects.ddshop.entities.Subcategory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductAttributeMapper {

    ProductAttributeDTO toProductAttributeDTO(ProductAttribute productAttribute);

    ProductAttribute toProductAttribute(ProductAttributeDTO productAttributeDTO);
}
